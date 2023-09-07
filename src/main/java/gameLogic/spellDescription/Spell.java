package gameLogic.spellDescription;

import gameLogic.spellDescription.runeDescription.Rune;

import java.util.ArrayList;

public class Spell {

    private Rune nourishingRune;
    private Rune shapeRune;
    private Rune sizeRune;
    private Rune energyConcentrationRune;
    private Rune energyTypeRune;
    private ArrayList<Rune> controlRunes = new ArrayList<>();

    public ArrayList<Rune> getControlRunes() {
        return controlRunes;
    }

    public void setControlRunes(ArrayList<Rune> controlRunes) {
        if (controlRunes.size() < 11){
            this.controlRunes = controlRunes;
        }
    }

    public void addControlRune(Rune rune){
        if (controlRunes.size() < 11){
            controlRunes.add(rune);
        }
    }

    public Rune getNourishingRune() {
        return nourishingRune;
    }

    public void setNourishingRune(Rune nourishingRune) {
        this.nourishingRune = nourishingRune;
    }

    public Rune getShapeRune() {
        return shapeRune;
    }

    public void setShapeRune(Rune shapeRune) {
        this.shapeRune = shapeRune;
    }

    public Rune getSizeRune() {
        return sizeRune;
    }

    public void setSizeRune(Rune sizeRune) {
        this.sizeRune = sizeRune;
    }

    public Rune getEnergyConcentrationRune() {
        return energyConcentrationRune;
    }

    public void setEnergyConcentrationRune(Rune energyConcentrationRune) {
        this.energyConcentrationRune = energyConcentrationRune;
    }

    public Rune getEnergyTypeRune() {
        return energyTypeRune;
    }

    public void setEnergyTypeRune(Rune energyTypeRune) {
        this.energyTypeRune = energyTypeRune;
    }
}
