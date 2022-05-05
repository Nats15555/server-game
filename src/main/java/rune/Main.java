package rune;
import spell.Spell;

import java.util.ArrayList;

import static rune.TypeSymbol.*;


public class Main {

    public static void main(String[] args) {
        ArrayList<Rune> smallFireBall = new ArrayList<Rune>();

        // данная последовательность рун создаёт огненный шар, который двигается вперед
        // придаём форму сферы
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SPHERE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        // задаём размер
        smallFireBall.add(new Rune(10, 1000, SMALL_SIZE_RUNE, TypeRune.SIZE_RUNE));
        // выбираем тип энергии
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.FIRE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        // выбираем уровень силы (мсщь)
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SMALL_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));
        // Либо сделать возможность регулировать количество итераций клиентом.
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SMALL_COUNTER_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, SMALL_SIZE_RUNE, TypeRune.SIZE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SMALL_COUNTER_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SMALL_COUNTER_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.FORWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));

        smallFireBall.add(new Rune(10, 1000, TypeSymbol.FIRE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));

        smallFireBall.add(new Rune(10, 1000, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.SMALL_COUNTER_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.FORWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        smallFireBall.add(new Rune(10, 1000, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        // проверяем необходимое количество энергии на каст заклинания
        smallFireBall.add(new Rune(10, 1000, BASE_NOURISHING_RUNE, TypeRune.NOURISHING_RUNE));



        // множественные баги в функции setSpellRuneList
        Spell spell = new Spell(0,0,0,0,null);
        System.out.println(spell.getSpellRuneList());
        spell.setSpellRuneList(smallFireBall);
        ArrayList<Rune> runeArrayList = spell.getSpellRuneList();
        for (Rune rune : runeArrayList){
            if (rune.getTypeSymbolRune() == BASE_NOURISHING_RUNE) {
                System.out.println("BASE_NOURISHING_RUNE");
            }else if (rune.getTypeSymbolRune() == SMALL_SIZE_RUNE) {
                System.out.println("SMALL_SIZE_RUNE");
            } else if (rune.getTypeSymbolRune() == SPHERE_SHAPE_RUNE) {
                System.out.println("SPHERE_SHAPE_RUNE");
            } else if (rune.getTypeSymbolRune() == FIRE_ENERGY_RUNE) {
                System.out.println("FIRE_ENERGY_RUNE");
            } else if (rune.getTypeSymbolRune() == SMALL_CONCENTRATION_RUNE) {
                System.out.println("SMALL_CONCENTRATION_RUNE");
            } else if (rune.getTypeSymbolRune() == START_CYCLE_RUNE) {
                System.out.println("START_CYCLE_RUNE");
            } else if (rune.getTypeSymbolRune() == SMALL_COUNTER_CYCLE_RUNE) {
                System.out.println("SMALL_COUNTER_CYCLE_RUNE");
            } else if (rune.getTypeSymbolRune() == FORWARD_DIRECTION_RUNE) {
                System.out.println("FORWARD_DIRECTION_RUNE");
            } else if (rune.getTypeSymbolRune() == END_CYCLE_RUNE) {
                System.out.println("END_CYCLE_RUNE");
            } else System.out.println("unknown error");
        }

    }

}
