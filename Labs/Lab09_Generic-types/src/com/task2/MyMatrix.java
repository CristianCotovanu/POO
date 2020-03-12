package com.task2;

import java.util.Collection;

public class MyMatrix {
    int[][] matrix = new int[4][4];

    public int sum(Collection<Sumabil> collection) {
        Sumabil sumabil = new Sumabil() {
            @Override
            public void addValue(Sumabil value) {

            }
        };

        for (Sumabil element : collection) {
            sumabil.addValue(element);
        }
    }
}
