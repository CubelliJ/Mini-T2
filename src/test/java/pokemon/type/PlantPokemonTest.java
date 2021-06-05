package pokemon.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantPokemonTest {
    FirePokemon firePokemon;
    PlantPokemon plantPokemon;
    WaterPokemon waterPokemon;
    @BeforeEach
    void setUp(){
        firePokemon = new FirePokemon("Agatha", "Charmander", 50);
        plantPokemon = new PlantPokemon("Juanito", "Bulbasaur", 15);
        waterPokemon = new WaterPokemon("Mac", "Blastoise", 60);
    }

    @Test
    void getHP() {
        assert(plantPokemon.getHP() == 15);
    }

    @Test
    void setHP() {
        // Case with new HP higher than the maximum permitted.
        plantPokemon.setHP(666);
        assert(plantPokemon.getHP() == plantPokemon.getMaxHP());
        plantPokemon.setHP(10);
        assert(plantPokemon.getHP() == 10);
    }

    @Test
    void getPP(){
        assert(plantPokemon.getPP() == 20);
    }

    @Test
    void setPP(){
        plantPokemon.setPP(30);
        assert(plantPokemon.getPP() == plantPokemon.getMaxPP());
        plantPokemon.setPP(10);
        assert(plantPokemon.getPP() == 10);
    }

    @Test
    void getMaxHP(){
        assert(plantPokemon.getMaxHP() == 15);
    }

    @Test
    void setMaxHP(){
        plantPokemon.setMaxHP(25);
        assert(plantPokemon.getMaxHP() == 25);
        assert(plantPokemon.getHP() == 15);
    }

    @Test
    void getMaxPP(){
        assert(plantPokemon.getMaxPP() == 20); // Default value
    }

    @Test
    void setMaxPP(){
        plantPokemon.setMaxPP(25); // New value
        assert(plantPokemon.getMaxPP() == 25);
        assert(plantPokemon.getPP() == 20);
    }

    @Test
    void attacked_by_Water() {
        int saved_HP = plantPokemon.getHP();
        plantPokemon.attacked_by_Water(waterPokemon);
        assert(plantPokemon.getHP() == saved_HP-waterPokemon.getAttack());
    }

    @Test
    void attacked_by_Fire() {
        int saved_HP = plantPokemon.getHP();
        plantPokemon.attacked_by_Fire(firePokemon);
        assert(plantPokemon.getHP() == saved_HP-2*firePokemon.getAttack());
    }

    @Test
    void attacked_by_Plant() {
        int saved_HP = plantPokemon.getHP();
        plantPokemon.attacked_by_Plant(plantPokemon);
        assert(plantPokemon.getHP() == saved_HP-plantPokemon.getAttack());
    }

    @Test
    void attack() {
        // We attack a water pokemon, it should get double normal attack damage the plantPokemon inflicts.
        int saved_HP = waterPokemon.getHP();
        plantPokemon.attack(waterPokemon);
        assert(waterPokemon.getHP() == saved_HP-2*plantPokemon.getAttack());
        // We attack a fire pokemon, it should get double normal attack damage the plantPokemon inflicts.
        saved_HP = firePokemon.getHP();
        plantPokemon.attack(firePokemon);
        assert(firePokemon.getHP() == saved_HP-plantPokemon.getAttack());
    }
}