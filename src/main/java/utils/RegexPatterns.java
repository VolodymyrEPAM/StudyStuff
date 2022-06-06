package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegexPatterns {
    static String streetPattern = "\\d{1,3}\\s[A-Z]{1}[a-z]{3,15}\\s[A-Z]{1}[a-z]{3,15}";
    static String suitePattern = "Suite \\d{3}";
    static String townPattern = "[A-Z]{1}\\w{3,15}";
    static String postalCodePattern = "[A-Z]{2}\\s\\d{5}";
    static String countryPattern = "[A-Z]{2,3}";
    static String replace = "([•||,])";

    public static void main(String[] args) {
        String aaddress = "41 University Drive • Suite 202,\n" +
                " Newtown, PA 18940 • USA";

        System.out.println(getStreet(aaddress));
    }

    //•
    public static String getStreet(String address) {
        List<String> asd= new ArrayList<>();
        String street =  StringUtils.substringAfter(address, replace).trim();;
        String spliterator = "•";
//       Arrays.stream(address.split(spliterator))
//                .filter(x-> street = (getValueByRegex(x,townPattern)))
//                        .forEach(x-> asd.add(x));
//       return street;
//        getValueByRegex(address, getValueByRegex(address.split(spliterator)))
//        return asd.toString();
        StringUtils.substringBetween("•",",");
        StringUtils.substringAfter(address, "•");
//       String[] needed = address.split(spliterator);
//       for (String need : needed){
//        street= getValueByRegex(need.trim(), townPattern);
//       }
//       return street;
        return getValueByRegex(street, townPattern);
    }

    private static Boolean isRegex(String expression, String regex) {
        return expression.matches(regex);
    }
    public static String getValueByRegex(String text, String pattern, int group){
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    public static String getValueByRegex(String text, String pattern){
      int firstGroup = 0;
        return getValueByRegex(text, pattern, firstGroup);
    }

}
//    String cardPattern = "\\d{4}\\s\\d{4} [0-9]{4} \\d\\d\\d\\d";
//    String cardExample = "3221 1234 5322 1234";
//    String ipPattern = "00[A-Z]{1}[1-9]{1}[A-Z]{1}[0]{5}[0-9]{2}[A-Z]{1}0[a-z]{1}";
//    String ipExample = "00N5I0000040G0s";
//    String emailPattern = "[\\w{5,12}\\d{1,}]{9,20}@[a-z]{4,12}\\.(com|net)";
//    String emailExample = "some_email123@gmail.net";