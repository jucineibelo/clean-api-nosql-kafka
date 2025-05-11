package com.jucao.cleanarch.core.usecase.impl;

import com.jucao.cleanarch.core.gateway.FindCustomerByIdGateway;
import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerByIdGateway findCustomerByIdGateway;

    public FindCustomerUseCaseImpl(FindCustomerByIdGateway findCustomerByIdGateway){
        this.findCustomerByIdGateway = findCustomerByIdGateway;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdGateway.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("customer not found"));
    }
}
