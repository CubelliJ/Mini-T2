package pokemon.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirePokemonTest {
    FirePokemon firePokemon;
    WaterPokemon waterPokemon;
    PlantPokemon plantPokemon;
    @BeforeEach
    void setUp(){
        firePokemon = new FirePokemon("Oliver", "Charmander", 120);
        plantPokemon = new PlantPokemon("Charlie", "Bulbasaur", 15);
        waterPokemon = new WaterPokemon("Lola", "Blastoise", 60);
    }

    @Test
    void getHP() {
        assert(firePokemon.getHP() == 120);
    }

    @Test
    void setHP() {
        // Case with new HP higher than the maximum permitted.
        firePokemon.setHP(666);
        assert(firePokemon.getHP() == firePokemon.getMaxHP());
        firePokemon.setHP(45);
        assert(firePokemon.getHP() == 45);
    }

    @Test
    void getPP(){
        assert(firePokemon.getPP() == 20);
    }

    @Test
    void setPP(){
        firePokemon.setPP(30);
        assert(firePokemon.getPP() == firePokemon.getMaxPP());
        firePokemon.setPP(10);
        assert(firePokemon.getPP() == 10);
    }

    @Test
    void getMaxHP(){
        assert(firePokemon.getMaxHP() == 120);
    }

    @Test
    void setMaxHP(){
        firePokemon.setMaxHP(25);
        assert(firePokemon.getMaxHP() == 25);
        assert(firePokemon.getHP() == 25);
    }

    @Test
    void getMaxPP(){
        assert(firePokemon.getMaxPP() == 20); // Default value
    }

    @Test
    void setMaxPP(){
        firePokemon.setMaxPP(25); // New value
        assert(firePokemon.getMaxPP() == 25);
        assert(firePokemon.getPP() == 20);
    }

    @Test
    void attack() {
        int old_HP = plantPokemon.getHP();
        firePokemon.attack(plantPokemon);
        assert(plantPokemon.getHP() == old_HP-2*firePokemon.getAttack());
        old_HP = waterPokemon.getHP();
        firePokemon.attack(waterPokemon);
        assert(waterPokemon.getHP() == old_HP-firePokemon.getAttack());
    }

    @Test
    void attacked_by_Water() {
        int old_HP = firePokemon.getHP();
        firePokemon.attacked_by_Water(waterPokemon);
        assert(firePokemon.getHP() == old_HP-2*waterPokemon.getAttack());
    }

    @Test
    void attacked_by_Fire() {
        int old_HP = firePokemon.getHP();
        firePokemon.attacked_by_Fire(firePokemon);
        assert(firePokemon.getHP() == old_HP-firePokemon.getAttack());
    }

    @Test
    void attacked_by_Plant() {
        int old_HP = firePokemon.getHP();
        firePokemon.attacked_by_Plant(plantPokemon);
        assert(firePokemon.getHP() == old_HP-plantPokemon.getAttack());
    }
}