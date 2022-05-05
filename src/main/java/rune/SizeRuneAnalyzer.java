package rune;

import spell.Spell;

import java.util.ArrayList;

public class SizeRuneAnalyzer implements RuneAnalyzer{
    @Override
    public Spell analyze(Rune rune, Spell spellInstance) {
        Spell returnSpellInstance = spellInstance;
        TypeSymbol typeSymbol = rune.getTypeSymbolRune();
        returnSpellInstance.setSpellSize(typeSymbol.symbolId);
        return returnSpellInstance;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.SIZE_RUNE;
    }
}
