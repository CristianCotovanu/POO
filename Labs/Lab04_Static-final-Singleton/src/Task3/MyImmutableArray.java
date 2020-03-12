package Task3;

import java.util.ArrayList;

public final class MyImmutableArray {
    private final ArrayList<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> array) {
        immutableArray = new ArrayList<>(array);
    }

    public ArrayList<Integer> getArray() {
        return immutableArray;
    }
}
