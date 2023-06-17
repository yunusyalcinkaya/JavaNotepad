Akışlar(Streams) üzerinde işlem yapıldıkları veri tipine göre ikiye ayrılır:
    Byte Stream ve Character Stream

Karakter tabanlı I/O işlemleri için Reader/Writer sınıfları kullanılır.
Genellikle metin tabanlı I/O işlemleri için kullanılır.
- FileReader, FileWriter (en çok kullanılanlar)
- BufferedReader, BufferedWriter
- PrintWriter

Byte akışlarında ise ham veri denilen kaynaklara erişim yapılır.
Resim, müzik ve video gibi raw data içeren kaynaklara byte akışları ile erişmek daha performanslıdır.
- FileInputStream, FileOutputStream
- BufferedInputStream, BufferedOutputStream
- PrintStream

InputStreamReader, dosyadan byte olarak okur ve karaktere dönüştürür. BufferedReader ile daha verimli kullanılabilir.
OutputStreamWriter, karakterleri dosyaya byte olarak yazar.
Bunlar sayedinde unicode karakterler(örneğin: ü,ö,ş) üzerinde sorunsuz şekilde çalışılabilir.
Örnek: StreamReaderAndWriter.java