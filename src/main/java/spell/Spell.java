package spell;

import rune.NourishingRune;
import rune.RuneTemplate;

import java.util.ArrayList;
import java.util.List;

import static rune.TypeRune.NOURISHING_RUNE;
import static rune.TypeRune.SHAPE_RUNE;
import static rune.TypeRune.SIZE_RUNE;
import static rune.TypeRune.CONCENTRATION_ENERGY_RUNE;
import static rune.TypeRune.ENERGY_TYPE_RUNE;

public class Spell {

    private final List<RuneTemplate> runeList = new ArrayList<>();

    public static final int MAX_SPELL_LENGTH = 50;

    public boolean addRuneToList(RuneTemplate rune){
        if (rune == null || !isCorrectRune(rune) || runeList.size() == MAX_SPELL_LENGTH){
            return false;
        }
        runeList.add(rune);
        return true;
    }

    private boolean isCorrectRune(RuneTemplate rune){
        switch (runeList.size()){
            case 0:
                if (rune.getTypeRune() != NOURISHING_RUNE){
                    return false;
                }
                break;
            case 1:
                if (rune.getTypeRune() != SHAPE_RUNE){
                    return false;
                }
                break;
            case 2:
                if (rune.getTypeRune() != SIZE_RUNE){
                    return false;
                }
                break;
            case 3:
                if (rune.getTypeRune() != CONCENTRATION_ENERGY_RUNE){
                    return false;
                }
                break;
            case 4:
                if (rune.getTypeRune() != ENERGY_TYPE_RUNE){
                    return false;
                }
                break;
        }
        return true;
    }

    public int getSpellCostInEnergy() {
        if (runeList.size() < 4){
            return -1;
        }
        return (int) runeList.get(0).doRune(runeList);
    }

    public List<RuneTemplate> getRuneList() {
        return runeList;
    }
}
