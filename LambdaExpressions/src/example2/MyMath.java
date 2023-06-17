package example2;

@FunctionalInterface
public interface MyMath {
    // * lambda expression kullanarak sadece operation() metodu ile toplama, çıkarma vs. birçok işlem yapılabilir
    void operation(double x, double y);
}
