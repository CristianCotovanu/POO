package Candies;

import java.util.Objects;

public class CandyBox {
    String origin;
    String flavor;

    public CandyBox (String o, String f) {
        this.origin = f;
        this.flavor = o;
    }

    public CandyBox () {}

    float getVolume () {
        return 0;
    }

    @Override
    public String toString() {
        return "The " + origin + " " + flavor + " has volume " + getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CandyBox candyBox = (CandyBox) o;

        return Objects.equals(origin, candyBox.origin) &&
                Objects.equals(flavor, candyBox.flavor);
    }

    public void print() {
    }
}
