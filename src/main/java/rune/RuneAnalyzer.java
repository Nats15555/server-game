package rune;

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

    static RuneAnalyzer createSourceRuneAnalyzer(){
        return null;
    }

    static RuneAnalyzer createDirectionRuneAnalyzer(){
        return null;
    }

    boolean analyze(Rune rune);

    TypeRune getType();

}
