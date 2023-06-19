package codinGameExamples;

import java.util.*;
import java.util.stream.Collectors;

public class Driver {

    public static Collection<String> mapToUppercase(String... names) {
        Collection<String> uppercaseNames;
/*        for(String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }*/
        uppercaseNames = Arrays.stream(names)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return uppercaseNames;
    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {

        return Arrays.stream(names)
                .filter(item -> item.length() > 5)
                .mapToInt(String::length)
                .sum();
    }

    // * Nested List
    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection;
/*        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }*/

        /*  ? {1,2,3}
            ? {4,5,6} -> flatMap'ten önce bu şekilde 2 boyutlu

            ? {1,2,3,4,5,6} -> flatMap'ten sonra tek boyutlu
         */

        newCollection = collection.stream() // ? Stream<Stream<String>>
                .flatMap(Collection::stream) // ? Stream<String>
                .collect(Collectors.toList());
        return newCollection;
    }


    public static Person getOldestPerson(List<Person> people) {
 /*        Person oldestPerson = new Person("", 0);
       for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
        */
        /* ? Person sınıfını Comparable arayüzden implement ettik ve compareTo() metodunu override ettik ve
            ? "age" özelliğine göre karşılaştırmasını sağladık bu yüzden "Person::compareTo" şeklinde
            ?  kullanabildik. Eğer Person sınıfını Comparable arayüzden implement etmediysek veya
            ? compareTo() metodunu override etmediysek alttaki return'ü kullanabiliriz. */
        return people.stream()
                .max(Person::compareTo)
                .orElse(null); // ? max() metodu Optional döndüğü için bu satıtı ekledik
        /* !
        ! return people.stream()
        !         .max(Comparator.comparingInt(Person::getAge))
        !         .orElse(null);
        ! */
    }

    public static int calculate(List<Integer> numbers) {
/*        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;*/

        // ? .reduce((item,sum) -> item + sum) => aşağıdaki satırın açık hali
        return numbers.stream()
                .reduce(Integer::sum)// ? reduce: her seferinde listeden 1 eleman azaltır. çıkartılan öge sum ile toplanır
                .orElse(0);

    }

    public static Set<String> getKidNames(List<Person> people) {
       Set<String> kids = new HashSet<>();
/*         for (Person person : people) {
            if (person.getAge() < 18) {
                kids.add(person.getName());
            }
        } */

        // * İki şekilde yapılabilir
        return people.stream()
                .filter(item -> item.getAge() < 18) // ? Stream<Person>
                .map(Person::getName)               // ? Stream<String>
                .collect(Collectors.toSet());       // ? Set<String>

/*      ? ikinci yol
        ! people.stream()
        !         .filter(item -> item.getAge() < 18)
        !         .forEach(item -> kids.add(item.getName()));
        ! return kids; */
    }

    // 18 yaşından küçük olanları "false" anahtarına, diğerlerini "true" anahtarına ekle
    public static Map<Boolean, List<Person>> groupingBy1(List<Person> people) {
/*        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map; */
        /* ? groupingBy() -> Map<T,V> döner
            ? grouping() metodunun ilk parametresi key (item -> item.getAge() >= 18)
            ? ikinci parametresi value (Collectors.toList()) */
        return people.stream()
                .collect(Collectors.groupingBy(item -> item.getAge() >= 18, Collectors.toList()));
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
/*        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;*/

        return people.stream()
                .collect(Collectors.groupingBy(Person::getNationality,Collectors.toList()));
    }

    public static String namesToString(List<Person> people) {
/*        String label = "Names: ";
        StringBuilder sb = new StringBuilder(label);
        for (Person person : people) {
            if (sb.length() > label.length()) {
                sb.append(", ");
            }
            sb.append(person.getName());
        }
        sb.append(".");
        return sb.toString();*/

        // * birinci yöntem
        /* ? reduce iki adet parametre ile çalışır. Birincisi listenin elemanları, ikincisi toplamın
            ? tutulacağı değişken.
            ? lambda operatörünün sağındaki işlemi yaparak sum değişkenine ekler */
        return "Names: " + people.stream()
                .map(Person::getName)
                .reduce((item,sum) -> item + ", " + sum)
                .orElse("") + ".";

        // * ikinci yöntem
        /*
        ! return "Names: " + people.stream()
        !         .map(Person::getName)
        !         .collect(Collectors.joining(", ")) + ".";
         */
    }

    // * sayının başına çift ise "e", tek ise "o" koy
    public static String getString(List<Integer> list) {

        // ? curly bracket içindeki kısmı ayrı bir metod olarak yazıp, map() içerisinde çağırabilirsin.
        return list.stream()
                .map(item -> {
                    String s = "";
                    if(item %2 == 0)
                        s += "e" + item;
                    else
                        s += "o" + item;
                    return s;
                })
                .collect(Collectors.joining(", "));
    }


    public static void main(String[] args) {
        String[] params = {"dog", "mouse", "rabbit", "spider", "horse"};
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("goldfish");
        list1.add("dolphin");
        list1.add("shark");
        list2.add("jaguar");
        list2.add("lion");
        list2.add("panther");
        List<List<String>> nestedList = new ArrayList<>();
        nestedList.add(list1);
        nestedList.add(list2);

        Person person1 = new Person("person1",24,"Norwegian");
        Person person2 = new Person("person2",30, "Serbian");
        Person person3 = new Person("person3",17,"Norwegian");
        Person person4 = new Person("person4",11,"Turkish");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(8);
        integerList.add(3);
        integerList.add(1);

        Collection<String> uppercase = mapToUppercase("dog", "mouse", "rabbit", "spider", "horse");
        uppercase.forEach(System.out::println);
        System.out.println(System.lineSeparator());

        int numberOfLetters = getTotalNumberOfLettersOfNamesLongerThanFive(params);
        System.out.println("number od letters: " + numberOfLetters);
        System.out.println(System.lineSeparator());

        List<String> transform1 = transform(nestedList);
        transform1.forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Person oldestPerson = getOldestPerson(personList);
        System.out.println(oldestPerson.getName() + " " + oldestPerson.getAge());
        System.out.println(System.lineSeparator());

        int calculated = calculate(integerList);
        System.out.println("calculated: " + calculated);
        System.out.println(System.lineSeparator());

        Set<String> kidNames = getKidNames(personList);
        System.out.println("kid names:");
        kidNames.forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Map<Boolean, List<Person>> booleanListMap = groupingBy1(personList);

        for (boolean key : booleanListMap.keySet()){
            booleanListMap.get(key).forEach(item -> System.out.println(key + " " + item.getAge() + " " + item.getName()));
        }
        System.out.println(System.lineSeparator());

        Map<String, List<Person>> stringListMap = groupByNationality(personList);
        for(String key : stringListMap.keySet()){
            stringListMap.get(key)
                    .forEach(item -> System.out.println(key + " " + item.getName() + " " + item.getNationality()));
        }
        System.out.println(System.lineSeparator());

        String s = namesToString(personList);
        System.out.println(s);
        System.out.println(System.lineSeparator());

        String s2 = getString(integerList);
        System.out.println(s2);
        System.out.println(System.lineSeparator());

    }
}

class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public Person(String name, int age) {
        this(name, age, "");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }
}