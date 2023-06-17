import java.io.Serializable;

public class Sizes implements Serializable {
    private float height;
    private float weight;

    public Sizes() {
    }

    public Sizes(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "Sizes{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
