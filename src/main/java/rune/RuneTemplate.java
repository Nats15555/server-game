package rune;

import jdk.nashorn.api.tree.SimpleTreeVisitorES5_1;
import spell.Spell;

import java.util.List;
import java.util.Objects;

public abstract class RuneTemplate<T1, T2, T3, T4, T5, T6> {
    private final T1 costInEnergy;
    private final T2 timeCast;
    private final T3 typeSymbolRune;
    private final T4 typeRune;

    public RuneTemplate(T1 costInEnergy, T2 timeCast, T3 typeSymbolRune, T4 typeRune) {
        this.costInEnergy = costInEnergy;
        this.timeCast = timeCast;
        this.typeSymbolRune = typeSymbolRune;
        this.typeRune = typeRune;
    }

    public T1 getCostInEnergy() {
        return costInEnergy;
    }

    public T2 getTimeCast() {
        return timeCast;
    }

    public T3 getTypeSymbolRune() {
        return typeSymbolRune;
    }

    public T4 getTypeRune() {
        return typeRune;
    }

    public T5 doRune(T6 Object){
        T5 returnValue = null;
        return returnValue;
    }
}
