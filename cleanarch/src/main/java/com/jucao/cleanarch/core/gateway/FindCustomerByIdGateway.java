package com.jucao.cleanarch.core.gateway;

import com.jucao.cleanarch.core.domain.Customer;
import java.util.Optional;

public interface FindCustomerByIdGateway {
    Optional<Customer> findById(final String id);
}
