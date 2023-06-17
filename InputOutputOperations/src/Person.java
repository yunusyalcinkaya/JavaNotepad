import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    Sizes sizes;

    public Person(){

    }
    public Person(String firstName, String lastName, int age, Sizes sizes){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sizes = sizes;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sizes=" + sizes +
                '}';
    }
}
