package com.jucao.cleanarch.entrypoint.consumer;

import com.jucao.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.jucao.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.jucao.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper mapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "jucao")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerUseCase.update(mapper.toCustomerMessage(customerMessage), customerMessage.getZipCode());

    }
}
