package com.tema1.goods.comparators;

import com.tema1.goods.Good;

import java.util.Comparator;

public final class GoodProfitComparator implements Comparator<Good> {
    public GoodProfitComparator() { }

    @Override
    public int compare(final Good g1, final Good g2) {
        return g2.getProfit() - g1.getProfit();
    }
}
