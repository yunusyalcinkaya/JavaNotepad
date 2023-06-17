import java.io.*;

public class FileStreams {
    public static void main(String[] args) {

        String path = "InputOutputOperations/src/files/test.txt";
        File file = new File(path);

        // * Write to file
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            // ? The write() method of FıleOutputStream class takes a byte[] as a parameter.
            outputStream.write(String.valueOf(5).getBytes());
            outputStream.write("\nHello World".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // * Read from file
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int msg=0;
            // ? The read() method of the FileInputStream class returns -1 when it reaches the end of the file.
            while ((msg = inputStream.read()) != -1) {
                System.out.print((char)msg);
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