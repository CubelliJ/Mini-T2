package pokemon;

import pokemon.type.FirePokemon;
import pokemon.type.PlantPokemon;
import pokemon.type.WaterPokemon;


/**
 * AbstractPokemon: Implements iPokemon and provides the baseline constructor for the different pokemon types.
 * In here, most of the methods, such as the getters and setters, are defined properly.
 * In special cases the methods may be further overwritten in the classes that extend AbstractPokemon.
 */
public abstract class AbstractPokemon implements iPokemon {

    private final String name; // Valor final al ser inicializado.
    private String species;
    private int hp;
    private int max_hp;
    private int pp = 20;
    private int max_pp = 20;
    private int attack = 5;


    /**
     * Abstract Constructor: Sets the basic guidelines for constructing a pokemon object.
     * @param name: Pokemon name, String which cannot be changed as it is final.
     * @param species: Pokemon species, String
     * @param hp: Pokemon hit points, int
     */
    //
    public AbstractPokemon(final String name, String species, int hp) { //
        // The constructor parameters are the same as before. In this case, max_hp will be equal as the initial hp.
        // Nevertheless it can be changed using setMaxHP(int new_maxHP).
        this.name = name;
        this.species = species;
        this.max_hp = hp;
        this.hp = hp;
    }

    // Get attack -> returns amount of attack a pokemon can inflict.
    @Override
    public int getAttack() {
        return this.attack;
    }

    // HP getters and setters
    @Override
    public void setHP(int new_HP){
        this.hp = new_HP;
    }

    @Override
    public int getHP() {
        int hp_returned = this.hp;
        // If HP saved is bigger than maxHP, it will correct itself and change it to the max.
        if (hp_returned > this.max_hp){
            setHP(this.max_hp);
            return this.max_hp;
        }
        return hp_returned;
    }

    // MaxHP getters and setters.
    @Override
    public void setMaxHP(int new_MaxHP){
        this.max_hp = new_MaxHP;
    }

    @Override
    public int getMaxHP() {
        return this.max_hp;
    }
    //

    // PP getters and setters.
    @Override
    public void setPP(int new_PP){
        this.pp = new_PP;
    }

    @Override
    public int getPP() {
        int pp_returned = this.pp;
        // Limited by max_pp.
        if (pp_returned > this.max_pp){
            setHP(this.max_pp);
            return this.max_pp;
        }
        return pp_returned;
    }
    //

    // MaxPP getters and setters.
    @Override
    public void setMaxPP(int new_MaxPP){
        this.max_pp = new_MaxPP;
    }

    @Override
    public int getMaxPP() {
        return this.max_pp;
    }
    //

    //// Attacks, double dispatch.

    // Pokemon attacks another, this method gets overwritten in every type of pokemon.
    @Override
    public void attack(iPokemon opponent) {

    }

    // Pokemon is attacked by a plant type pokemon.
    @Override
    public void attacked_by_Plant(PlantPokemon attacker) {
        this.setHP(this.getHP() - attacker.getAttack());
    }

    // Pokemon is attacked by a fire type pokemon.
    @Override
    public void attacked_by_Fire(FirePokemon attacker) {
        this.setHP(this.getHP()-attacker.getAttack());
    }


    // Pokemon is attacked by a water type pokemon.
    @Override
    public void attacked_by_Water(WaterPokemon attacker) {
        this.setHP(this.getHP()-attacker.getAttack());
    }
    ////
}
