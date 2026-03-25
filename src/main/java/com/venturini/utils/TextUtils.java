package com.venturini.utils;

/**
 * Utility class providing helper methods for text manipulation,
 * especially useful for customized logging and formatted output.
 * <p>
 * This class contains only static methods and should not be instantiated.
 *
 * @author Gabriel Venturini
 */
public class TextUtils {

    private TextUtils() {
        // Prevent instantiation
    }

    /**
     * Centers a given text within a specified width by adding whitespace
     * padding to both sides.
     * <p>
     * If the provided text is {@code null} or its length is greater than
     * or equal to the specified width, the original text is returned unchanged.
     *
     * <pre>
     * Example:
     * centerString("Hello", 10) -> "  Hello   "
     * </pre>
     *
     * @param text  the text to be centered; may be {@code null}
     * @param width the total desired width of the resulting string (including padding)
     * @return the centered text padded with spaces, or the original text if no formatting is applied
     */
    public static String centerString(String text, int width) {
        if (text == null || width <= 0 || width <= text.length()) {
            return text;
        }

        int padSize = width - text.length();
        int padStart = padSize / 2;
        int padEnd = padSize - padStart;

        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }
}
