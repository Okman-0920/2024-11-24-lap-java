package stream;

import java.util.Arrays;

public class Stream4 {
    public static void main(String[] args) {
        System.out.println("== No Stream ==");

        noStreamVersion();

        System.out.println("== Stream ==");

        streamVersion();
    }

    private static void noStreamVersion() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("= 원본 numbers(변형 전) =");
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= 2;
        }

        System.out.println("= 원본 numbers(변형 후) =");
        System.out.println(Arrays.toString(numbers));
    }


    private static void streamVersion() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("= 원본 numbers(스트림 전) =");
        System.out.println(Arrays.toString(numbers));

        int[] calculatedNumbers = Arrays.stream(numbers)
                .map(e -> e * 2)
                .toArray(); // 새로운 배열을 만드는 것이다

        System.out.println("= 원본 numbers(스트림 후) =");
        System.out.println(Arrays.toString(numbers));

        System.out.println("= 새 배열 calculatedNumbers =");
        System.out.println(Arrays.toString(calculatedNumbers));
    }
}
