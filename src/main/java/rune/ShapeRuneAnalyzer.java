package rune;

import spell.Spell;

import java.util.ArrayList;

public class ShapeRuneAnalyzer implements RuneAnalyzer{


    @Override
    public Spell analyze(Rune rune, Spell spellInstance) {
        Spell returnSpellInstance = spellInstance;
        TypeSymbol typeSymbol = rune.getTypeSymbolRune();
        returnSpellInstance.setSpellShape(typeSymbol.symbolId);
        return returnSpellInstance;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.SHAPE_RUNE;
    }
}
