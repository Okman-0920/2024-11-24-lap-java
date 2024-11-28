package stream;

import java.util.stream.IntStream;

public class Stream2 {
    public static void main(String[] args) {
        // 일반 for 반복문
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
                // forEach에서 실행하는 반복문이 들어온 입력값을 인자로 입력하는 단순형태는

        // 스트림
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);
    }
}