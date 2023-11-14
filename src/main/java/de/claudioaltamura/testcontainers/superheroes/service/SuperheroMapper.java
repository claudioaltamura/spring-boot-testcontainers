package de.claudioaltamura.testcontainers.superheroes.service;

import de.claudioaltamura.testcontainers.superheroes.Superhero;
import de.claudioaltamura.testcontainers.superheroes.entity.SuperheroEntity;
import org.springframework.stereotype.Component;

@Component
public class SuperheroMapper {

  public Superhero toDto(SuperheroEntity superheroEntity) {
    Superhero superhero = new Superhero();
    superhero.setId(superheroEntity.getId());
    superhero.setName(superheroEntity.getName());
    superhero.setPower(superheroEntity.getPower());
    superhero.setRealName(superheroEntity.getRealName());
    return superhero;
  }
}
