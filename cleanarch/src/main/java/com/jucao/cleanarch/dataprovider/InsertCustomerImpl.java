package com.jucao.cleanarch.dataprovider;

import com.jucao.cleanarch.core.gateway.InsertCustomerGateway;
import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.dataprovider.repository.CustomerRepository;
import com.jucao.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomerGateway {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerEntityMapper mapper;

    @Override
    public void insert(Customer customer) {
        repository.save(mapper.customerEntity(customer));
    }
}
