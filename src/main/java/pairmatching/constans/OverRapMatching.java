package pairmatching.constans;

import java.util.Arrays;

public enum OverRapMatching {
    YES("네"),
    NO("아니오");

    private final String value;

    OverRapMatching(String value) {
        this.value = value;
    }

    public static OverRapMatching findByValue(String value) {
        return Arrays.stream(OverRapMatching.values())
                .filter(overRapMatching -> overRapMatching.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }

    public String getValue() {
        return value;
    }
}
