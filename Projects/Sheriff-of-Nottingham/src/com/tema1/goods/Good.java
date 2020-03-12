package com.tema1.goods;

public abstract class Good {
    protected final int id;
    protected final GoodsType type;
    protected final int profit;
    protected final int penalty;

    public Good(final int id, final GoodsType type,
                final int profit, final int penalty) {
        this.id = id;
        this.type = type;
        this.profit = profit;
        this.penalty = penalty;
    }
    public final boolean isLegal() {
        return getType().equals(GoodsType.Legal);
    }

    public final int getId() {
        return id;
    }

    public final GoodsType getType() {
        return type;
    }

    public final int getProfit() {
        return profit;
    }

    public final int getPenalty() {
        return penalty;
    }
}
