package converter;

public class ConverterRunner {
    public static void main(String[] args) {
        Converter fConverter = new Farengaite();
        Converter cConverter = new Calvin();
        System.out.println("Fdegree: " + fConverter.convert(1));
        System.out.println("Cdegree:" + cConverter.convert(1));
    }
}
