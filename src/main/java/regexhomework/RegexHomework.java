package regexhomework;

public class RegexHomework {

    public static void main(String[] args) {
        String cardPattern = "\\d{4}\\s\\d{4} [0-9]{4} \\d\\d\\d\\d";
        String cardExample = "3221 1234 5322 1234";
        String ipPattern = "00[A-Z]{1}[1-9]{1}[A-Z]{1}[0]{5}[0-9]{2}[A-Z]{1}0[a-z]{1}";
        String ipExample = "00N5I0000040G0s";
        String emailPattern = "[\\w{5,12}\\d{1,}]{9,20}@[a-z]{4,12}\\.(com|net)";
        String emailExample = "some_email123@gmail.net";
        System.out.println(isRegex(cardExample, cardPattern));
        System.out.println(isRegex(ipExample, ipPattern));
        System.out.println(isRegex(emailExample, emailPattern));
    }

    public static Boolean isRegex(String expression, String regex) {
        return expression.matches(regex);
    }
}
