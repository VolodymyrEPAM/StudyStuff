package lambdastreams.task4;


interface StringFunction {
    String run(String str);
}

public class Main {
    public static void main(String[] args) {
        StringFunction exclaim = (s) -> "Hello!";
        StringFunction ask = (s) -> "Hello?";
        printFormatted("%s", exclaim);
        printFormatted("%s", ask);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.print(result);
    }
}
