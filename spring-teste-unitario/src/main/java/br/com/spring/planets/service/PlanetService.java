package br.com.spring.planets.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.planets.domain.Planet;
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

}
