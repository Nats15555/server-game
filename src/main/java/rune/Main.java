package rune;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<RuneTemplate> smallFireBall = new ArrayList<>();
        System.out.println(smallFireBall.size());
        smallFireBall.add(new NourishingRune(10, 1000, TypeSymbol.SPHERE_SHAPE_RUNE));
        System.out.println(smallFireBall.size());
    }

}
