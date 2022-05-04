package rune;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Rune> smallfireball = new ArrayList<Rune>();

        // данная последовательность рун создаёт огненный шар, который двигается вперед
        // придаём форму сферы
        smallfireball.add(new Rune(10,1000, TypeSymbol.SPHERE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        // задаём размер
        smallfireball.add(new Rune(10,1000, TypeSymbol.SMALL_SIZE_RUNE, TypeRune.SIZE_RUNE));
        // выбираем тип энергии
        smallfireball.add(new Rune(10,1000, TypeSymbol.FIRE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        // выбираем уровень силы (мсщь)
        smallfireball.add(new Rune(10,1000, TypeSymbol.SMALL_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));
        // Двигаем конструкцию вперед N раз
        // Надо подумать над тем, как реализовать цикл.
        // Либо добвать набор рун, что будут хранить в себе разное количество итераций
        // Либо сделать возможность регулировать количество итераций клиентом.
        smallfireball.add(new Rune(10,1000, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.FORWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        // проверяем необходимое количество энергии на каст заклинания
        smallfireball.add(new Rune(10,1000, TypeSymbol.BASE_NOURISHING_RUNE, TypeRune.NOURISHING_RUNE));
        // необходимо продумать работу функции циклической руны

        // список существующих рун
        // над балансом можно подумать потом (затраты энергии и время каста)
        ArrayList<Rune> runesList = new ArrayList<Rune>();
        runesList.add(new Rune(0,200, TypeSymbol.BASE_NOURISHING_RUNE, TypeRune.NOURISHING_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.SMALL_SIZE_RUNE, TypeRune.SIZE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.MEDIUM_SIZE_RUNE, TypeRune.SIZE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.LARGE_SIZE_RUNE, TypeRune.SIZE_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.CUBE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.SPHERE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.WOLF_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.TRIANGLE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.SMALL_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.MEDIUM_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.BIG_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.FIRE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.WATER_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.EARTH_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.AIR_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.PURE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.PRANA_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.START_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.END_CYCLE_RUNE, TypeRune.CYCLE_RUNE));

        runesList.add(new Rune(10,200, TypeSymbol.FORWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.BACKWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.LEFT_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
        runesList.add(new Rune(10,200, TypeSymbol.RIGHT_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));

    }
}
