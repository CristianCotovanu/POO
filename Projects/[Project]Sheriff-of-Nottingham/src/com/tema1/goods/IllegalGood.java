package com.tema1.goods;

import java.util.Map;

public abstract class IllegalGood extends Good {
    private final Map<Good, Integer> illegalBonus;

    public IllegalGood(final int id, final int profit,
                       final int penalty, final Map<Good, Integer> illegalBonus) {
        super(id, GoodsType.Illegal, profit, penalty);
        this.illegalBonus = illegalBonus;
    }

    public final Map<Good, Integer> getIllegalBonus() {
        return illegalBonus;
    }
}
