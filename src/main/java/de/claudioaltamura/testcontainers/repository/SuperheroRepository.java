package de.claudioaltamura.testcontainers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.claudioaltamura.testcontainers.model.Superhero;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}