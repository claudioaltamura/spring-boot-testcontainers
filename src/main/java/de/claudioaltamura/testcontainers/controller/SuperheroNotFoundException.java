package de.claudioaltamura.testcontainers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SuperheroNotFoundException extends RuntimeException {

  public SuperheroNotFoundException(String message) {
    super(message);
  }
}
