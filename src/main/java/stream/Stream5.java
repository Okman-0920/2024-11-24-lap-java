package stream;

import java.util.Arrays;

import static stream.NoAndUse.*;

public class Stream5 {
    public static void main(String[] args) {
        System.out.println("== No Stream ==");
        noStream();

        System.out.println("== Use Stream ==");
        useStream();

        useStream2();
    }
}

class NoAndUse {
    static void noStream() {
        int[] numbers = new int[]{1, 2, 3};
        String[] stringArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) continue;
            stringArray[i] = "\"" + numbers[i] + "번\"";
        }

        System.out.println("= 원본 =");
        System.out.println(Arrays.toString(numbers));

        System.out.println("= 결과 =");
        System.out.println(Arrays.toString(stringArray));
    }

    static void useStream() {
        Object[] array = Arrays.stream(new int[]{1, 2, 3})
                .filter(e -> e % 2 != 0)
                .mapToObj(e -> "\"" + e + "번\"") // or boxed()
                .toArray();

        System.out.println("= 결과 with mapToObj =");
        System.out.println(Arrays.toString(array));
    }

    static void useStream2() {
        String[] array = Arrays.stream(new int[]{1, 2, 3})
                .filter(e -> e % 2 == 0)
                .boxed()
                .map(e -> "\"" + e + "번\"")
                .toArray(String[]::new);


        System.out.println("= 결과 with boxed =");
        System.out.println(Arrays.toString(array));
    }

}