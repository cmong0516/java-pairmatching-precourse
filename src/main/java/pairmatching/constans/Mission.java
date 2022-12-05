package pairmatching.constans;

import java.util.Arrays;

public enum Mission {
    RACING_CAR(Level.LEVEL1,"자동차경주"),
    LOTTO(Level.LEVEL1,"로또"),
    NUMBER_BASEBALL(Level.LEVEL1,"숫자야구게임"),
    CART(Level.LEVEL2,"장바구니"),
    PAYMENT(Level.LEVEL2,"결제"),
    SUBWAY_MAP(Level.LEVEL2,"지하철노선도"),
    PERFORMANCE_IMPROVEMENTS(Level.LEVEL4,"성능개선"),
    DEPLOYMENT(Level.LEVEL4,"배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static Mission findByName(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
