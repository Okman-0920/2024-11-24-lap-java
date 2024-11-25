package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDelete {

    public static void main(String[] args) {
        // Person 객체들을 저장할 ArrayList
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 사람 객체 추가
        people.add(new Person(1, "Alice"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Charlie"));

        // 초기 리스트 출력
        System.out.println("초기 리스트: " + people);

        // 번호가 1인 사람을 삭제
        people.removeIf (person -> person.id == 2);

        // 삭제 후 리스트 출력
        System.out.println("삭제 후 리스트: " + people);

    }
}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}