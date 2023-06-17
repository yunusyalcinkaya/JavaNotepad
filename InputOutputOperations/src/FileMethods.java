import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileMethods {
    public static void main(String[] args) {
        String path = "InputOutputOperations/src/files/";
        File file = new File(path + "test.txt");

        if (file.exists()){
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
            System.out.println(file.canExecute());
            System.out.println(file.isHidden());
            System.out.println(new Date(file.lastModified()));
            System.out.println(file.length());
            //System.out.println(file.delete());
        }

        // * Assign a directory to File
        File file2 = new File("/home/yunus/Desktop/");
        String[] list = file2.list();
        System.out.println(Arrays.toString(list));

    }
}
