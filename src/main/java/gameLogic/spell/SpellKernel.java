package gameLogic.spell;

import java.util.ArrayList;

public class SpellKernel {
    private int spellId;

    private int spellHp;
    private int spellPower;
    private int spellSpeed;

    private ArrayList<SpellObject> spellObjects = new ArrayList<>();

    public void addObserver (SpellObject spellObject){
        this.spellObjects.add(spellObject);
    }

    public void removeObserver (SpellObject spellObject){
        this.spellObjects.remove(spellObject);
    }

    public void decrementHp (int damage){
        if (damage >= spellHp){
            spellHp = 0;
            spellDeath();
            return;
        }

        spellHp -= damage;
    }

    public void spellDeath(){
        for (SpellObject spellObject : spellObjects){
            //добавить вызов функции по зачистке карты.
            spellObject.death();
        }
    }
}
