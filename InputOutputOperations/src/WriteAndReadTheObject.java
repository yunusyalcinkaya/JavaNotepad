import java.io.*;

public class WriteAndReadTheObject {

    public static void write(File file, Person person) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void read(File file){
        if(file.exists()){
            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;

            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                Person person = (Person)objectInputStream.readObject();
                System.out.println(person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if(objectInputStream != null){
                        objectInputStream.close();
                    }
                    if(fileInputStream != null){
                        fileInputStream.close();
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = "InputOutputOperations/src/files/test.txt";
        Sizes sizes = new Sizes(180.0f,70.0f);
        Person person = new Person("Yunus", "Yalcinkaya", 25,sizes);
        File file = new File(path);

        write(file,person);
        read(file);
    }
}
