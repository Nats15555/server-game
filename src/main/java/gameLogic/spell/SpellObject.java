package gameLogic.spell;

import gameLogic.map.objects.MapObjectTemplate;

public class SpellObject extends MapObjectTemplate {
    // класс описывающий свойства заклинания
    private int spellId;      // указатель на класс где хранятся жизни спела
    private int spellHp;
    private int posX, posY, posZ;

    public SpellObject(){
        setObjectName("SpellObject");
    }

    private SpellKernel spellKernel;

    private void collisionTrigger(String action){
        if (action == ""){

        }
    }

    public void decrementHp(SpellKernel spellKernel){
        spellKernel.decrementHp(1);
    }

    public void setSpellKernel (SpellKernel spellKernel){
        this.spellKernel = spellKernel;
    }
    public void death (){
        //удалить триггер на ядро
    }

    //создать наблюдатель, который ждет ивента на изменение количества хп по указателю и когда хп равно нулю удаляет этот класс
}
