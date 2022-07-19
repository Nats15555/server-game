package rune;

import spell.SpellObject;

import static rune.TypeRune.SIZE_RUNE;
import static rune.TypeSymbol.SMALL_SIZE_RUNE;
import static rune.TypeSymbol.MEDIUM_SIZE_RUNE;
import static rune.TypeSymbol.LARGE_SIZE_RUNE;

public class SizeRune extends RuneTemplate{

    public SizeRune(Object costInEnergy, Object timeCast, Object typeSymbolRune) {
        super(costInEnergy, timeCast, typeSymbolRune, SIZE_RUNE);
    }


    public boolean doRune(SpellObject spellObject){

        if (SMALL_SIZE_RUNE.equals(this.getTypeSymbolRune())) {
            spellObject.setSize(1, 1, 1);
        } else if (MEDIUM_SIZE_RUNE.equals(this.getTypeSymbolRune())) {
            spellObject.setSize(2, 2, 2);
        } else if (LARGE_SIZE_RUNE.equals(this.getTypeSymbolRune())) {
            spellObject.setSize(3, 3, 3);
        } else {
            return false;
        }

        return true;
    }
}
