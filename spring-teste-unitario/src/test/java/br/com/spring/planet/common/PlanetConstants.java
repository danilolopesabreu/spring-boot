package br.com.spring.planet.common;

import java.util.Optional;

import br.com.spring.planets.domain.Planet;

public class PlanetConstants {
	public static final Planet PLANET = new Planet("name","climate","terrain");
	public static final Planet INVALID_PLANET = new Planet("","","");
	public static final Optional<Planet> OPTIONAL_PLANET = Optional.of(new Planet("name","climate","terrain"));
}
