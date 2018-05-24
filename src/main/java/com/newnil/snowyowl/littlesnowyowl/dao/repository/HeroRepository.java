package com.newnil.snowyowl.littlesnowyowl.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newnil.snowyowl.littlesnowyowl.dao.entity.HeroEntity;

public interface HeroRepository extends JpaRepository<HeroEntity, Integer> {

    List<HeroEntity> findByNameLike(String name);
}
