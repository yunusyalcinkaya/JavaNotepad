Java 8 bir değerin bulunup bulunmadığının tespit edilebilmesi gibi durumları halledebilmek için Optional,
OptionalDouble, OptionalInt ve OptionalLong sınıflarını getirmiştir.

### class Optional\<T>
- Optional nesnesi bir değere sahip olmak zorunda değildir.
- Optional sınıfının yapıcısı yoktur. Optional metodları vardır.

OptionalDouble, OptionalInt ve OptionalLong sınıfları da Optional sınıfı ile aynı şekilde çalışır.
Optional'dan farklı olarak double, int, long tipleri ile çalışmak için tasarlanmıştır.
Optional'da kullanılan get metodu yerine getAsInt, getAsDouble, getAsLong metodları kullanılır.
