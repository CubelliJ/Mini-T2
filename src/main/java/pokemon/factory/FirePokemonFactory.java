package pokemon.factory;

import pokemon.PokeFactory;
import pokemon.type.FirePokemon;


/**
 * PlantPokemonFactory
 * Calling its create() method it returns a Fire Pokemon, with the given name.
 */
public class FirePokemonFactory implements PokeFactory {
    @Override
    public FirePokemon create(String name) {
        return new FirePokemon(name, "Egg", 20);
    }
}
