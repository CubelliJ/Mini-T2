package pokemon.factory;

import org.junit.jupiter.api.Test;
import pokemon.type.*;

import static org.junit.jupiter.api.Assertions.*;

class FirePokemonFactoryTest {
    private FirePokemonFactory firePokemonFactory;

    @Test
    void create() {
        firePokemonFactory = new FirePokemonFactory();
        assertEquals(firePokemonFactory.create("Dela").getClass(), FirePokemon.class);
    }
}