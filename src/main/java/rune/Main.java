package rune;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Rune> smallfireball = new ArrayList<Rune>();

        smallfireball.add(new Rune(10,1000, TypeSymbol.SPHERE_SHAPE_RUNE, TypeRune.SHAPE_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.SMALL_SIZE_RUNE, TypeRune.SIZE_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.FIRE_ENERGY_RUNE, TypeRune.ENERGY_TYPE_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.SMALL_CONCENTRATION_RUNE, TypeRune.CONCENTRATION_ENERGY_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.BASE_NOURISHING_RUNE, TypeRune.NOURISHING_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.BASE_CYCLE_RUNE, TypeRune.CYCLE_RUNE));
        smallfireball.add(new Rune(10,1000, TypeSymbol.FORWARD_DIRECTION_RUNE, TypeRune.DIRECTION_RUNE));
    }
}
