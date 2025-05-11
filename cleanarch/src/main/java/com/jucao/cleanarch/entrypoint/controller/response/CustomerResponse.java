package com.jucao.cleanarch.entrypoint.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String id;

    private String name;

    private Boolean isValidCpf;

    private AddressResponse address;
}
