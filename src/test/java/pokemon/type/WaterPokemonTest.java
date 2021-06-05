package pokemon.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterPokemonTest {
    FirePokemon firePokemon;
    WaterPokemon waterPokemon;
    PlantPokemon plantPokemon;
    @BeforeEach
    void setUp(){
        firePokemon = new FirePokemon("Mike", "Charmander", 50);
        plantPokemon = new PlantPokemon("Benito", "Bulbasaur", 15);
        waterPokemon = new WaterPokemon("Milo", "Blastoise", 60);
    }

    @Test
    void getHP() {
        assert(waterPokemon.getHP() == 60);
    }

    @Test
    void setHP() {
        waterPokemon.setHP(80);
        assert(waterPokemon.getHP() == waterPokemon.getMaxHP());
        waterPokemon.setHP(33);
        assert(waterPokemon.getHP() == 33);
    }

    //
    @Test
    void getPP(){
        assert(waterPokemon.getPP() == 20);
    }

    @Test
    void setPP(){
        waterPokemon.setPP(30);
        assert(waterPokemon.getPP() == waterPokemon.getMaxPP());
        waterPokemon.setPP(10);
        assert(waterPokemon.getPP() == 10);
    }

    @Test
    void getMaxHP(){
        assert(waterPokemon.getMaxHP() == 60);
    }

    @Test
    void setMaxHP(){
        waterPokemon.setMaxHP(25);
        assert(waterPokemon.getMaxHP() == 25);
        assert(waterPokemon.getHP() == 25);
    }

    @Test
    void getMaxPP(){
        assert(waterPokemon.getMaxPP() == 20); // Default value
    }

    @Test
    void setMaxPP(){
        waterPokemon.setMaxPP(25); // New value
        assert(waterPokemon.getMaxPP() == 25);
        assert(waterPokemon.getPP() == 20);
    }
    //
    @Test
    void attack() {
        int old_HP = firePokemon.getHP();
        waterPokemon.attack(firePokemon);
        assert(firePokemon.getHP() == old_HP-2*waterPokemon.getAttack());
        old_HP = plantPokemon.getHP();
        waterPokemon.attack(plantPokemon);
        assert(plantPokemon.getHP() == old_HP-waterPokemon.getAttack());
    }

    @Test
    void attacked_by_Water() {
        int old_HP = waterPokemon.getHP();
        waterPokemon.attacked_by_Water(waterPokemon);
        assert(waterPokemon.getHP() == old_HP-waterPokemon.getAttack());
    }

    @Test
    void attacked_by_Fire() {
        int old_HP = waterPokemon.getHP();
        waterPokemon.attacked_by_Fire(firePokemon);
        assert(waterPokemon.getHP() == old_HP-firePokemon.getAttack());
    }

    @Test
    void attacked_by_Plant() {
        int old_HP = waterPokemon.getHP();
        waterPokemon.attacked_by_Plant(plantPokemon);
        assert(waterPokemon.getHP() == old_HP-2*plantPokemon.getAttack());
    }
}