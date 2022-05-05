package rune;

import spell.Spell;

import java.util.ArrayList;

public class ConcentrationRuneAnalyzer implements RuneAnalyzer{
    @Override
    public Spell analyze(Rune rune, Spell spellInstance) {
        Spell returnSpellInstance = spellInstance;
        TypeSymbol typeSymbol = rune.getTypeSymbolRune();
        returnSpellInstance.setSpellConcentration(typeSymbol.symbolId);
        return returnSpellInstance;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.CONCENTRATION_ENERGY_RUNE;
    }
}
