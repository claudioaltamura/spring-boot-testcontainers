package de.claudioaltamura.testcontainers.superheroes.repository;

import de.claudioaltamura.testcontainers.superheroes.entity.SuperheroEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long> {
  List<SuperheroEntity> findByName(String name);
}
