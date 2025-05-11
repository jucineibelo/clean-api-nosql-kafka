package com.jucao.cleanarch.dataprovider;

import com.jucao.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerImpl implements com.jucao.cleanarch.core.gateway.DeleteCustomerGateway {

    @Autowired
    CustomerRepository repository;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
