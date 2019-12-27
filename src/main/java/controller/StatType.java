package controller;

public enum StatType {
    ALL_GAMES("all_games"),
    HOME("is_home"),
    AWAY("is_away"),
    FAVORITE("is_fav"),
    UNDERDOG("is_dog"),
    HOME_FAVORITE("is_home_fav"),
    HOME_UNDERDOG("is_home_dog"),
    AWAY_FAVORITE("is_away_fav"),
    AWAY_UNDERDOG("is_away_dog"),
    NO_REST("no_rest"),
    ONE_DAY_OFF("one_day_off"),
    TWO_THREE_DAYS_OFF("two_three_days_off"),
    FOUR_PLUS_DAYS_OFF("four_plus_days_off"),
    EQUAL_REST("equal_rest"),
    REST_ADVANTAGE("rest_advantage"),
    REST_DISADVANTAGE("rest_disadvantage"),
    CONFERENCE("is_conference"),
    NON_CONFERENCE("non_conference"),
    DIVISION("is_division"),
    NON_DIVISION("non_division"),
    AFTER_WIN("is_after_win"),
    AFTER_LOSS("is_after_loss");

    private final String value;

    StatType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
