/* sample input (id, name, gano)
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
 */

/* sample output
Ashis
Fahim
Samara
Samiha
Rumpa
 */

/*
    gano değerine göre büyükten küçüğe sırala
    gano değerleri eşitse name alanına göre alfabetik olarak sırala
    gano ve name alanları eşitse id alanına göre küçükten büyüğe sırala
 */


import java.util.*;

public class ObjectOrdering {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> list = new ArrayList<>();

        for(int i=0; i<num; i++){
            String[] array = scanner.nextLine().split(" ");
            list.add(new Person(array[0],array[1],array[2]));
        }
        Collections.sort(list);

        list.forEach(item -> System.out.println(item.getName()));

        scanner.close();
    }
}

class Person implements Comparable<Person>{

    private String id;
    private String name;
    private String gano;

    public Person() {
    }

    public Person(String id, String name, String gano) {
        this.id = id;
        this.name = name;
        this.gano = gano;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGano() {
        return gano;
    }

    public void setGano(String gano) {
        this.gano = gano;
    }

    @Override
    public int compareTo(Person o) {

        int cmp1 = o.getGano().compareTo(this.gano);
        if(cmp1 == 0){
            int cmp2 = this.name.toUpperCase().compareTo(o.getName().toUpperCase());
            if(cmp2 == 0){
                return this.id.compareTo(o.getId());
            }
            return cmp2;
        }
        return cmp1;
    }
}