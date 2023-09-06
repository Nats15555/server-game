package gameLogic.rune.enams;

public enum TypeSymbol {
    //список всех существующих рун по группам

    //NOURISHING_RUNE
    BASE_NOURISHING_RUNE(1),

    //SIZE_RUNE
    // В идеале надо сделать полную настройку размера клиентом в заданнах нами границах
    LARGE_SIZE_RUNE(1),
    MEDIUM_SIZE_RUNE(2),
    SMALL_SIZE_RUNE(3),

    //SHAPE_RUNE
    TRIANGLE_SHAPE_RUNE(1),
    CUBE_SHAPE_RUNE(2),
    SPHERE_SHAPE_RUNE(3),
    WOLF_SHAPE_RUNE(4),

    //CONCENTRATION_ENERGY_RUNE
    // Так же и здесь, надо сделать полную настройку концентрации клиентом в заданнах нами границах
    // То есть например добавить для всех рун служебное значение, которое в зависимости от руны
    // будет иметь тот или иной смысл.
    BIG_CONCENTRATION_RUNE(1),
    MEDIUM_CONCENTRATION_RUNE(2),
    SMALL_CONCENTRATION_RUNE(3),

    //ENERGY_TYPE_RUNE
    FIRE_ENERGY_RUNE(1),
    WATER_ENERGY_RUNE(2),
    EARTH_ENERGY_RUNE(3),
    AIR_ENERGY_RUNE(4),
    PURE_ENERGY_RUNE(5),
    PRANA_ENERGY_RUNE(6),

    //CYCLE_RUNE
    //можно заменить на одну руну, если ввести служебную переменную
    START_CYCLE_RUNE(1),
    END_CYCLE_RUNE(2),
    SMALL_COUNTER_CYCLE_RUNE(3), // 5
    MEDIUM_COUNTER_CYCLE_RUNE(4), // 10
    BIG_COUNTER_CYCLE_RUNE(5), // 15

    //DIRECTION_RUNE
    LEFT_DIRECTION_RUNE(1),
    RIGHT_DIRECTION_RUNE(2),
    FORWARD_DIRECTION_RUNE(3),
    BACKWARD_DIRECTION_RUNE(4);

    public int symbolId;

    // ноль - отсутсвие, поэтому с единицы
    TypeSymbol(int symbolId) {
        this.symbolId = symbolId;
    }
}
