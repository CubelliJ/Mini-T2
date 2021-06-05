package pokemon.type;

import pokemon.AbstractPokemon;
import pokemon.iPokemon;

/**
 * Water pokemon, strong against Fire pokemon and Weak against Plant pokemon.
 * Inherits all the methods of AbstractPokemon.
 */
public class WaterPokemon extends AbstractPokemon {

    public WaterPokemon(String name, String species, int hp) {
        super(name, species, hp);
    }

    // When this kind of pokemon attacks, the other pokemon is getting attacked by a water pokemon.
    @Override
    public void attack(iPokemon opponent){
        opponent.attacked_by_Water(this);
        this.setPP(this.getPP()-1);
    }

    // When attacked by a plant pokemon, it receives double the damage.
    @Override
    public void attacked_by_Plant(PlantPokemon attacker) {
        this.setHP(this.getHP()-2*attacker.getAttack());
    }
}
