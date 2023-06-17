import java.io.*;
import java.util.Scanner;

public class FileWriterReaderAndScanner {
    public static void main(String[] args) {
        String path = "InputOutputOperations/src/files/test.txt";
        File file = new File(path);

        // * Write to file
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("Hello World");
            writer.write(System.lineSeparator()); // * its mean is "\n"
            writer.write(String.valueOf(6));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // * Read from file
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            int item;
            /*
            * Burada karakterler teker teker okunduğu için çok verimsizdir.
            * Bunun yerine bir buffer olarak kullanmak için bir char[] oluştur ve read() metoduna parametre olarak ver
            * char[] boyutunu ne kadar verirsen tek seferde o kadar karakter okur ve char array'a yazar
             */
            // * read() metodu karakterlerin ascii karşılığını döndürür
            while((item = reader.read()) != -1){
                System.out.print((char)item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println(System.lineSeparator());
        // * Read with Scanner
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
