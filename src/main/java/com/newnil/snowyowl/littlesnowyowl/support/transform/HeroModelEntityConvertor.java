package com.newnil.snowyowl.littlesnowyowl.support.transform;

import java.util.function.Function;

import com.newnil.snowyowl.littlesnowyowl.dao.entity.HeroEntity;
import com.newnil.snowyowl.littlesnowyowl.model.Hero;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HeroModelEntityConvertor {

    public static final Function<HeroEntity, Hero> HERO_ENTITY_TO_MODEL_CONVERTOR = heroEntity -> Hero.builder()
            .id(heroEntity.getId()).name(heroEntity.getName()).build();

}
