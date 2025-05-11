package com.jucao.cleanarch.entrypoint.controller;

import com.jucao.cleanarch.core.usecase.DeleteCustomerUseCase;
import com.jucao.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.jucao.cleanarch.core.usecase.InsertCustomerUserCase;
import com.jucao.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.jucao.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.jucao.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.jucao.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUserCase insertCustomerUserCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCostumerUseCase;

    @Autowired
    DeleteCustomerUseCase deleteCustomerUseCase;

    @Autowired
    private CustomerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        insertCustomerUserCase.insert(mapper.toCostumer(customerRequest), customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCase.find(id);
        return ResponseEntity.ok().body(mapper.toResponse(customer));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        updateCostumerUseCase.update(mapper.toCostumer(customerRequest), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
