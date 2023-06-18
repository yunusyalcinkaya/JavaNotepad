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


Serileştirme(Serialization), nesnenin durumunu byte akışına yazma sürecidir.
Bu sayede dosyalara nesneler yazılabilri veya okunabilir.
Bir nesne serileştirilecek ise:
- Sınıf public olarak declare edilmelidir.
- Sınıf Serializable arayüzünü implemente etmelidir.
- Sınıfın argüman almayan constructor metodu olmalıdır
- Sınıfın tüm alanları serileştirilebilmelidir. Örneğin içinde bir nesne varsa o nesne de Serializable arayüzünü
    implemente eden sınıfdan türetilmiş olmalıdır.
WriteAndReadTheObject örneği için Person1 sınıfı kullanılmıştır ve Person1 sınıfı içinde Sizes sınıfının bir instance'ı vardır.
Person1 nesnesi dosyaya yazıldığında veya dosyadan okunduğunda otomatik olarak içerdiği instance da yazılır ve okunur.