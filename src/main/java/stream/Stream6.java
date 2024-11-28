package stream;

import java.util.Arrays;

public class Stream6 {
    public static void main(String[] args) {

        useFor();

        useStream();

        //원본: new String[] {"1번", ~ ~}
        //결과: new int[] {1,2,3}
        //조건: 짝수제거
    }

    private static void useFor() {
        String[] strNumbers = new String[] {"1번", "2번", "3번"};
        int[] numbers = new int[strNumbers.length];

        for (int i = 0 ; i < strNumbers.length; i++) { //문자의 마지막 열에서 1개 빼겠다.
            String strNum = strNumbers[i];
            strNum = strNum.substring(0, 1);
            System.out.println(strNum);
            int num = Integer.parseInt(strNum);

            if (num % 2 == 0) continue;

            numbers[i] = num;
        }
    }

    private static void useStream() {
        int[] array = Arrays.stream(new String[]{"1번", "2번", "3번"})
                .map(e -> e.substring(0, e.length() - 1))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .toArray();

        System.out.println(" == ");
        System.out.println(Arrays.toString(array));

    }


}
