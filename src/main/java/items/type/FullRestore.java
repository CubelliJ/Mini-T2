package items.type;

import items.abstractItem;
import pokemon.iPokemon;

public class FullRestore extends abstractItem {

    public FullRestore() {
        super(0, 0);
    }

    @Override
    public void apply(iPokemon pokemon){
        pokemon.setHP(pokemon.getMaxHP());
        pokemon.setPP(pokemon.getMaxPP());
    }
}
