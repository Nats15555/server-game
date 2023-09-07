package gameLogic.runeDescription.enams;

public enum TypeRune {

    // Питательная руна.
    // Проверяет цену всех рун в последовательности.
    // Служит для подсчета количества необходимой энергии для заклинания
    NOURISHING_RUNE(Integer.MAX_VALUE),

    // Руна формы заклинания
    // Задаёт форму заклинанию
    SHAPE_RUNE(0),

    // Руна размера заклинания
    SIZE_RUNE(0),

    // Руна концентрации энергии. Влияет на мощь заклинания
    ENERGY_CONCENTRATION_RUNE(0),

    // Руна типа энергии
    ENERGY_TYPE_RUNE(0),

    // Руна зацикливания.
    // Повторяет N раз всё, что находится между рунами start и end
    // Для работы необходимо указать количество повторений (N).
    // Ускоряет каст ценой затрат энергии
    CYCLE_RUNE(1),

    // Руна направления движения заклинания.
    DIRECTION_RUNE(2);

    public int priority;

    TypeRune(int priority) {
        this.priority = priority;
    }
}
