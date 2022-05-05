package rune;

import spell.Spell;

import java.util.ArrayList;

public class EnergyTypeRuneAnalyzer implements RuneAnalyzer{
    @Override
    public Spell analyze(Rune rune, Spell spellInstance) {
        Spell returnSpellInstance = spellInstance;
        TypeSymbol typeSymbol = rune.getTypeSymbolRune();
        returnSpellInstance.setSpellEnergyType(typeSymbol.symbolId);
        return returnSpellInstance;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.ENERGY_TYPE_RUNE;
    }
}
