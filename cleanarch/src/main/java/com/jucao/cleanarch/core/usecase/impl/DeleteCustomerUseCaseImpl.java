package com.jucao.cleanarch.core.usecase.impl;


import com.jucao.cleanarch.core.gateway.DeleteCustomerGateway;
import com.jucao.cleanarch.core.usecase.DeleteCustomerUseCase;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private FindCustomerUseCaseImpl findCustomerUseCase;

    private final DeleteCustomerGateway deleteCustomerGateway;

    public DeleteCustomerUseCaseImpl(FindCustomerUseCaseImpl findCustomerUseCase, DeleteCustomerGateway deleteCustomerGateway) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.deleteCustomerGateway = deleteCustomerGateway;
    }

    @Override
    public void delete(String id) {
        findCustomerUseCase.find(id);
        deleteCustomerGateway.delete(id);
    }
}
