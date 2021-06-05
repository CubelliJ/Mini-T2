package pokemon.factory;

import org.junit.jupiter.api.Test;
import pokemon.type.WaterPokemon;

import static org.junit.jupiter.api.Assertions.*;

class WaterPokemonFactoryTest {
    private WaterPokemonFactory waterPokemonFactory;

    @Test
    void create() {
        waterPokemonFactory = new WaterPokemonFactory();
        assertEquals(waterPokemonFactory.create("Dela").getClass(), WaterPokemon.class);
    }
}