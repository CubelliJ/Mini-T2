package items.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemon.type.FirePokemon;
import pokemon.type.PlantPokemon;

import static org.junit.jupiter.api.Assertions.*;

class EtherTest {
    FirePokemon firePokemon;
    PlantPokemon plantPokemon;
    Ether ether;

    @BeforeEach
    void setUp() {
        ether = new Ether(2);
        firePokemon = new FirePokemon("Charizard", "Charizard", 30);
        plantPokemon = new PlantPokemon("Ivysaur", "Ivysaur", 35);
        firePokemon.attack(plantPokemon);
        firePokemon.attack(plantPokemon);
        firePokemon.attack(plantPokemon);
        firePokemon.attack(plantPokemon); // 4 consecutive attacks, it should have:
                                          // 20-4 = 16 pp left.
    }

    @Test
    void apply() {
        assert(firePokemon.getPP() == firePokemon.getMaxPP()-4);
        ether.apply(firePokemon); // + 2 pp.
        assert(firePokemon.getPP() == firePokemon.getMaxPP() - 4 + 2);
    }
}