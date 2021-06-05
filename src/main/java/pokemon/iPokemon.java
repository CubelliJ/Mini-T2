package pokemon;

import pokemon.type.*;

/**
 * iPokemon: Interface that defines the bare-bone methods implemented by the different pokemon types.
 * It's not implemented directly into a Pokemon type, but to AbstractPokemon.
 **/
public interface iPokemon {

    // Getters and setters HP:
    int getHP();
    void setHP(int new_HP);

    // Getters and setters PP:
    int getPP();
    void setPP(int new_PP);

    // Getters and setters maxHP:
    int getMaxHP();
    void setMaxHP(int new_MaxHP);

    // Getters and setters maxPP:
    int getMaxPP();
    void setMaxPP(int new_MaxPP);

    // Getter de attack:
    int getAttack();

    // Attack:
    void attack(iPokemon opponent);

    // Double dispatch:
    // Different Pokemon types damage others with different multipliers.
    // It's overridden in the pokemon type in case it gets exerted more damage.
    void attacked_by_Plant(PlantPokemon attacker);
    void attacked_by_Fire(FirePokemon attacker);
    void attacked_by_Water(WaterPokemon attacker);

}
