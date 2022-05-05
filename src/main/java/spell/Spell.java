package spell;

import rune.Rune;
import rune.TypeRune;
import rune.TypeSymbol;

import java.util.ArrayList;
import java.util.Objects;

public class Spell {
    private int spellSize;
    private int spellShape;
    private int spellConcentration;
    private int spellEnergyType;
    private ArrayList<Rune> spellRuneList;

    public Spell(int spellSize, int spellShape, int spellConcentration, int spellEnergyType,
                 ArrayList<Rune> spellRuneList) {
        this.spellSize = spellSize;
        this.spellShape = spellShape;
        this.spellConcentration = spellConcentration;
        this.spellEnergyType = spellEnergyType;
        this.spellRuneList = spellRuneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return spellSize == spell.spellSize && spellShape == spell.spellShape &&
                spellConcentration == spell.spellConcentration && spellEnergyType == spell.spellEnergyType &&
                Objects.equals(spellRuneList, spell.spellRuneList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spellSize, spellShape, spellConcentration, spellEnergyType, spellRuneList);
    }

    public void setSpellSize(int spellSize) {
        this.spellSize = spellSize;
    }

    public void setSpellShape(int spellShape) {
        this.spellShape = spellShape;
    }

    public void setSpellConcentration(int spellConcentration) {
        this.spellConcentration = spellConcentration;
    }

    public void setSpellEnergyType(int spellEnergyType) {
        this.spellEnergyType = spellEnergyType;
    }

    private boolean cycleRuneArrayChecker(ArrayList<Rune> spellRuneList){
        if (spellRuneList == null){ return false; }
        int notClosedCycles = 0;
        for (int i = 0; i < spellRuneList.size(); i++){
            if (notClosedCycles > 3){
                // ограничение на вложенность
                return false;
            }
            Rune rune = spellRuneList.get(i);
            if (rune.getTypeRune() == TypeRune.CYCLE_RUNE) {
                TypeSymbol typeSymbol = rune.getTypeSymbolRune();
                if (typeSymbol == TypeSymbol.END_CYCLE_RUNE && notClosedCycles > 0) {
                    notClosedCycles--;
                } else if (typeSymbol == TypeSymbol.START_CYCLE_RUNE){
                    notClosedCycles++;
                    if (i + 1 < spellRuneList.size()){
                        Rune nextRune = spellRuneList.get(i + 1);
                        if (nextRune.getTypeSymbolRune() == TypeSymbol.BIG_COUNTER_CYCLE_RUNE ||
                                nextRune.getTypeSymbolRune() == TypeSymbol.MEDIUM_COUNTER_CYCLE_RUNE ||
                                nextRune.getTypeSymbolRune() == TypeSymbol.SMALL_COUNTER_CYCLE_RUNE){
                            i++;
                        } else return false;
                    } else return false;
                } else return false;
            }
        }

        return notClosedCycles == 0;
    }
    private void cycleRuneArrayConverter(){
        // Функция убирает ровно один цикл, первый.
        // Дублирует код находящийся между start end рунами
        ArrayList<Rune> oldRunesList = this.spellRuneList;
        ArrayList<Rune> runesListToCycling = new ArrayList<Rune>();
        ArrayList<Rune> newRunesList = new ArrayList<Rune>();
        ArrayList<Rune> free = new ArrayList<Rune>();

        // начальная и конечная позиции для зацикливания
        int startPos = -1, endPos = -1;
        // количество итераций цикла
        int iterations = 0;
        int notClosedCycles = 0;

        int size = oldRunesList.size();
        int i = 0;
        while (i < size){

            // текущая руна
            Rune rune = oldRunesList.get(i);
            // работаем только с рунами типа цикла, остальные скипаем
            if (rune.getTypeRune() == TypeRune.CYCLE_RUNE){
                // если правда открывает цикл
                if (rune.getTypeSymbolRune() == TypeSymbol.START_CYCLE_RUNE){
                    // проверка на первый цикл в текущем массиве руны
                    // эквивалентно isFirst флагу
                    if (startPos == -1){
                        startPos = i + 2; // i + 1 = counter
                        switch (oldRunesList.get(i + 1).getTypeSymbolRune()){
                            case SMALL_COUNTER_CYCLE_RUNE:
                                iterations = 5;
                                break;
                            case MEDIUM_COUNTER_CYCLE_RUNE:
                                iterations = 10;
                                break;
                            case BIG_COUNTER_CYCLE_RUNE:
                                iterations = 15;
                                break;
                        }
                    }
                    notClosedCycles++;
                    i++; // сразу пропускаем руну счетчика
                } else if (rune.getTypeSymbolRune() == TypeSymbol.END_CYCLE_RUNE) {
                    // эта руна закрывает первый цикл?
                    if (notClosedCycles == 1){
                        endPos = i;
                    }
                    notClosedCycles--;
                }
            }
            if (endPos != -1){
                // инициализация массива рун находящихся между рунами: счетчик и конец цикла
                for (int j = startPos; j < endPos; j++){
                    runesListToCycling.add(oldRunesList.get(j));
                }
                startPos -= 2;
                // копируем элементы до руны начала цикла
                for (int j = 0; j < startPos; j++){
                    newRunesList.add(oldRunesList.get(j));
                }
                // дублируем элементы которые должны были зациклить
                do {
                    newRunesList.addAll(runesListToCycling);
                    iterations--;
                } while (iterations != 0);
                // копируем элементы после руны конца цикла
                for (int j = endPos + 1; j < oldRunesList.size(); j++){
                    newRunesList.add(oldRunesList.get(j));
                }

                // перезапись активного массива
                this.spellRuneList = newRunesList;
                return;

            }
            i++;
        }
    }

    private boolean runeListHasCycle(){
        ArrayList<Rune> runeArrayList = this.spellRuneList;
        for (Rune rune : runeArrayList){
            if (rune.getTypeRune() == TypeRune.CYCLE_RUNE){
                return true;
            }
        }
        return false;
    }
    public boolean setSpellRuneList(ArrayList<Rune> spellRuneList) {
        // Проверка на корректность рун цикла.
        if(!cycleRuneArrayChecker(spellRuneList)){ return false; }
        // Инициализация внутреннего массива рун
        this.spellRuneList = spellRuneList;
        // Пересоздание массива рун в линейный без циклов
        while (runeListHasCycle()){
            // надо бы ограничение поставить на вложенность циклов
            cycleRuneArrayConverter();
        }

        return true;
    }

    public int getSpellSize() {
        return spellSize;
    }

    public int getSpellShape() {
        return spellShape;
    }

    public int getSpellConcentration() {
        return spellConcentration;
    }

    public int getSpellEnergyType() {
        return spellEnergyType;
    }

    public ArrayList<Rune> getSpellRuneList() {
        return spellRuneList;
    }
}
