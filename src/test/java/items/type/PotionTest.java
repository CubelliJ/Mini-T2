package items.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemon.type.*;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    FirePokemon firePokemon;
    PlantPokemon plantPokemon;
    Potion potion;

    @BeforeEach
    void setUp() {
        potion = new Potion(20);
        firePokemon = new FirePokemon("Charizard", "Charizard", 30);
        plantPokemon = new PlantPokemon("Ivysaur", "Ivysaur", 35);
        firePokemon.attack(plantPokemon);
    }

    @Test
    void apply() {
        assert(plantPokemon.getHP() == plantPokemon.getMaxHP()-2*firePokemon.getAttack());
        potion.apply(plantPokemon);
        assert(plantPokemon.getHP() == plantPokemon.getMaxHP());
    }
}