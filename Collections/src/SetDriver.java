import java.util.*;

// ? Set koleksiyonunun get metodu yoktur. Veriler iterator ile gezilir.
public class SetDriver {

    // * SortedSet referansı ile
    // * SortedSet<>, elementler sıralı olarak tutulur
    public static void treeSet1(){
        SortedSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(1);
        set.add(10);
        set.add(4);

        for (int item : set) {
            System.out.println(item);
        }
    }

    // * SortedSet referansı ile
    public static void treeSet2(){
        // ! Burada c# en son yazdırılır. Çünkü küçük harfler ascii tablosunda büyük harflerden sonra gelir.
        SortedSet<String> set = new TreeSet<>();
        set.add("Ruby");
        set.add("Python");
        set.add("c#");
        set.add("Java");

        for(String item : set){
            System.out.println(item);
        }
    }

    // * SortedSet referansı ile
    // * Object tutan SortedSet. Object, Comparable<> arayüzünü implement etmelidir.
    public static void treeSet3(){
        SortedSet<Person1> set = new TreeSet<>();
        set.add(new Person1(22,"person1"));
        set.add(new Person1(55,"person2"));
        set.add(new Person1(33,"person3"));
        set.add(new Person1(44,"person4"));
        /* ? Bu satırı set'e eklemez. Çünkü Person sınıfının compareTo() metodu age alanına göre karşılaştırma yapıyor.
           ? age alanı 44 olan veri zaten olduğu için ekeleme yapılmaz. Eğer compareTo() metodunu name alanlarını
            ? karşılaştırcak şekilde yazsaydık aynı name alanına sahip Person nesnelerini ekleyemeyecektik. */
        set.add(new Person1(44,"person5"));
        for (Person1 person : set){
            System.out.println(person.getAge() + " " + person.getName());
        }
    }

    // * NavigableSet referansı ile
    // * NavigableSet<>, SortedSet<>'i extend eder. TreeSet, NavigableSet'i extend eder
    public static void treeSet4(){
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(11);
        set.add(24);
        set.add(20);
        set.add(45);

        System.out.println("first item, equals or higher than 21: " + set.ceiling(21));
        System.out.println("first item, equals or less than 19: " + set.floor(19));
        System.out.println("first item, less than 45: " + set.lower(45));
        System.out.println("first item, greater than 24: " + set.higher(24));

        System.out.println("items up to the item that value of 25: ");
        for (Integer integer : set.headSet(24,true)) {
            System.out.print(integer + ", ");
        }

    }

    // * Veri depolamak için tree kullanan collection yaratır
    // * Depoladığı elemanları artan sıra ile kaydeder
    public static void treeSet5(){
        TreeSet<String> set = new TreeSet<>();
        set.add("blue");
        set.add("purple");
        set.add("black");
        set.add("blue");

        for(String item : set){
            System.out.println(item);
        }
    }

    public static void treeSet6(){
        TreeSet<Person1> set = new TreeSet<>();
        set.add(new Person1(22,"person1"));
        set.add(new Person1(55,"person2"));
        set.add(new Person1(33,"person3"));
        set.add(new Person1(44,"person4"));
        // ? compareTo() metodunda ayarladığımız şekilde "person5" eklenmez
        set.add(new Person1(44,"person5"));
        for (Person1 person : set){
            System.out.println(person.getAge() + " " + person.getName());
        }

    }

    /* * HashSet<>, depolamak için hash tablosu kullanan koleksiyon yaratır
       * Hash tablosuna eklenen elementlerinin sıralı olmasını garanti etmez. Çünkü hashing işlemi yeterince zamanını alır.
    * */
    public static void hashSet(){
        HashSet<String> set = new HashSet<>();
        set.add("name1");
        set.add("name3");
        set.add("name2");
        // ! İkinci bir "name3" elementini eklemeyecektir
        set.add("name2");

        System.out.println(set.size());
        for(String item : set){
            System.out.println(item);
        }
    }

