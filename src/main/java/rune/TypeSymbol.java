package rune;

public enum TypeSymbol {
    //список всех существующих рун по группам

    //NOURISHING_RUNE
    BASE_NOURISHING_RUNE,

    //SIZE_RUNE
    // В идеале надо сделать полную настройку размера клиентом в заданнах нами границах
    LARGE_SIZE_RUNE,
    MEDIUM_SIZE_RUNE,
    SMALL_SIZE_RUNE,

    //SHAPE_RUNE
    TRIANGLE_SHAPE_RUNE,
    CUBE_SHAPE_RUNE,
    SPHERE_SHAPE_RUNE,
    WOLF_SHAPE_RUNE,

    //CONCENTRATION_ENERGY_RUNE
    // Так же и здесь, надо сделать полную настройку концентрации клиентом в заданнах нами границах
    // То есть например добавить для всех рун служебное значение, которое в зависимости от руны
    // будет иметь тот или иной смысл.
    BIG_CONCENTRATION_RUNE,
    MEDIUM_CONCENTRATION_RUNE,
    SMALL_CONCENTRATION_RUNE,

    //ENERGY_TYPE_RUNE
    FIRE_ENERGY_RUNE,
    WATER_ENERGY_RUNE,
    EARTH_ENERGY_RUNE,
    AIR_ENERGY_RUNE,
    PURE_ENERGY_RUNE,
    PRANA_ENERGY_RUNE,

    //CYCLE_RUNE
    //можно заменить на одну руну, если ввести служебную переменную
    START_CYCLE_RUNE,
    END_CYCLE_RUNE,

    //DIRECTION_RUNE
    LEFT_DIRECTION_RUNE,
    RIGHT_DIRECTION_RUNE,
    FORWARD_DIRECTION_RUNE,
    BACKWARD_DIRECTION_RUNE;

    // Я бы добавил каждой руне поля: <стоимость в мане> и <количество затрачиваемового времени на каст>


    // эта конструкция решит множество проблем, вопрос надо ли её добавлять или можно обойтись без неё
    // например её можно использовать, как счётчик итераций цикла; уровня концентрации; размера;
    // длины шага, для рун типа движения; множитель затрат того или иного типа энергии
    // public int serviceVariable;
    // TypeRune(int serviceVariable) { this.serviceVariable = serviceVariable; }

}
