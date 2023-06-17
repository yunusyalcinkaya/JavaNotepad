import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class RemoteFileOperations {
    public static void main(String[] args) {

        String localPath = "InputOutputOperations/src/files/test.txt";
        String remotePath = "https://www.w3.org/TR/2003/REC-PNG-20031110/iso_8859-1.txt";

        try {
            URL url = new URL(remotePath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] buffer = new char[1024];
            FileOutputStream fileOutputStream = new FileOutputStream(localPath);
            int length = 0;
            while ((length = inputStreamReader.read(buffer)) != -1){
                fileOutputStream.write(new String(Arrays.copyOfRange(buffer,0,length)).getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
