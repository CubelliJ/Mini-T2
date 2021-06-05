package pokemon.type;

import pokemon.AbstractPokemon;
import pokemon.iPokemon;

/**
 * Fire pokemon, strong against Plant pokemon and Weak against Water pokemon.
 * Inherits all the methods of AbstractPokemon.
 */
public class FirePokemon extends AbstractPokemon {

    public FirePokemon(String name, String species, int hp) {
        super(name, species, hp);
    }

    // When this kind of pokemon attacks, the other pokemon is getting attacked by a fire pokemon.
    @Override
    public void attack(iPokemon opponent) {
        opponent.attacked_by_Fire(this);
        this.setPP(this.getPP()-1);
    }

    // When attacked by a water pokemon, it receives double the damage.
    @Override
    public void attacked_by_Water(WaterPokemon attacker) {
        this.setHP(this.getHP()-2*attacker.getAttack());
    }
}
