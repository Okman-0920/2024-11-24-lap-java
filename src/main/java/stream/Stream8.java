package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream8 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1,"Alice",20,'F' ));
        people.add(new Person(2,"Bob",25,'M'));
        people.add(new Person(3,"David",35,'M'));

        //남자의 나이의 합, 출력: 60

        System.out.println(" == no stream == ");
        noStreamVersionAge(people);

        System.out.println(" == stream == ");
        StreamVersionAge(people);

    }

    private static void noStreamVersionAge(List<Person> people) {
        int sum = 0;
        for (Person person : people) {
            if (person.getGender() == 'M') {
                sum += person.getAge();
            }
        }

        System.out.println("sum of age: " + sum);
    }

    private static void StreamVersionAge(List<Person> people) {

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
