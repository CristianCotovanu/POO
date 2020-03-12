package com.tema1.goods;

public abstract class LegalGood extends Good {
    protected final int kingBonus;
    protected final int queenBonus;

    public LegalGood(final int id, final int profit,
                     final int penalty, final int kingBonus, final int queenBonus) {
        super(id, GoodsType.Legal, profit, penalty);
        this.kingBonus = kingBonus;
        this.queenBonus = queenBonus;
    }

    public final int getKingBonus() {
        return kingBonus;
    }

    public final int getQueenBonus() {
        return queenBonus;
    }
}
