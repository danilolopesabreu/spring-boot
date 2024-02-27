package br.com.spring.planet;

import static br.com.spring.planet.common.PlanetConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.spring.planets.domain.Planet;
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
		//Arrange
		when(this.planetRepository.findByName(PLANET.getName())).thenReturn(OPTIONAL_PLANET);
		
		//Act
		var planetByName = this.planetService.getByName(PLANET.getName());
		
		//Assert
		assertThat(planetByName).isNotNull();
		assertThat(planetByName).isEqualTo(OPTIONAL_PLANET);
	}

	@Test
	public void getPlanet_ByUnexistingName_ReturnsEmpty() {
		//Arrange
		when(this.planetRepository.findByName("qwerty")).thenReturn(Optional.empty());
		
		//Act
		var planetByName = this.planetService.getByName("qwerty");
		
		//Assert
		assertThat(planetByName).isEmpty();
	}
}
