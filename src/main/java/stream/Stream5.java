package stream;

import java.util.Arrays;

public class Stream5 {
    public static void main(String[] args) {
        System.out.println("== No Stream ==");
        noStreamVersion();

        System.out.println("== Stream v1 ==");
        streamVersionV1();

        System.out.println("== Stream v2 ==");
        streamVersionV2();
    }

    private static void noStreamVersion() {
        int[] numbers = new int[]{1, 2, 3};

        String[] messages = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) continue;

            messages[i] = numbers[i] + "번";
        }

        System.out.println("= 원본 =");
        System.out.println(Arrays.toString(numbers));
        System.out.println("= 결과 =");
        System.out.println(Arrays.toString(messages));
    }

    private static void streamVersionV1() {
        Object[] array = Arrays.stream(new int[]{1, 2, 3})
                .filter(e -> e % 2 != 0)
                .mapToObj(e -> e + "번")
                .toArray();

        System.out.println("= 결과 =");
        System.out.println(Arrays.toString(array));
    }

    private static void streamVersionV2() {
        String[] array = Arrays.stream(new int[]{1, 2, 3})
                .filter(e -> e % 2 != 0)
                .mapToObj(e -> e + "번")
                .toArray(String[]::new); // 외울 것

        System.out.println("= 결과 =");
        System.out.println(Arrays.toString(array));
    }
}