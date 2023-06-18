import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ListDriver {
    // * Veriler eklenen sıra ile tutulur.
    // * İstenilen index'e veri eklenebilir, istenilen index'teki veri alınabilir.
    public static void linkedList1(){
        LinkedList<Integer> list = new LinkedList<>();
        // ? Burada LinkedList yapısı Integet(wrapper) type alıyor ama biz int(primitif) type veriyoruz.
        // ? Bu dönüşüm otomatik yapılıyor. Buna "autoboxing" denir.(tersi: "auto-unboxing")
        list.add(51);
        list.add(38);
        list.add(56);
        list.add(34);
        list.add(2,102);
        list.addFirst(56);
        list.forEach(System.out::println);
        System.out.println("index 3: " + list.get(3));
        // ? Bulduğu ilk değerin index'ini getirir
        System.out.println("index of 56: " + list.indexOf(56));
        // ? Sondan başlayarak bulduğu ilk değerin index'ini geririr
        System.out.println("index of 56: " + list.lastIndexOf(56));

        // * parametre vermediğimiz zaman ilk elemanı siler
        list.remove();
        list.remove(4);
        list.forEach(System.out::println);

    }

    public static void linkedList2(){
        LinkedList<Person> list = new LinkedList<>();
        Person person1 = new Person(1,23,"person1");
        list.add(person1);
        list.add(new Person(2,32,"person2"));
        list.add(new Person(3,20,"person3"));
        list.add(new Person(3,20,"person3"));

        list.forEach(System.out::println);
        // ? Bu şekilde indexe göre değil de nesnenin kendisini parametre olarak verip silme işlemi yapabiliriz
        list.remove(person1);
        System.out.println(System.lineSeparator());
        list.forEach(System.out::println);
    }

    // * En çok kullanılan List yapısı
    public static void arrayList1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("grey");
        list.add("blue");
        list.add("white");
        list.add("black");
        list.add("green");

        list.forEach(System.out::println);
        System.out.println(System.lineSeparator());
        list.stream().filter(item -> item.startsWith("gr")).forEach(System.out::println);
    }

    public static void arrayList2(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1,43,"person1"));
        list.add(new Person(2,22,"person2"));
        list.add(new Person(3,11,"person3"));
        list.add(new Person(3,11,"person3"));

        list.forEach(item -> System.out.println(item.getId() + " " + item.getName() + " " + item.getAge()));
    }

    // * List arayüzünü implemente eder
    // * Kullanımı ArrayList ile aynıdır
    // * initial capacity verebiliriz. Eleman sayısı kapasiteyi aşarsa otomatik kapasite 2 katına çıkar
    // * Kapasiteyi aştığında ne kadar artması gerektiğini de belirleyebiliriz
    public static void vector1(){
        Vector<String> list = new Vector<>(5,10);
        list.add("elephant");
        list.add("cat");
        list.add("jaguar");
        list.add("horse");
        list.add("monkey");
        list.add("dog");

        List<String> collect = list.stream().filter(item -> item.length() > 3).toList();
        collect.forEach(System.out::println);
        System.out.println("capacity: " + list.capacity());
    }

    public static void vector2(){
        Vector<Person> list = new Vector<>();
        list.add(new Person(1,43,"person1"));
        list.add(new Person(2,22,"person2"));
        list.add(new Person(3,11,"person3"));
        list.add(new Person(3,11,"person3"));
        list.add(new Person(5,19,"person5"));

        // ? yaşı 11 den büyük olanların isimlerini büyük harfe çevirerek ekrana yaz
        list.stream()
                .filter(item -> item.getAge() > 11)
                .forEach(item -> {
                    item.setName(item.getName().toUpperCase());
                    System.out.println(item.getId() + " " + item.getName() + " " + item.getAge());
                });
    }

    public static void main(String[] args) {
        linkedList1();
        System.out.println(System.lineSeparator());
        linkedList2();
        System.out.println(System.lineSeparator());
        arrayList1();
        System.out.println(System.lineSeparator());
        arrayList2();
        System.out.println(System.lineSeparator());
        vector1();
        System.out.println(System.lineSeparator());
        vector2();
        System.out.println(System.lineSeparator());


    }
}

// * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Person{
    private int id;
    private int age;
    private String name;

    public Person() {
    }

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
