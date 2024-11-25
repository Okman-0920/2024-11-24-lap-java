package practice;

public class startWithSubstring {
    public static void main(String[] args) {
        String str = "안녕하세요";
        System.out.println(str.substring(0, 2));
        System.out.println(str.substring(2, 4));
        System.out.println(str.substring(2));

        String delete = "삭제?id=10";
        System.out.println(delete.substring(6));
    }

}
