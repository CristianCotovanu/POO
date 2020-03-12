package com.tema1.goods.comparators;

import com.tema1.goods.Good;

import java.util.Comparator;

public final class GoodIdComparator implements Comparator<Good> {
    public GoodIdComparator() { }

    @Override
    public int compare(final Good g1, final Good g2) {
        return g2.getId() - g1.getId();
    }
}
