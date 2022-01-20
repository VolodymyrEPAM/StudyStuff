package lambdastreams.task2;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Book {
    public static void main(String[] args) {
        List<Book> books = getBookList(10);
        System.out.println("Sub-task 1////////////////////////////////");
       books.stream()
               .forEach(x-> System.out.println(x.toString()));
        System.out.println("Sub-task 2////////////////////////////////");
       Stream.of(books.stream()
               .map(x->x.getName())
               .collect(Collectors.toList()))
               .forEach(System.out::println);
        System.out.println("Sub-task 3////////////////////////////////");
        System.out.println(books.stream()
                .mapToInt(Book::getPrice).sum());
        System.out.println("Sub-task 4////////////////////////////////");
        System.out.println(books.stream()
                .filter(x->x.getName().contains("a")||x.getName().contains("A"))
                        .map(x->x.getName())
                .findAny());
        System.out.println("Sub-task 5////////////////////////////////");
        System.out.println(books.stream()
                .mapToInt(Book::getPrice).max());
        System.out.println("Sub-task 6////////////////////////////////");
        books.stream()
                .filter(x->x.getName().length()==5)
                .forEach(System.out::println);
        System.out.println("Sub-task 7////////////////////////////////");
        books.stream()
                .filter(x->x.getPrice()<30)
                .forEach(System.out::println);
        System.out.println("Sub-task 8////////////////////////////////");
        books.stream()
                .sorted(Comparator.comparing(Book::getName).thenComparing(Book::getPrice))
                .forEach(System.out::println);
    }

    protected String name;
    protected Integer price;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static List<Book> getBookList(int sizeOfBookList) {
        List<Book> bookList = new ArrayList<>(sizeOfBookList);
        IntStream.range(0, sizeOfBookList).forEach(x -> bookList.add(new Book(
                RandomStringUtils.randomAlphabetic(3, 10),
                Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)))));
        return bookList;
    }
}
