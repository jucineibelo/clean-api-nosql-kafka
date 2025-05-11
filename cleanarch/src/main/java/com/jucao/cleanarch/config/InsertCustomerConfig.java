package com.jucao.cleanarch.config;

import com.jucao.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.jucao.cleanarch.dataprovider.FindAddressZipCodeImpl;
import com.jucao.cleanarch.dataprovider.InsertCustomerImpl;
import com.jucao.cleanarch.dataprovider.SendCpfToValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    //Para retornar uma instancia da implementação
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressZipCodeImpl findAddressZipCode,
                                                           InsertCustomerImpl insertCustomer,
                                                           SendCpfToValidation sendCpfToValidation) {
        return new InsertCustomerUseCaseImpl(findAddressZipCode, insertCustomer, sendCpfToValidation);
    }

    //basicamente o spring primeiramente vai chamar a  camada de domain e no objeto principal(metodo em si) vai instanciar a camada de dataprovider (crud)
    //não vai instanciar gateway ou interfaces (pois não tem ação em interfaces)
}
