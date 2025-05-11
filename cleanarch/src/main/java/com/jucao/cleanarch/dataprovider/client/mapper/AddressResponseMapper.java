package com.jucao.cleanarch.dataprovider.client.mapper;

import com.jucao.cleanarch.core.domain.Address;
import com.jucao.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress (AddressResponse addressResponse);
}
