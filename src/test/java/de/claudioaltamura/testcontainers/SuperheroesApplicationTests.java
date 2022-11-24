package de.claudioaltamura.testcontainers;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.*;

import de.claudioaltamura.testcontainers.superheroes.controller.SuperheroController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SuperheroesApplicationTests extends AbstractPostgreSQLTest {

    private WebTestClient webTestClient;

    @Autowired private SuperheroController superheroesController;

    @BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToController(superheroesController).build();
    }

    @Test
    void getSuperhero() {
        this.webTestClient
                .get()
                .uri("/api/v1/superheroes")
                .header(ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectHeader()
                .contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.length()")
                .isEqualTo(2);
    }

}