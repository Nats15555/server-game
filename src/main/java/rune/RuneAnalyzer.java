package rune;

import spell.Spell;

import java.util.ArrayList;

public interface RuneAnalyzer {

    static RuneAnalyzer createNourishingRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createShapeRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createSizeRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createConcentrationRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createEnergyTypeRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createCycleRuneAnalyzer() { return null; }

    static RuneAnalyzer createDirectionRuneAnalyzer(){
        return null;
    }

    Spell analyze(Rune rune, Spell spellInstance);

    TypeRune getType();

}
