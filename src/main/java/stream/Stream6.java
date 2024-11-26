package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream6 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Alice", 20, 'F'));
        people.add(new Person(2, "Bob", 25, 'M'));
        people.add(new Person(3, "David", 35, 'M'));

        
        System.out.println("== No stream ==");
        noStreamVersion(people);

        // 문제: 남성들의 나이의 합
        System.out.println("== stream ==");
        streamVersion(people);

        // 문제: 남성들의 나이의 평균
        System.out.println("== stream2 ==");
        streamVersion2(people);

        // 문제: 남성들의 이름
        System.out.println("== stream2 ==");
        streamVersion3(people);

    }

    private static void streamVersion3(List<Person> people) {
        String manNames = people.stream()
                .filter(person -> person.getGender() == 'M')
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println("manNames: " + manNames);

    }

    private static void streamVersion2(List<Person> people) {
        double avg = people
                .stream()
                .filter(e -> e.getGender() == 'M')
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println("avg of age: " + avg);
    }

    public static void streamVersion(List<Person> people) {
//        Optional<Person> opPerson = people.stream()
//                .filter(Person e -> e.getId() == 4)
//                .findFirst();// 하나라도 찾으면 멈춰라

//        Person found = opPerson.orElse(null);

//        System.out.println("found :" + found.getName());


    }

    public static void noStreamVersion(List<Person> people) {
        Person found = null;

        for (Person person : people) {
            if (person.getId() == 2) {
                found = person;
                break;
            }
        }

        if (found == null) {
            System.out.println("not found");
            return;
        }

        System.out.println("found: " + found.getName());
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