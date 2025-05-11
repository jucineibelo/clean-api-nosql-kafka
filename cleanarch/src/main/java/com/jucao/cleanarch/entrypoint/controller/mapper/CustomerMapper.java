package com.jucao.cleanarch.entrypoint.controller.mapper;

import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.jucao.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCostumer(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);
}
