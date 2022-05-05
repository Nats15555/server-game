package rune;

import java.util.Objects;

public class Rune {
    private final int costInEnergy;
    private final long timeCast;
    private final TypeSymbol typeSymbolRune;
    private final TypeRune typeRune;

    public Rune(int costInEnergy, long timeCast, TypeSymbol typeSymbolRune, TypeRune typeRune) {
        this.costInEnergy = costInEnergy;
        this.timeCast = timeCast;
        this.typeSymbolRune = typeSymbolRune;
        this.typeRune = typeRune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rune rune = (Rune) o;
        return costInEnergy == rune.costInEnergy && timeCast == rune.timeCast &&
                typeSymbolRune == rune.typeSymbolRune && typeRune == rune.typeRune;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costInEnergy, timeCast, typeSymbolRune, typeRune);
    }

    public int getCostInEnergy() {
        return costInEnergy;
    }

    public long getTimeCast() {
        return timeCast;
    }

    public TypeSymbol getTypeSymbolRune() {
        return typeSymbolRune;
    }

    public TypeRune getTypeRune() {
        return typeRune;
    }
}
