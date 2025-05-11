package com.jucao.cleanarch.core.usecase;

import com.jucao.cleanarch.core.domain.Customer;

public interface InsertCustomerUserCase {
    void insert(Customer customer, String zipCode);
}
