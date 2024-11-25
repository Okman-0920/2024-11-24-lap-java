package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App ();
        app.run();
    }
}

class App {
    public void run() {
        Scanner cmd = new Scanner(System.in);
        int id = 0;

        System.out.println("== 명연 앱 ==");
        System.out.print("명령) ");

        while (true) {
            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String content = cmd.nextLine();

                System.out.print("작가: ");
                String author = cmd.nextLine();

                ++id;

                WiseSaying 명언 = new WiseSaying();
//                WiseSaying.id = id;
//                WiseSaying.content = content;
//                WiseSaying.author = author;

                System.out.println("%d번 명언이 등록되었습니다".formatted(id));
            }
        }
//        scanner.close();
    }
}
class WiseSaying {
    int id;
    String content;
    String author;
}



