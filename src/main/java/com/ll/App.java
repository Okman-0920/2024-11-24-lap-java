package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private int id;
    private final List<WiseSaying> wiseSayingList;

    public App() {
        scanner = new Scanner(System.in);
        id = 0;
        wiseSayingList = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        makeSampleData();

        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다");
                break;

            } else if (cmd.equals("등록")) {
                actionAdd();

            } else if (cmd.equals("목록")) {
                actionList();

            } else if (cmd.startsWith("삭제")) {
                String strDelete = cmd.substring(6);
                int deleteId = Integer.parseInt(strDelete);

                actionDelete(deleteId);


            } else if (cmd.startsWith("수정")) {
                String strModify = cmd.substring(6);
                int modifyId = Integer.parseInt(strModify);

                actionModify(modifyId);
            }
        }
        scanner.close();
    }

    private void makeSampleData() {
        addWiseSaying("이순신 장군", "나의 죽음을 적에게 알리지 말라");
        addWiseSaying("소크라테스","너 자신을 알라");
    }

    private void actionAdd() {
        System.out.println("작가: ");
        String author = scanner.nextLine();

        System.out.println("명언: ");
        String content = scanner.nextLine();

        addWiseSaying(author, content);
    }

    private void addWiseSaying(String author, String content) {
        ++id;
        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayingList.add(wiseSaying);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언\n----------------------");
        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    private void actionDelete(int deleteId) {
        boolean remove = wiseSayingList.removeIf(wiseSaying -> wiseSaying.getId() == deleteId);
        if (remove) System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
        else System.out.println("등록되지 않은 명언 또는 이미 삭제된 명언 입니다.");
    }

    private void actionModify(int modifyId) {
        WiseSaying findWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == modifyId) {
                findWiseSaying = wiseSaying;
                break;
            }
        }

        if (findWiseSaying == null) {
            System.out.println("등록되지 않은 명언 또는 이미 삭제된 명언 입니다.");
        }
        System.out.println("(기존)작가 %s".formatted(findWiseSaying.getAuthor()));
        System.out.println("작가: ");
        String author = scanner.nextLine();

        System.out.println("(기존)작가 %s".formatted(findWiseSaying.getContent()));
        System.out.println("명언: ");
        String content = scanner.nextLine();

        findWiseSaying.setAuthor(author);
        findWiseSaying.setContent(content);

        System.out.println("%s번 명언이 수정되었습니다".formatted(findWiseSaying.getId()));
    }
}
