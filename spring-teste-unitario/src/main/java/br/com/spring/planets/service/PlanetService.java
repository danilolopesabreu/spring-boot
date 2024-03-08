package br.com.spring.planets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.spring.planets.domain.Planet;
import br.com.spring.planets.domain.QueryBuilder;
import br.com.spring.planets.repository.PlanetRepository;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	public Planet create(Planet planet) {
		return this.planetRepository.save(planet);
	}

	public Optional<Planet> get(Long id) {
		return planetRepository.findById(id);
	}

	public Optional<Planet> getByName(String name) {
		return planetRepository.findByName(name);
	}

	public List<Planet> list(String terrain, String climate) {
		Example<Planet> query = QueryBuilder.makeQuery(new Planet(climate, terrain));
		return planetRepository.findAll(query);
	}

	public void remove(Long id) {
		planetRepository.deleteById(id);
	}

}
