package rune;

public class NourishingRuneAnalyzer implements RuneAnalyzer{

    @Override
    public boolean analyze(Rune rune) {
        return false;
    }

    @Override
    public TypeRune getType() {
        return TypeRune.NOURISHING_RUNE;
    }
}
