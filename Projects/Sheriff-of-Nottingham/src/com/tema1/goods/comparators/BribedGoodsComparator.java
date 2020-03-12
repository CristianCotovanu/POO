package com.tema1.goods.comparators;

import com.tema1.goods.Good;

import java.util.Comparator;

public final class BribedGoodsComparator implements Comparator<Good> {
    public BribedGoodsComparator() { }

    @Override
    public int compare(final Good g1, final Good g2) {
        if (g2.getProfit() != g1.getProfit()) {
            return g2.getProfit() - g1.getProfit();
        } else {
            return g2.getId() - g1.getId();
        }
    }
}
