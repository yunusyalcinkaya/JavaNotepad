import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadImage {
    public static void main(String[] args) {
        String path = "InputOutputOperations/src/files/microservice.png";
        File file = new File(path);
        if (file.exists()) {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                // ? The read() method of the FileInputStream class returns -1 when it reaches the end of the file.
                while (inputStream.read(buffer) != -1) {
                    System.out.println(Arrays.toString(buffer));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
