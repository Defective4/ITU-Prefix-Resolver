package io.github.defective4.ham.ituresolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringRangeResolver {

    private static class CharRange {
        private final char from, to;

        public CharRange(char from, char to) {
            this.from = from;
            this.to = to;
        }

        public char[] getCharactersInRange() {
            int diff = to - from;
            char[] c = new char[diff + 1];
            for (int x = 0; x <= diff; x++) {
                c[x] = (char) (from + x);
            }
            return c;
        }
    }

    public static List<String> resolve(String from, String to) {
        List<String> resolved = new ArrayList<>();
        CharRange char1 = getRangeFor(from, to, 0);
        CharRange char2 = getRangeFor(from, to, 1);
        CharRange char3 = getRangeFor(from, to, 2);

        for (char c : char1.getCharactersInRange()) {

            if (char2 != null) for (char d : char2.getCharactersInRange()) {

                if (char3 != null) for (char e : char3.getCharactersInRange()) {
                    resolved.add(new String(new char[] {
                            c, d, e
                    }));
                }
                else resolved.add(new String(new char[] {
                        c, d
                }));
            }
            else resolved.add(new String(new char[] {
                    c
            }));
        }

        return Collections.unmodifiableList(resolved);
    }

    private static CharRange getRangeFor(String pair1, String pair2, int index) {
        return index >= pair1.length() ? null : new CharRange(pair1.charAt(index), pair2.charAt(index));
    }
}
