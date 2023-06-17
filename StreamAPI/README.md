###Stream API

- Stream: Veri için bir kanaldır.
- Koleksiyon veya dizi gibi bir veri kaynağında işlem yapar.
- Stream veriyi depolamaz. Filtreleme, sıralama gibi işlemleri yaparak veriyi taşır. Kaynaktaki veri değişmez.
- Lambda ifadeleri ile birlikte kullanılmak üzere tasarlanmıştır.
- Arama, filtreleme, haritalama gibi karmaşık işlemlerin kolaylıkla yapılabilmesini sağlar.
- Büyük veri kümeleri ile hızlı ve verimli çalışılmasını sağlar.
- Stream arayüzünde metodlar intermediate ve terminal olarak 2 farklı şekilde tanımlanmışlardır.
- Terminal işlemler akışı bitirir.
- Intermediate işlemler başka bir akış üretirler. Böylelikle sıralı işlemlerin yapılması için bir pipeline oluştururlar.
- Intermediate işlemlerin bazıları stateless, bazıları ise stateful'dur.
- Stateless işlemlerde, her element diğer elementlerden bağımsız bir şekilde işleme sokulur.
- Stateful işlemlerde, bir elementin işleme sokulması başka bir elemente bağlı olabilir.
- Stream arayüzü nesne referansları ile çalıştığından ilkel veri tipleri ile çalışmaz. Bunun yerine wrapper sınıflar ile çalışan DoubleStream, IntStream, LongStream arayüzler mevcuttur.
