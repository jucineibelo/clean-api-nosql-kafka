package com.jucao.cleanarch.core.gateway;

import com.jucao.cleanarch.core.domain.Address;

public interface FindAddressByZipCodeGateway {
    Address find(final String zipCode);
}
