package items.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemon.type.*;

import static org.junit.jupiter.api.Assertions.*;

class FullRestoreTest {
    FirePokemon firePokemon;
    PlantPokemon plantPokemon;
    FullRestore restore;
    @BeforeEach
    void setUp() {
        restore = new FullRestore();
        firePokemon = new FirePokemon("Charizard", "Charizard", 30);
        firePokemon.setPP(5);
        firePokemon.setHP(8);
    }

    @Test
    void apply() {
        restore.apply(firePokemon);
        assert(firePokemon.getPP() == firePokemon.getMaxPP());
        assert(firePokemon.getHP() == firePokemon.getMaxHP());
    }
}