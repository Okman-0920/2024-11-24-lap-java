package practice;

public class startWithSubstring {
    public static void main(String[] args) {
        String str = "안녕하세요";
        System.out.println(str.substring(0, 2)); // (시작, 여기이하)
        // 출력: 하세

        System.out.println(str.substring(2, 4));
        // 출력: 하세요

        String str2 = "123456";
        int a = Integer.parseInt(str2.substring(3)); // index 3부터 쭉
        System.out.println(a);
        // 출력: 456

    }
}
