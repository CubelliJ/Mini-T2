package pokemon.factory;

import pokemon.PokeFactory;
import pokemon.type.PlantPokemon;


/**
 * PlantPokemonFactory
 * Calling its create() method it returns a Plant Pokemon, with the given name.
 */
public class PlantPokemonFactory implements PokeFactory {
    @Override
    public PlantPokemon create(String name) {
        return new PlantPokemon(name, "Egg", 20);
    }
}
