package nagai.tinychat.util;

public final class TinyUtil {
    public static String removeBadCtlChar(String input) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);
            if (0x1f < c && c != 0x7f || c == '\n' || c == '\r') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeAllCtlChar(String input) {
        // return input.replaceAll("[\\p{Cntrl}]", "");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);
            if (0x1f < c && c != 0x7f) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
