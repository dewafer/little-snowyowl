package com.newnil.snowyowl.littlesnowyowl.config;

import java.util.Arrays;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.newnil.snowyowl.littlesnowyowl.dao.entity.HeroEntity;
import com.newnil.snowyowl.littlesnowyowl.dao.repository.HeroRepository;

@Configuration
@Profile("dev")
public class InitHeroesConfig implements InitializingBean {

    private static final String[] INIT_HEROES = {
            "Mr. Nice",
            "Narco",
            "Bombasto",
            "Celeritas",
            "Magneta",
            "RubberMan",
            "Dynama",
            "Dr IQ",
            "Magma",
            "Tornado"
    };

    @Autowired HeroRepository repository;

    @Override public void afterPropertiesSet() throws Exception {
        Arrays.stream(INIT_HEROES)
                .forEach(hero -> this.repository.saveAndFlush(HeroEntity.builder().name(hero).build()));
    }
}
