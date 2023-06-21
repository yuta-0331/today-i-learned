package fiveDrawPoker;

import java.util.EnumMap;

public class Suit {
    public enum suit { S, C, H, D };
    public static final EnumMap<Suit.suit, Integer> suitIntegerEnumMap;

    static {
        suitIntegerEnumMap = new EnumMap<>(Suit.suit.class);
        suitIntegerEnumMap.put(Suit.suit.S, 0);
        suitIntegerEnumMap.put(Suit.suit.C, 1);
        suitIntegerEnumMap.put(Suit.suit.H, 2);
        suitIntegerEnumMap.put(Suit.suit.D, 3);
    }
}
