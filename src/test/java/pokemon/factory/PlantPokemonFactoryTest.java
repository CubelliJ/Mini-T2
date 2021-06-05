package pokemon.factory;

import org.junit.jupiter.api.Test;
import pokemon.type.*;

import static org.junit.jupiter.api.Assertions.*;

class PlantPokemonFactoryTest {
    private PlantPokemonFactory plantPokemonFactory;

    @Test
    void create() {
        plantPokemonFactory = new PlantPokemonFactory();
        assertEquals(plantPokemonFactory.create("Dela").getClass(), PlantPokemon.class);
    }
}