/*
    ? Map, key-value çifti tutar
    ? key-value çiftinin ikisi de nesnedir
    ? Unique key şart
    ? Sıralama yapmaz. TreeMap eşleme tablosunda anahtarları sıralı şekilde tutar
 */

import java.util.*;

public class MapDriver {

    public static void hashMap1(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(52,"Ordu");
        map.put(55,"Samsun");
        map.put(8,"Artvin");
        map.put(53,"Sivas");
        map.replace(53,"Rize");

        System.out.println(map.size());
        System.out.println(map.get(55));
        for (int key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void hashMap2(){
        HashMap<Integer, City> map = new HashMap<>();
        map.put(34, new City("Istanbul",15_000_000));
        map.put(55, new City("Samsun",3_000_000));
        map.put(52, new City("Ordu",1_000_000));
        map.put(61, new City("Trabzon",1_000_000));
        map.put(60, new City("Tokat",400_000));

        for(int key : map.keySet()){
            System.out.println(key + " " + map.get(key).getName() + " " + map.get(key).getPopulation());
        }
    }

    public static void hashMap3(){

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for(int i=0; i < 4; i++){
            list1.add(i+1);
            list2.add(i+10);
            list3.add(i+100);
        }

        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("key1",list1);
        map.put("key2",list2);
        map.put("key3",list3);

        for(String key : map.keySet()){
            System.out.print(key + ": ");
            map.get(key).forEach(item -> System.out.print(item + " "));
            System.out.println(System.lineSeparator());
        }

    }
    // * SortedMap referansı ile
    // * Veriler sıralı
    public static void treeMap(){
        SortedMap<String,String> map = new TreeMap<>();
        map.put("phone","telefon");
        map.put("computer", "bilgisayar");
        map.put("calendar", "takvim");

        for (String key : map.keySet())
            System.out.println(key + ": " + map.get(key));

        map.headMap("key"); // verilen key'den küçük olanlar sergilenir
        map.tailMap("key"); // key'e eşit veya büyük olanlar sergilenir
    }

    public static void main(String[] args) {
        hashMap1();
        System.out.println(System.lineSeparator());
        hashMap2();
        System.out.println(System.lineSeparator());
        hashMap3();
        System.out.println(System.lineSeparator());
        treeMap();
    }
}

// * - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class City{
    private String name;
    private int population;

    public City() {
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}