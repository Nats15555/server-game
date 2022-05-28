package rune;

import spell.SpellObject;

import static rune.TypeRune.ENERGY_TYPE_RUNE;

public class EnergyTypeRune extends RuneTemplate{
    public EnergyTypeRune(Object costInEnergy, Object timeCast, Object typeSymbolRune) {
        super(costInEnergy, timeCast, typeSymbolRune, ENERGY_TYPE_RUNE);
    }

    public boolean doRune(SpellObject spellObject){
        TypeSymbol typeSymbol;
        typeSymbol = (TypeSymbol) this.getTypeSymbolRune();
        spellObject.setEnergyType(typeSymbol.symbolId);
        return true;
    }
}
