package com.jucao.cleanarch.config;

import com.jucao.cleanarch.core.usecase.impl.FindCustomerUseCaseImpl;
import com.jucao.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerUseCaseImpl findCustomerUseCase(FindCustomerByIdImpl findCustomerById) {
        return new FindCustomerUseCaseImpl(findCustomerById);
    }

    //o spring ira instanciar o metodo da usecase mas chamara o parametro da classe de dataprovider
}
