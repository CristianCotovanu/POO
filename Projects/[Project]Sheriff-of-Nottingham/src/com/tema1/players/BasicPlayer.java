package com.tema1.players;

import com.tema1.common.GeneralConstants;
import com.tema1.common.players_constants.PlayerStrategies;
import com.tema1.common.goods_constants.TypeIdentifier;
import com.tema1.goods.Good;
import com.tema1.players.utilities.Helper;

import java.util.ArrayList;
import java.util.List;

class BasicPlayer extends Player {
    BasicPlayer() {
        super();
        strategy = PlayerStrategies.BASIC;
    }

    public void merchantStrategy() {
        Helper convert = Helper.getInstance();
        ArrayList<Good> goodsForBag = new ArrayList<>();
        Good goodToAdd;


        int maxFrequency;
        if (hasLegalGoods()) {
            goodToAdd = bestLegalGood();
            bag.setDeclaration(convert.getTypeByGood(goodToAdd));
            maxFrequency = getGoodFrequency(goodToAdd.getId());
        } else {
            goodToAdd = bestIllegalGood();
            bag.setDeclaration(TypeIdentifier.APPLE);
            maxFrequency = 1;

            if (getCoins() < goodToAdd.getPenalty()) {
                maxFrequency = 0;
            }
        }

        if (goodToAdd.isLegal() && maxFrequency > GeneralConstants.BAG_SIZE_CAP) {
            maxFrequency = GeneralConstants.BAG_SIZE_CAP;
        }

        for (int i = 0; i < maxFrequency; i++) {
            hand.remove(goodToAdd);
            goodsForBag.add(goodToAdd);
            goodsNumber--;
        }

        bag.setGoodsList(goodsForBag);
        bag.setBribe(0);
    }

    public void sheriffStrategy(final Player[] players, final List<Integer> goodsIdList,
                                final int sheriffPos) {
        for (int i = 0; i < players.length; i++) {
            if (this.getCoins() < GeneralConstants.SHERIFF_SAFE_AMOUNT) {
                break;
            }

            if (i != sheriffPos) {
                this.inspectBag(players[i], goodsIdList);
            }
        }
    }
}
