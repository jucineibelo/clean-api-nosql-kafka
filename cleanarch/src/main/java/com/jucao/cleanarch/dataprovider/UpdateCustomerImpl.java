package com.jucao.cleanarch.dataprovider;

import com.jucao.cleanarch.core.gateway.UpdateCostumerGateway;
import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.dataprovider.repository.CustomerRepository;
import com.jucao.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCostumerGateway {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper mapper;

    @Override
    public void update(Customer customer) {
        customerRepository.save(mapper.customerEntity(customer));
    }
}
