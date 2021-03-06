package rune;

public enum TypeRune {
    NOURISHING_RUNE(Integer.MAX_VALUE), //питательная руна
    SHAPE_RUNE(0), //руна форма
    SIZE_RUNE(0), //руна размера
    CONCENTRATION_ENERGY_RUNE(0), //руна концентрации энергии
    SOURCE_ENERGY_RUNE(0), //руна источника энергии
    DIRECTION_RUNE(1); //руна направления движения заклинания

    public int priority;

    TypeRune(int priority) {
        this.priority = priority;
    }
}
