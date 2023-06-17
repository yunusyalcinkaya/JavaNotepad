package example;

@FunctionalInterface
public interface PersonFilter {
    boolean filter(Person person);
}
