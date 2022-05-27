package rune;

import java.util.List;

import static rune.TypeRune.NOURISHING_RUNE;

public class NourishingRune extends RuneTemplate {

    public NourishingRune(int costInEnergy, long timeCast, TypeSymbol typeSymbolRune) {
        super(costInEnergy, timeCast, typeSymbolRune, NOURISHING_RUNE);
    }

    public int doRune(List<RuneTemplate> runeList){
        int spellCostInEnergy = 0;

        for (RuneTemplate rune : runeList){
            spellCostInEnergy += (int) rune.getCostInEnergy();
        }

        return spellCostInEnergy;
    }


}
