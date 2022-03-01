package de.claudioaltamura.testcontainers.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.claudioaltamura.testcontainers.superheroes.entity.SuperheroEntity;

public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long> {
	List<SuperheroEntity> findByName(String name);
}
