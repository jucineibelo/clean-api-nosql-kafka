package com.jucao.cleanarch.dataprovider;

import com.jucao.cleanarch.core.gateway.FindAddressByZipCodeGateway;
import com.jucao.cleanarch.core.domain.Address;
import com.jucao.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.jucao.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressZipCodeImpl implements FindAddressByZipCodeGateway {

    @Autowired
    FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var responseMapper = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(responseMapper);
    }
}
