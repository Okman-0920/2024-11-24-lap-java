package stream;

import java.util.Arrays;
import java.util.List;

public class Stream7 {
    public static void main(String[] args) {
        // v1 int -> List
        List<Integer> list1 = Arrays
                .stream(new int[]{10, 20, 30})
                .mapToObj(e -> e)
                .toList();

        // v2
        List<Integer> list2 = Arrays
                .stream(new int[]{10, 20, 30})
                .boxed() // int => Integer
                .toList();

        // v3
        List<Integer> list3 = Arrays
                .stream(new Integer[]{10, 20, 30})
                .toList();
    }
}
