package de.claudioaltamura.testcontainers.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.claudioaltamura.testcontainers.model.Superhero;
import de.claudioaltamura.testcontainers.repository.SuperheroRepository;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

  private final SuperheroRepository superheroRepository;

  public SuperheroController(SuperheroRepository superheroRepository) {
    this.superheroRepository = superheroRepository;
  }

  @GetMapping
  public List<Superhero> findAll() {
    return superheroRepository.findAll();
  }

  @GetMapping("/{id}")
  public Superhero findById(@PathVariable("id") Long id) {
    return superheroRepository.findById(id).orElseThrow(() -> new SuperheroNotFoundException("Superhero with id:" + id +
      " not found!"));
  }

  @PostMapping
  public Superhero create(@RequestBody Superhero superhero) {
    Superhero newSuperhero = new Superhero();
    newSuperhero.setName(superhero.getName());

    superhero = superheroRepository.save(newSuperhero);

    return superhero;
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    superheroRepository.deleteById(id);
  }    
}
