package pairmatching.constans;

import java.util.Arrays;

public enum Function {
    PAIR_MATCHING("1"),
    FAIR_INQUIRY("2"),
    PAIR_CLEAR("3"),
    THE_END("Q");

    private final String function;

    Function(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public static Function findFuncion(String name) {
        return Arrays.stream(Function.values())
                .filter(function -> function.function.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

}
