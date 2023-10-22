package gameLogic.spellDescription.runeDescription;

import gameLogic.spellDescription.runeDescription.enams.TypeRune;
import gameLogic.spellDescription.runeDescription.enams.TypeSymbol;

public class Rune {
    private TypeRune typeRune;
    private TypeSymbol typeSymbol;

    public Rune(TypeRune typeRune, TypeSymbol typeSymbol) {
        this.typeRune = typeRune;
        this.typeSymbol = typeSymbol;
    }

    public TypeRune getTypeRune() {
        return typeRune;
    }

    public void setTypeRune(TypeRune typeRune) {
        this.typeRune = typeRune;
    }

    public TypeSymbol getTypeSymbol() {
        return typeSymbol;
    }

    public void setTypeSymbol(TypeSymbol typeSymbol) {
        this.typeSymbol = typeSymbol;
    }
}
