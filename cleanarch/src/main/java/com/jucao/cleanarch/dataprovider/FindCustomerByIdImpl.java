package com.jucao.cleanarch.dataprovider;

import com.jucao.cleanarch.core.gateway.FindCustomerByIdGateway;
import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.dataprovider.repository.CustomerRepository;
import com.jucao.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerByIdGateway {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper mapper;

    @Override
    public Optional<Customer> findById(String id) {
        var customer = customerRepository.findById(id);
        return customer.map(costumer -> mapper.toCustumer(costumer));
        //cada customer (que é optional<customerEntity é transformado em customer usando uma função de builder do mapper)
    }
}
