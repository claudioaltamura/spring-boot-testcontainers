package de.claudioaltamura.testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.claudioaltamura.testcontainers.superheroes.entity.SuperheroEntity;
import de.claudioaltamura.testcontainers.superheroes.repository.SuperheroRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SuperheroEntityJpaTest extends AbstractPostgreSQLTest {

	@Autowired
	private SuperheroRepository superheroRepository;

	@Test
	void shouldCreateSuperhero() {
		final SuperheroEntity superhero = new SuperheroEntity();
		superhero.setName("Thor");
		superhero.setPower(98.0d);
		superheroRepository.save(superhero);

		assertThat(superheroRepository.findByName("Thor")).isNotNull();
	}
}