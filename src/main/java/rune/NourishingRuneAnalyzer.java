package rune;

import spell.Spell;

import java.util.ArrayList;

public class NourishingRuneAnalyzer implements RuneAnalyzer{

    @Override
    public Spell analyze(Rune rune, Spell spellInstance) {
        Spell returnSpellInstance = spellInstance;
        return returnSpellInstance;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.NOURISHING_RUNE;
    }
}
