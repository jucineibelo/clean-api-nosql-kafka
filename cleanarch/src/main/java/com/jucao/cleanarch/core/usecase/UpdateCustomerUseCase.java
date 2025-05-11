package com.jucao.cleanarch.core.usecase;

import com.jucao.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
