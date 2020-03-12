package com.tema1.goods.factory;

import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.Penalty;
import com.tema1.common.goods_constants.Profit;
import com.tema1.goods.Good;
import com.tema1.goods.IllegalGood;

import java.util.Map;

public final class Barrel extends IllegalGood {
    public Barrel(final Map<Good, Integer> bonusMap) {
        super(Id.BARREL, Profit.BARREL, Penalty.BARREL, bonusMap);
    }
}
