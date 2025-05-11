package com.jucao.cleanarch.core.usecase.impl;

import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.core.gateway.FindAddressByZipCodeGateway;
import com.jucao.cleanarch.core.gateway.UpdateCostumerGateway;
import com.jucao.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.jucao.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCostumerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final FindAddressByZipCodeGateway findAddressByZipCodeGateway;

    private final UpdateCostumerGateway updateCostumerGateway;

    public UpdateCostumerUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                     FindAddressByZipCodeGateway findAddressByZipCodeGateway,
                                     UpdateCostumerGateway updateCostumerGateway) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCodeGateway = findAddressByZipCodeGateway;
        this.updateCostumerGateway = updateCostumerGateway;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        var address = findAddressByZipCodeGateway.find(zipCode);
        findCustomerByIdUseCase.find(customer.getId());
        customer.setAddress(address);
        updateCostumerGateway.update(customer);
    }
}
