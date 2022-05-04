package rune;

import java.util.Objects;

public class Rune {
    private final int costInEnergy;
    private final long timeCast;
    private final TypeSymbol symbolRune;
    private final TypeRune typeRune;

    public Rune(int costInEnergy, long timeCast, TypeSymbol symbolRune, TypeRune typeRune) {
        this.costInEnergy = costInEnergy;
        this.timeCast = timeCast;
        this.symbolRune = symbolRune;
        this.typeRune = typeRune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rune rune = (Rune) o;
        return costInEnergy == rune.costInEnergy && timeCast == rune.timeCast && Objects.equals(symbolRune, rune.symbolRune) && typeRune == rune.typeRune;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costInEnergy, timeCast, symbolRune, typeRune);
    }

    public int getCostInEnergy() {
        return costInEnergy;
    }

    public long getTimeCast() {
        return timeCast;
    }

    public TypeSymbol getSymbolRune() {
        return symbolRune;
    }

    public TypeRune getTypeRune() {
        return typeRune;
    }
}
