public class Driver {
    public static void main(String[] args) {
/*        CreateNumber createNumber = new CreateNumber() {
            @Override
            public double create() {
                return 20.0;
            }
        };*/
        // * Bu kod satırı yukarudaki yorum satırına alınmış kod ile aynı işi yapmaktadır
        CreateNumber createNumber = () -> 20.0;

        CreateNumber2 createNumber2 = param -> param *2;
        CreateNumber3 createNumber3 = (x,y) -> x+y;

        System.out.println(createNumber.create());
        System.out.println(createNumber2.create(15.0));
        System.out.println(createNumber3.sum(10,3));
    }
}
