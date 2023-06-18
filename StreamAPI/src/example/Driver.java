package example;

import java.util.*;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3,"student1",12));
        list.add(new Student(5,"student2",9));
        list.add(new Student(1,"student3",20));
        list.add(new Student(17,"student4",15));

        List<Student> list1 = list.stream().filter(item -> item.getAge() > 13).toList();
        list1.forEach(System.out::println);

        // * grouping operation
        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getAge));
        // * print map
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println(System.lineSeparator());

        // * average age
        double averageAge = list.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(averageAge);
        System.out.println(System.lineSeparator());

        // * statistic : count, sum, min, max, average
        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
    }
}
