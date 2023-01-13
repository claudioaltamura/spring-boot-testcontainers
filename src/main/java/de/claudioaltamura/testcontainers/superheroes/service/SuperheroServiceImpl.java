package de.claudioaltamura.testcontainers.superheroes.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import de.claudioaltamura.testcontainers.superheroes.Superhero;
import de.claudioaltamura.testcontainers.superheroes.SuperheroNotFoundException;
import de.claudioaltamura.testcontainers.superheroes.SuperheroService;
import de.claudioaltamura.testcontainers.superheroes.entity.SuperheroEntity;
import de.claudioaltamura.testcontainers.superheroes.repository.SuperheroRepository;

@Transactional
@Service
public class SuperheroServiceImpl implements SuperheroService {

	private final SuperheroRepository superheroRepository;
	private final SuperheroMapper superheroMapper;

	public SuperheroServiceImpl(SuperheroRepository superheroRepository, SuperheroMapper superheroMapper) {
		this.superheroRepository = superheroRepository;
		this.superheroMapper = superheroMapper;
	}

	public List<Superhero> getAll() {
		return superheroRepository.findAll().stream().map(superheroMapper::toDto).collect(Collectors.toList());
	}

	public Superhero getById(@NotNull Long id) {
		return superheroRepository.findById(id).map(superheroMapper::toDto).orElseThrow(()-> new SuperheroNotFoundException(String.format("Superhero (id=%d) not found.", id)));
	}

	public boolean existsById(@NotNull Long id) {
		return superheroRepository.existsById(id);
	}

	public List<Superhero> findByName(@NotNull String name) {
		return superheroRepository.findByName(name).stream().map(superheroMapper::toDto).collect(Collectors.toList());
	}

	public Superhero save(@Valid Superhero superhero) {
		SuperheroEntity toBeCreated = new SuperheroEntity();
		toBeCreated.setName(superhero.getName());
		toBeCreated.setPower(superhero.getPower());
		toBeCreated.setRealName(superhero.getRealName());
		superheroRepository.save(toBeCreated);
		return superheroMapper.toDto(toBeCreated);
	}

	public Superhero update(@Valid Superhero superhero) {
		SuperheroEntity toBeUpdated = new SuperheroEntity();
		toBeUpdated.setName(superhero.getName());
		toBeUpdated.setPower(superhero.getPower());
		toBeUpdated.setRealName(superhero.getRealName());
		superheroRepository.save(toBeUpdated);
		return superheroMapper.toDto(toBeUpdated);
	}

	public void deleteById(@NotNull Long id) {
		if(!superheroRepository.existsById(id)) {
			throw new SuperheroNotFoundException(String.format("Superhero (id=%d) not found.", id));
		}
		superheroRepository.deleteById(id);
	}

	public void deleteAll() {
		superheroRepository.deleteAll();
	}

}
