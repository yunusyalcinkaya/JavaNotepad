import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SplitCoojaLog {

    public static void main(String[] args) throws IOException {

        File input = new File("/home/yunus/Desktop/codes/c-tests/learning/newFiles/cooja-log.txt");
        // ! Değişken
        File output = new File("/home/yunus/Desktop/codes/c-tests/learning/newFiles/input/id1.txt");

        FileWriter writer = new FileWriter(output,true);
        Scanner scanner = new Scanner(input);

        String line = null;
        while(scanner.hasNext()){
            String pattern = "ID:1 .+"; // ! Değişken
            String splitPattern = "( +)";
            String neighbourPattern = ".+neighbour.+";
            line = scanner.nextLine();

            if(line.matches(pattern)){

                String[] splitted = line.split(splitPattern);

                if(line.matches(neighbourPattern)){
                    writer.write(String.valueOf(splitted.length - 3) + "\n");
                    continue;
                }
                for(int i=1; i<splitted.length; i++){
                    if(splitted[i] != null){
                        writer.write(splitted[i] + " ");
                    }
                }
                writer.write("\n");
            }
        }
        scanner.close();
        writer.close();
    }
}

