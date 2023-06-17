package example;

import java.util.ArrayList;
import java.util.List;

public class Driver {
/*
    public static void listByGender(List<Person> personList, Gender gender){
        for(Person person : personList){
            if (person.getGender().equals(gender)){
                System.out.println(person);
            }
        }
    }
    public static void listByAge(List<Person> personList, int age ){
        for(Person person : personList){
            if (person.getAge() >= age){
                System.out.println(person);
            }
        }
    }
    public static void listByAgeRange(List<Person> personList, int min, int max ){
        for(Person person : personList){
            if (person.getAge() >= min && person.getAge() <= max){
                System.out.println(person);
            }
        }
    }
    */
    // * Yukarıdaki 3 metod yerine, lambda expression kullanarak tek metod kullanılabilir.
    public static void filter(List<Person> personList, PersonFilter personFilter){
        for(Person person : personList){
            if(personFilter.filter(person)){
                System.out.println(person);
            }
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args) {

        Person person1 = new Person("Sercan",10,Gender.MALE);
        Person person2 = new Person("Duygu",15,Gender.FEMALE);
        Person person3 = new Person("Sedat",20,Gender.MALE);
        Person person4 = new Person("Canan",25,Gender.FEMALE);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

/*
        listByAge(personList,15);
        listByGender(personList,Gender.MALE);
        listByAgeRange(personList,13,21);
*/
        filter(personList, p -> p.getAge() >= 15);
        filter(personList, p -> p.getGender().equals(Gender.MALE));
        filter(personList, p -> p.getAge() > 13 && p.getAge() <= 21);
    }
}
