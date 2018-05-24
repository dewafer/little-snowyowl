package com.newnil.snowyowl.littlesnowyowl.controller;

import static com.newnil.snowyowl.littlesnowyowl.support.transform.HeroModelEntityConvertor.HERO_ENTITY_TO_MODEL_CONVERTOR;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.newnil.snowyowl.littlesnowyowl.dao.entity.HeroEntity;
import com.newnil.snowyowl.littlesnowyowl.dao.repository.HeroRepository;
import com.newnil.snowyowl.littlesnowyowl.exception.HeroNotFoundException;
import com.newnil.snowyowl.littlesnowyowl.model.Hero;

@RestController
@RequestMapping("api/heroes")
public class HeroesController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public List<Hero> getHeroes() {
        return this.heroRepository.findAll().stream().map(HERO_ENTITY_TO_MODEL_CONVERTOR).collect(Collectors.toList());
    }

    @GetMapping("/")
    public List<Hero> searchHero(@RequestParam("name") String name) {
        return this.heroRepository.findByNameLike("%" + name + "%").stream().map(HERO_ENTITY_TO_MODEL_CONVERTOR)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable int id) throws HeroNotFoundException {
        return this.heroRepository.findById(id).map(HERO_ENTITY_TO_MODEL_CONVERTOR)
                .orElseThrow(HeroNotFoundException::new);
    }

    @PutMapping()
    public ResponseEntity<Void> updateHero(@RequestBody Hero postedHero)
            throws HeroNotFoundException {
        HeroEntity heroEntity = this.heroRepository.findById(postedHero.getId())
                .orElseThrow(HeroNotFoundException::new);
        heroEntity.setName(postedHero.getName());
        this.heroRepository.save(heroEntity);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Hero> addHero(@RequestBody Hero postedHero) throws HeroNotFoundException {
        HeroEntity newHeroEntity = HeroEntity.builder().name(postedHero.getName()).build();
        HeroEntity savedEntity = this.heroRepository.save(newHeroEntity);
        URI location = MvcUriComponentsBuilder.fromMethodCall(on(HeroesController.class).getHero(0))
                .buildAndExpand(savedEntity.getId()).toUri();
        return ResponseEntity.created(location).body(HERO_ENTITY_TO_MODEL_CONVERTOR.apply(savedEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHero(@PathVariable int id) {
        this.heroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
