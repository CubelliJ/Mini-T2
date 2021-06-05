package pokemon.factory;

import pokemon.PokeFactory;
import pokemon.type.WaterPokemon;

/**
 * WaterPokemonFactory
 * Calling its create() method it returns a Water Pokemon, with the given name.
 */
public class WaterPokemonFactory implements PokeFactory {
    @Override
    public WaterPokemon create(String name) {
        return new WaterPokemon(name, "Egg", 20);
    }
}
