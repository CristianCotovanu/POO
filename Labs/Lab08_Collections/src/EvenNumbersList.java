import java.util.Collection;
import java.util.LinkedHashSet;

public class EvenNumbersList<Integer> extends LinkedHashSet<Integer> {

    EvenNumbersList() {
        super();
    }

    public boolean add(Integer number) {
        if (((int)number % 2) == 0) {
            super.add(number);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends Integer> numbers) {
        for (Integer num : numbers) {
            if ((int)num % 2 == 0) {
                super.add(num);
            } else {
                return false;
            }
        }

        return true;
    }
}
