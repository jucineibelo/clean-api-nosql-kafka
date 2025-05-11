package com.jucao.cleanarch.config;

import com.jucao.cleanarch.core.usecase.impl.FindCustomerUseCaseImpl;
import com.jucao.cleanarch.core.usecase.impl.UpdateCostumerUseCaseImpl;
import com.jucao.cleanarch.dataprovider.FindAddressZipCodeImpl;
import com.jucao.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCostumerConfig {

    @Bean
    public UpdateCostumerUseCaseImpl updateCostumerUseCase(FindCustomerUseCaseImpl findCustomerUseCase,
                                                           FindAddressZipCodeImpl findAddressZipCode,
                                                           UpdateCustomerImpl updateCustomer) {
        return new UpdateCostumerUseCaseImpl(findCustomerUseCase, findAddressZipCode, updateCustomer);
    }

    //basicamente o spring primeiramente vai chamar a  camada de domain e no objeto principal(metodo em si) vai instanciar a camada de dataprovider (crud)
    //não vai instanciar gateway ou interfaces (pois não tem ação em interfaces)
}
