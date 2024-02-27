package br.com.spring.planets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.planets.domain.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
	Optional<Planet> findByName(String name);
}
