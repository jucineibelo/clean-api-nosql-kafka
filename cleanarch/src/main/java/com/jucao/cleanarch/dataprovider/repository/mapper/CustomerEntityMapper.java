package com.jucao.cleanarch.dataprovider.repository.mapper;

import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity customerEntity(Customer customer);

    Customer toCustumer(CustomerEntity customerEntity);

}
