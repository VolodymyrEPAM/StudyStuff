package utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatterns {
    private final static String streetNamePattern = "(\\s\\w+){2}";
    private final static String streetNumberPattern = "(\\d+)";
    private final static String suiteNumberPattern = "\\d+";
    private final static String statePattern = "\\w+";
    private final static String postalCodePattern = "\\w+\\s\\d{5}";
    private final static String countryPattern = "\\w{3}";

    public static String getStreetName(String address) {
        String neededAddressPart = Arrays.asList(address.split("•")).get(0);
        return getValueByRegex(neededAddressPart.trim(), streetNamePattern).trim();
    }

    public static String getStreetNumber(String address) {
        String neededAddressPart = Arrays.asList(address.split("•")).get(0);
        return getValueByRegex(neededAddressPart.trim(), streetNumberPattern).trim();
    }

    public static String getSuiteNumber(String address) {
        String neededAddressPart = Arrays.asList(address.split("•")).get(1);
        return getValueByRegex(neededAddressPart.trim(), suiteNumberPattern).trim();
    }

    public static String getStateName(String address) {
        String neededAddressPart = Arrays.asList(address.split(",")).get(1);
        return getValueByRegex(neededAddressPart.trim(), statePattern).trim();
    }

    public static String getPostalCode(String address) {
        String neededAddressPart = Arrays.asList(address.split("•")).get(1);
        return getValueByRegex(neededAddressPart.trim(), postalCodePattern).trim();
    }

    public static String getCountry(String address) {
        String neededAddressPart = Arrays.asList(address.split("•")).get(2);
        return getValueByRegex(neededAddressPart.trim(), countryPattern).trim();
    }

    private static Boolean isRegex(String expression, String regex) {
        return expression.matches(regex);
    }

    private static String getValueByRegex(String text, String pattern, int group) {
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    private static String getValueByRegex(String text, String pattern) {
        int firstGroup = 0;
        return getValueByRegex(text, pattern, firstGroup);
    }

}