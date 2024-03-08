package br.com.spring.planet;

import static br.com.spring.planet.common.PlanetConstants.INVALID_PLANET;
import static br.com.spring.planet.common.PlanetConstants.OPTIONAL_PLANET;
import static br.com.spring.planet.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import br.com.spring.planets.domain.Planet;
import br.com.spring.planets.domain.QueryBuilder;
import br.com.spring.planets.repository.PlanetRepository;
import br.com.spring.planets.service.PlanetService;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class) //desabilitar springBoot pra testa por conta da carga, usar somente mockito
class PlanetServiceTest {

//	@Autowired
	@InjectMocks //
	private PlanetService planetService;

	@Mock
	private PlanetRepository planetRepository;

	@Test
	void test() {
		// Estrutura AAA - Arrange, Act, Assert

		// Arrange
		when(this.planetRepository.save(PLANET)).thenReturn(PLANET);

		// Act
		Planet sut = this.planetService.create(PLANET);

		// Assert
		assertThat(sut).isEqualTo(PLANET);
	}

	@Test
	void createPlanet_withInvalidData_throwsException() {
		when(this.planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

		assertThatThrownBy(() -> this.planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
	}

	@Test
	public void getPlanet_ByExistingId_ReturnsPlanet() {

		when(this.planetRepository.findById(10L)).thenReturn(OPTIONAL_PLANET);

		var systemUnderTest = this.planetService.get(10L);

		assertThat(systemUnderTest).isNotEmpty();
		assertThat(systemUnderTest).isEqualTo(OPTIONAL_PLANET);
	}

	@Test
	public void getPlanet_ByUnexistingId_ReturnsEmpty() {
		when(this.planetRepository.findById(anyLong())).thenReturn(Optional.empty());

		// sut
		var systemUnderTest = this.planetService.get(15L);

		assertThat(systemUnderTest).isEmpty();
	}

	@Test
	public void getPlanet_ByExistingName_ReturnsPlanet() {
		// Arrange
		when(this.planetRepository.findByName(PLANET.getName())).thenReturn(OPTIONAL_PLANET);

		// Act
		var planetByName = this.planetService.getByName(PLANET.getName());

		// Assert
		assertThat(planetByName).isNotNull();
		assertThat(planetByName).isEqualTo(OPTIONAL_PLANET);
	}

	@Test
	public void getPlanet_ByUnexistingName_ReturnsEmpty() {
		// Arrange
		when(this.planetRepository.findByName("qwerty")).thenReturn(Optional.empty());

		// Act
		var planetByName = this.planetService.getByName("qwerty");

		// Assert
		assertThat(planetByName).isEmpty();
	}

	@Test
	public void listPlanets_ReturnsAllPlanets() {
		// Arrange
		List<Planet> planets = new ArrayList<Planet>() {
			{
				add(PLANET);
			}
		};

		Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getClimate(), PLANET.getTerrain()));

		when(this.planetRepository.findAll(query)).thenReturn(planets);

		// Act
		List<Planet> sut = this.planetService.list(PLANET.getTerrain(), PLANET.getClimate());

		// Assertion
		assertThat(sut).isNotEmpty();
		assertThat(sut).hasSize(1);
		assertThat(sut.get(0)).isEqualTo(PLANET);

	}

	@Test
	public void listPlanets_ReturnsNoPlanets() {

		// Arrange
		Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getClimate(), PLANET.getTerrain()));

		when(planetRepository.findAll(query)).thenReturn(Collections.emptyList());

		// Act
		List<Planet> sut = this.planetService.list(PLANET.getTerrain(), PLANET.getClimate());

		// assert
		assertThat(sut).isEmpty();
		assertThat(sut).hasSize(0);
	}

	@Test
	public void removePlanet_WithExistingId_doesNotThrowAnyException() {

//		assertThatCode(() -> planetService.remove(1L)).doesNotThrowAnyException();
		
		doNothing().when(planetRepository).deleteById(1L);
		planetService.remove(1L);
		 
		verify(planetRepository, times(1)).deleteById(1L);

	}

	@Test
	public void removePlanet_WithUnexistingId_ThrowsException() {
		doThrow(new RuntimeException()).when(planetRepository).deleteById(99L);
		
		assertThatThrownBy(() -> planetService.remove(99L)).isInstanceOf(RuntimeException.class);
	}
}
