package com.tema1.goods.factory;

import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.Penalty;
import com.tema1.common.goods_constants.Profit;
import com.tema1.goods.Good;
import com.tema1.goods.IllegalGood;

import java.util.Map;

public final class Pepper extends IllegalGood {
    public Pepper(final Map<Good, Integer> bonusMap) {
        super(Id.PEPPER, Profit.PEPPER, Penalty.PEPPER, bonusMap);
    }
}
