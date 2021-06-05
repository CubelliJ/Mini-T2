package items;

import pokemon.iPokemon;

public abstract class abstractItem implements iItems {
    private int add_hp;
    private int add_pp;

    public abstractItem(final int hp, final int pp){
        this.add_hp = hp;
        this.add_pp = pp;
    }

    @Override
    public void apply(iPokemon pokemon) {
        pokemon.setHP(pokemon.getHP()+this.add_hp);
        pokemon.setPP(pokemon.getPP()+this.add_pp);
        // Consumed.
        this.add_hp = 0;
        this.add_pp = 0;
    }
}
