package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private int id = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public void run() {

        System.out.println("== 명언 ==");
        makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다");
                break;

            } else if (cmd.equals("등록")) {
                actionAdd();

            } else if (cmd.equals("목록")) {
                actionList();

            } else if (cmd.startsWith("삭제")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionDelete(id);

            } else if (cmd.startsWith("수정")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionModify(id);

            } else {
                System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }

    private void makeSampleData() {
        addWiseSaying("이순신 장군","나의죽음을 적에게 알리지 마라");
        addWiseSaying("소크라테스","너 자신을 알라");
    }

    private WiseSaying addWiseSaying(String author, String content) {
        ++id;
        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    // 액션 매소드
    private void actionModify(int id) {
        WiseSaying findWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id){
                findWiseSaying = wiseSaying;
                break;
            }

            System.out.print("(기존)작가: %s".formatted(findWiseSaying.getAuthor()));
            System.out.print("작가: ");
            String author = scanner.nextLine();

            System.out.print("(기존)명언: %s".formatted(findWiseSaying.getContent()));
            System.out.print("명언: ");
            String content = scanner.nextLine();

            findWiseSaying.setAuthor(author);
            findWiseSaying.setContent(content);

            System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
        }

    }

    private void actionDelete(int id) {
        boolean remove = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        if (remove) System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        else System.out.println("이미 삭제된 명언이거나, 등록되지 않은 명언입니다".formatted(id));
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent()));
        }
    }

    private void actionAdd() {
        System.out.print("작가: ");
        String author = scanner.nextLine();

        System.out.print("명언: ");
        String content = scanner.nextLine();

        addWiseSaying(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }
}

