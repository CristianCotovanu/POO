package com.tema1.goods.factory;

import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.Penalty;
import com.tema1.common.goods_constants.Profit;
import com.tema1.goods.Good;
import com.tema1.goods.IllegalGood;

import java.util.Map;

public final class Beer extends IllegalGood {
    public Beer(final Map<Good, Integer> bonusMap) {
        super(Id.BEER, Profit.BEER, Penalty.BEER, bonusMap);
    }
}
