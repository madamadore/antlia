package it.antlia.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.antlia.store.model.Address;
import it.antlia.store.model.TShirt;

@Configuration
public class SomeBeans {
    
    @Bean("armani")
    public TShirt getTShirtArmani() {
        return new TShirt(1, 42, "verde", "armani");   
    }

    @Bean("prada")
    public TShirt getTShirtPrada() {
        return new TShirt(2, 42, "verde", "prada");   
    }

    @Bean
    public Address getAddress() {
        return Address.builder()
                .street("via Morimondo")
                .city("Milan")
                .province("Milan")
                .state("Italy")
                .build();
    }
}
