package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream6 {
    class Main {
        public static void main(String[] args) {
            List<Person> people = new ArrayList<>();
            people.add(new Person(1, "Alice", 20, 'F'));
            people.add(new Person(2, "Bob", 25, 'M'));
            people.add(new Person(3, "David", 35, 'M'));

            // 문제: 남성들의 나이의 합

            System.out.println("== No stream ==");
            noStreamVersion(people);

            System.out.println("== stream ==");
            streamVersion(people);

            // 문제: 나이가 25세 이상인 사람들의 이름들을 출력
            // 출력: Bob, David
        }
    }
    public static void noStreamVersion(List<Person> people) {
    }

    public static void streamVersion(List<Person> people) {
        int sum = people
                .stream()
                .filter(e -> e.getGender() == 'M')
                .mapToInt(e -> e.getAge())
                .sum();
    }


}

class Person {
    private int id;
    private String name;
    private int age;
    private char gender;

    public Person(int id, String name, int age, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    char getGender() {
        return gender;
    }


}