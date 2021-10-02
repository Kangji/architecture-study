package org.study.architecture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BottlesTest {
    private final static String VERSE_0 =
        "No more bottles of beer on the wall, " +
            "no more bottles of beer\n" +
            "Go to the store and buy some more, " +
            "99 bottles of beer on the wall.\n";

    private final static String VERSE_1 =
        "1 bottle of beer on the wall, " +
            "1 bottle of beer.\n" +
            "Take it down and pass it around, " +
            "no more bottles of beer on the wall.\n";

    private final static String VERSE_2 =
        "2 bottles of beer on the wall, " +
            "2 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "1 bottle of beer on the wall.\n";

    private final static String VERSE_6 =
        "1 six-pack of beer on the wall, " +
            "1 six-pack of beer.\n" +
            "Take one down and pass it around, " +
            "5 bottles of beer on the wall.\n";

    private final static String VERSE_7 =
        "7 bottles of beer on the wall, " +
            "7 bottles of beer.\n" +
            "Take one down and pass it around, " +
            "1 six-pack of beer on the wall.\n";

    private final static String getVerse(int n) {
        return String.format(
            "%d bottles of beer on the wall, " +
                "%d bottles of beer.\n" +
                "Take one down and pass it around, " +
                "%d bottle of beer on the wall.\n",
            n, n, n - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 13, 19, 23, 29, 87, 99})
    public void testVerseFrom3To99(int number) {
        Bottles bottles = new Bottles();
        assertEquals(getVerse(number), bottles.verse(number));
    }

    @Test
    public void testSpecialVerse() {
        Bottles bottles = new Bottles();
        assertEquals(VERSE_0, bottles.verse(0));
        assertEquals(VERSE_1, bottles.verse(1));
        assertEquals(VERSE_2, bottles.verse(2));
        assertEquals(VERSE_6, bottles.verse(6));
        assertEquals(VERSE_7, bottles.verse(7));
    }
}
