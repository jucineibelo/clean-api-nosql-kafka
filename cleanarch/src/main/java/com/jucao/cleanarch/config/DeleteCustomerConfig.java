package com.jucao.cleanarch.config;

import com.jucao.cleanarch.core.usecase.impl.DeleteCustomerUseCaseImpl;
import com.jucao.cleanarch.core.usecase.impl.FindCustomerUseCaseImpl;
import com.jucao.cleanarch.dataprovider.DeleteCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerUseCaseImpl deleteCustomerUseCase(FindCustomerUseCaseImpl findCustomerById,
                                                           DeleteCustomerImpl deleteCustomer) {
        return new DeleteCustomerUseCaseImpl(findCustomerById, deleteCustomer);
    }

    //o spring ira gerenciar as chamada dos objetos nessa classe de config ele não vai chamar gateway
    //não vai chamar interface, porém chamará a classes usecase (domain/core)
    // na principal vai instnciar a camada de dataprovider (crud)
}
