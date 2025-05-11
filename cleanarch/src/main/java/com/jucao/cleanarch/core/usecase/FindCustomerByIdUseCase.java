package com.jucao.cleanarch.core.usecase;

import com.jucao.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(final String id);
}
