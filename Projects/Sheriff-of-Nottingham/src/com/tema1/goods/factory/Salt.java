package com.tema1.goods.factory;

import com.tema1.goods.LegalGood;
import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.Penalty;
import com.tema1.common.goods_constants.Profit;
import com.tema1.common.goods_constants.KingBonus;
import com.tema1.common.goods_constants.QueenBonus;

public final class Salt extends LegalGood {
    public Salt() {
        super(Id.SALT, Profit.SALT, Penalty.SALT, KingBonus.SALT, QueenBonus.SALT);
    }
}
