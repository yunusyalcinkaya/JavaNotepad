import java.io.*;

public class StreamReaderAndWriter {
    public static void main(String[] args) {
        String path = "InputOutputOperations/src/files/test.txt";
        File file = new File(path);
        if (file.exists()){
            write(file);
            read(file);
        }

    }
    public static void write(File file){
        FileOutputStream fileOutputStream = null;
        try {
            /*
            * Burada FileOutputStream kullanmamızın sebebi byte tabanlı olmasıdır.
            * OutputStreamWriter, byte dizisini alır unicode karaktere dönüştürerek dosyaya yazar.
             */
            fileOutputStream = new FileOutputStream(file);
            // * OutputStreamWriter() parametre olarak OutputStream alır
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write("Hello World");
            outputStreamWriter.write(System.lineSeparator());
            outputStreamWriter.write("üğş");
            outputStreamWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void read(File file){
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            // * InputStreamReader(), parametre olarak InputStream alır
            inputStreamReader = new InputStreamReader(fileInputStream);
            /* *
                * Burada BufferedInputStream kullanamazdık. Çünkü  InputStreamReader, dosyadan byte olarak alıp
                * unicode karaktere dönüştürür. BufferedInputStream byte tabanlı olduğu için onun yerine
                * karakter tabanlı olan BufferedReader kullandık
             * */
            bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
