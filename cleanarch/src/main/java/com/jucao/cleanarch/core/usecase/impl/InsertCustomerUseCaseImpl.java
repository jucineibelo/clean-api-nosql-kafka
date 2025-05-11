package com.jucao.cleanarch.core.usecase.impl;

import com.jucao.cleanarch.core.producer.SendCpfToValidation;
import com.jucao.cleanarch.core.gateway.FindAddressByZipCodeGateway;
import com.jucao.cleanarch.core.gateway.InsertCustomerGateway;
import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.core.usecase.InsertCustomerUserCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUserCase {

    private final FindAddressByZipCodeGateway findAddressByZipCodeGateway;

    private final InsertCustomerGateway insertCustomerGateway;

    private final SendCpfToValidation sendCpfToValidation;

    public InsertCustomerUseCaseImpl(FindAddressByZipCodeGateway findAddressByZipCodeGateway,
                                     InsertCustomerGateway insertCustomerGateway,
                                     SendCpfToValidation sendCpfToValidation) {
        this.findAddressByZipCodeGateway = findAddressByZipCodeGateway;
        this.insertCustomerGateway = insertCustomerGateway;
        this.sendCpfToValidation = sendCpfToValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeGateway.find(zipCode);
        customer.setAddress(address);
        insertCustomerGateway.insert(customer);
    }
}