    // * Object tutan HashSet.
    /* ! TreeSet için Object, Comparable arayüzünü implemente etmek zorundaydı. Çünkü sıralı tutuyordu ve compareTo metodu şarttı.
        ! Ama HashSet için bu zorunluluk yok */
    /* * HashSet içinde tutulan nesnenin oluşturulduğu sınıf içerisinde compareTo() metodu override edilmediyse
        * aynı alanlara(field) sahip nesneler eklenebilir. Çünkü nesnelerin hashCode'larına bakılır. Bu yüzden
        * aynı veriyi tutmak istemiyorsak hashCode() ve equals() metodları override edilmeli */
    /* * hashCode() metodunu override etmediğimiz zaman bütün nesnelerin hashCode değeri farklı olacaktır.
        * hashCode() metodunu override edip, equals() metodunu override etmediğimiz zaman, özellikleri aynı
        * olan nesnelerin hashCode değeri aynı olur fakat yine de HashSet içerisine eklenir. equals() metodu da
        * override edildiği zaman istediğimiz olması gerektiği gibi çalışır.
     * */
    /* ? Aynı field'lara sahip nesnelerin HashSet içerisine eklenmesinin önüne geçmek için neden sadece
        ? equals() ya da hashCode() metodunu override etmek yetmiyor? */
    // ? hashCode()'u override edip, equals()'u etmediğimiz zaman ayno hash code ile birden fazla nesneyi nasıl ekliyoruz?
    public static void hashSet2(){
        HashSet<Person2> set = new HashSet<>();
        set.add(new Person2(51,"person1"));
        set.add(new Person2(51,"person1"));
        set.add(new Person2(51,"person2"));
        set.add(new Person2(19,"person2"));
        set.add(new Person2(38,"person3"));

        for (Person2 person : set){
            System.out.println(person.getAge() + " " + person.getName() + ", hashCode: " + person.hashCode());
        }
    }

    // * LinkedHashSet, kümeye yapılan girişleri LinkedList olarak tutar.
    /* * Verileri LinkedList olarak tuttuğu için veriler eklenilen sıra tutulur ve geri alınabilir.(Diğer Set
        * sınıflarında ekleme sırasının bir önemi yoktur) */
    public static void linkedHashSet(){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(5);
        set.add(3);
        set.add(4);
        set.add(3);

        System.out.println("set size: "+set.size());
        for (int item : set){
            System.out.println(item);
        }
    }

    /* * Yukarıda HashSet hakkında açıklama var. LinkedHashSet'in kullanım olarak tek farkı veriler eklenildiği
        * sırada tutulur ve geri alınır. */
    public static void linkedHashSet2(){
        LinkedHashSet<Person2> set = new LinkedHashSet<>();
        set.add(new Person2(51,"person1"));
        set.add(new Person2(51,"person1"));
        set.add(new Person2(51,"person2"));
        set.add(new Person2(19,"person2"));
        set.add(new Person2(38,"person3"));

        for (Person2 person : set){
            System.out.println(person.getAge() + " " + person.getName() + ", hashCode: " + person.hashCode());
        }
    }

    public static void main(String[] args) {

        treeSet1();
        System.out.println(System.lineSeparator());
        treeSet2();
        System.out.println(System.lineSeparator());
        treeSet3();
        System.out.println(System.lineSeparator());
        treeSet4();
        System.out.println(System.lineSeparator());
        treeSet5();
        System.out.println(System.lineSeparator());
        treeSet6();
//        System.out.println(System.lineSeparator());
//        hashSet();
//        System.out.println(System.lineSeparator());
//        hashSet2();
//        System.out.println(System.lineSeparator());
//        linkedHashSet();
//        System.out.println(System.lineSeparator());
//        linkedHashSet2();

    }
}

// * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Person1 implements Comparable<Person1>{

    private int age;
    private String name;

    public Person1() {
    }

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
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
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person1 o) {
        return this.getAge() - o.getAge();
        // ? return this.name.compareTo(o.getName());
    }
}

// * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Person2{
    private int age;
    private String name;

    public Person2() {
    }

    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age && Objects.equals(this.name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
