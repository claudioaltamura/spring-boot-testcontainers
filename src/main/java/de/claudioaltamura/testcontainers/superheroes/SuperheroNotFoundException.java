package de.claudioaltamura.testcontainers.superheroes;

public class SuperheroNotFoundException extends RuntimeException {

  public SuperheroNotFoundException(String message) {
    super(message);
  }
}
