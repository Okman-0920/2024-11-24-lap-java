package stream;

import java.util.stream.IntStream;

public class Stream2 {
    public static void main(String[] args) {
        // 일반
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // 스트림
        IntStream.rangeClosed(1, 10)
                .forEach(e -> {
                    System.out.println(e);
                });

        // 스트림
        IntStream.rangeClosed(1, 10)
                .forEach(e -> System.out.println(e));

        // 스트림
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);

    }
}
