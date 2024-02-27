package br.com.spring.planets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.planets.domain.Planet;
import br.com.spring.planets.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@PostMapping
	public Planet create(@RequestBody Planet planet) {
		return this.planetService.create(planet);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Planet> get(@PathVariable("id") Long id) {
		return planetService.get(id).map(planet -> ResponseEntity.ok(planet))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Planet> getByName(@PathVariable("name") String name) {
		return planetService.getByName(name).map(planet -> ResponseEntity.ok(planet))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
