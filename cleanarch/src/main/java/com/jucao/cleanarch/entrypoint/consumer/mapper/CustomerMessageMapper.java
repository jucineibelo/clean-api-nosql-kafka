package com.jucao.cleanarch.entrypoint.consumer.mapper;

import com.jucao.cleanarch.core.domain.Customer;
import com.jucao.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    //ignorando um parametro de customer (address pois em costumer message não temos esse parametro)
    @Mapping(target = "address", ignore = true)
    Customer toCustomerMessage(CustomerMessage customerMessage);
}
