package pokemon.type;

import pokemon.AbstractPokemon;
import pokemon.iPokemon;

/**
 * Plant pokemon, strong against Water pokemon and Weak against Fire pokemon.
 * Inherits all the methods of AbstractPokemon.
 */
public class PlantPokemon extends AbstractPokemon {

    public PlantPokemon(String name, String species, int hp) {
        super(name, species, hp);
    }

    // When this kind of pokemon attacks, the other pokemon is getting attacked by a plant pokemon.
    @Override
    public void attack(iPokemon opponent) {
        opponent.attacked_by_Plant(this);
        this.setPP(this.getPP()-1);
    }

    // When attacked by a fire pokemon, it receives double the damage.
    @Override
    public void attacked_by_Fire(FirePokemon attacker) {
        this.setHP(this.getHP()-2*attacker.getAttack());
    }
}
