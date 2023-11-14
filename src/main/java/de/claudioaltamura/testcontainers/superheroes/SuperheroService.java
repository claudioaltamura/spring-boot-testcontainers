package de.claudioaltamura.testcontainers.superheroes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public interface SuperheroService {

  List<Superhero> getAll();

  Superhero getById(@NotNull Long id);

  boolean existsById(@NotNull Long id);

  List<Superhero> findByName(@NotNull String name);

  Superhero save(@Valid Superhero superhero);

  Superhero update(@Valid Superhero superhero);

  void deleteById(@NotNull Long id);

  void deleteAll();
}
