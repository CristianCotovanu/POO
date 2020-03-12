package com.tema1.players;

import com.tema1.common.players_constants.PlayerStrategies;
import com.tema1.goods.Good;

import java.util.List;

public class GreedyPlayer extends BasicPlayer {
    private boolean roundParity;

    GreedyPlayer() {
        super();
        roundParity = true;
        strategy = PlayerStrategies.GREEDY;
    }

    public final void setRound(final boolean parity) {
        this.roundParity = parity;
    }

    public final boolean getRound() {
        return roundParity;
    }

    public final void merchantStrategy() {
        super.merchantStrategy();

        if (roundParity && (countIllegalGoods(hand) != 0)) {
            Good illegalToAdd = bestIllegalGood();

            hand.remove(illegalToAdd);
            bag.getGoodsList().add(illegalToAdd);
            goodsNumber--;
        }

    }

    @Override
    protected final void inspectBag(final Player player, final List<Integer> goodsIdList) {
        int bribe = player.getBag().getBribe();

        if (bribe != 0) {
            this.setCoins(this.getCoins() + bribe);
            player.getBag().setBribe(0);
        } else {
            super.inspectBag(player, goodsIdList);
        }
    }
}
