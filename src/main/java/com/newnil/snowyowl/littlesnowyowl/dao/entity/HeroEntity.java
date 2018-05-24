package com.newnil.snowyowl.littlesnowyowl.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    @Column
    private String name;

}
