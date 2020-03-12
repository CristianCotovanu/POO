package com.tema1.goods.factory;

import com.tema1.goods.LegalGood;
import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.Penalty;
import com.tema1.common.goods_constants.Profit;
import com.tema1.common.goods_constants.KingBonus;
import com.tema1.common.goods_constants.QueenBonus;

public final class Tomato extends LegalGood {
    public Tomato() {
        super(Id.TOMATO, Profit.TOMATO, Penalty.TOMATO, KingBonus.TOMATO, QueenBonus.TOMATO);
    }
}