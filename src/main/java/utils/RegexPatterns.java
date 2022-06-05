package utils;

public class RegexPatterns {
    String streetPattern = "\\d{1,3}\\s[[A-Z]{1}]"
    public static Boolean isRegex(String expression, String regex) {
        return expression.matches(regex);
    }
}
