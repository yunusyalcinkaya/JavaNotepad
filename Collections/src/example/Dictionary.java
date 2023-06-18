package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<>();

        String path = "Collections/src/example/dictionary.txt";
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line =null;
            while((line = bufferedReader.readLine()) != null){
                String[] splited = line.split(":");
                map.put(splited[0],splited[1]);
            }

            Scanner scanner = new Scanner(System.in);
            String input = null;
            do {
                System.out.print("Enter word(enter 0 for exit): ");
                input = scanner.nextLine();

                if(input != null && map.containsKey(input)){
                    System.out.println(map.get(input));
                } else if ("0".equals(input)) {
                    System.out.println("exited");
                } else System.out.println("word not found");
            } while (!"0".equals(input));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
