package pokemon;

/**
 * PokeFactory: Interface that defines the different kind of pokemon factories.
 * It has a method called create which gets overridden when implemented.
 **/
public interface PokeFactory {
    iPokemon create(String name);
}
