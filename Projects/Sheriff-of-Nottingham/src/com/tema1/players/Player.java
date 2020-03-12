package com.tema1.players;

import com.tema1.common.GeneralConstants;
import com.tema1.goods.comparators.GoodIdComparator;
import com.tema1.goods.comparators.GoodProfitComparator;
import com.tema1.goods.Good;
import com.tema1.goods.factory.GoodsFactory;
import com.tema1.goods.GoodsType;
import com.tema1.players.utilities.Helper;
import com.tema1.storage.Bag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    protected String strategy;
    protected List<Good> hand;
    protected Bag bag;
    protected int goodsNumber;
    protected int coins;
    private int initialPosition;

    public Player() {
        hand = new ArrayList<>();
        bag = new Bag();
        coins = GeneralConstants.STARTING_SUM;
        goodsNumber = 0;
        initialPosition = 0;
    }

    public final void setCoins(final int coins) {
        this.coins = coins;
    }

    public final List<Good> getHand() {
        return hand;
    }

    public final Bag getBag() {
        return bag;
    }

    public final void setGoodsNumber(final int goodsNum) {
        this.goodsNumber = goodsNum;
    }

    public final int getCoins() {
        return coins;
    }

    public final String getStrategy() {
        return strategy;
    }

    public final int getInitialPosition() {
        return initialPosition;
    }

    public final void setInitialPosition(final int initialPosition) {
        this.initialPosition = initialPosition;
    }

    final boolean hasLegalGoods() {
        for (Good good : hand) {
            if (good.getType().equals(GoodsType.Legal)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Draw goods from 'pile' until cap is reached
     */
    public final void drawGoods(final List<Integer> goodsIdList) {
        GoodsFactory factory = GoodsFactory.getInstance();

        while (goodsNumber < GeneralConstants.HAND_SIZE_CAP) {
            int goodId = goodsIdList.remove(0);
            hand.add(factory.getGoodById(goodId));
            goodsNumber++;
        }
    }

    /*
     * Counts illegal goods in player's hand
     */
    protected int countIllegalGoods(final List<Good> goods) {
        int count = 0;
        for (Good good : goods) {
            if (!good.isLegal()) {
                ++count;
            }
        }
        return count;
    }

    /*
     * Verify if player has any illegal goods in hand
     */
    final boolean hasIllegalGoods() {
        for (Good good : hand) {
            if (good.getType().equals(GoodsType.Illegal)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Return the best legal good according to the given criteria
     */
    final Good bestLegalGood() {
        int maxFrequency = 0;
        int maxProfit = 0;

        Map<Good, Integer> goodsFrequency = new HashMap<>();

        for (Good g : hand) {
            if (!g.isLegal()) {
                continue;
            } else if (!goodsFrequency.containsKey(g)) {
                goodsFrequency.put(g, 1);
            } else {
                goodsFrequency.put(g, goodsFrequency.get(g) + 1);
            }

            if (maxFrequency < goodsFrequency.get(g)) {
                maxFrequency = goodsFrequency.get(g);
            }
        }

        ArrayList<Good> mostFrequent = new ArrayList<>();
        for (Good g : goodsFrequency.keySet()) {
            if (goodsFrequency.get(g) == maxFrequency) {
                mostFrequent.add(g);
            }
        }

        if (mostFrequent.size() == 1) {
            return mostFrequent.get(0);
        }

        ArrayList<Good> mostProfitable = new ArrayList<Good>();
        for (Good g : mostFrequent) {
            if (maxProfit < g.getProfit()) {
                maxProfit = g.getProfit();
            }
        }

        for (Good g : mostFrequent) {
            if (maxProfit == g.getProfit()) {
                mostProfitable.add(g);
            }
        }

        if (mostProfitable.size() == 1) {
            return mostProfitable.get(0);
        }

        GoodIdComparator goodIdComparator = new GoodIdComparator();
        mostProfitable.sort(goodIdComparator);

        return mostProfitable.get(0);
    }

    final int getGoodFrequency(final int goodId) {
        int count = 0;

        for (Good good : hand) {
            if (good.getId() == goodId) {
                ++count;
            }
        }
        return count;
    }

    /*
     * Return the best illegal good according to the given criteria
     */
    final Good bestIllegalGood() {
        ArrayList<Good> illegals = new ArrayList<>();

        if (hasIllegalGoods()) {
            for (Good good : hand) {
                if ((!good.isLegal())) {
                    illegals.add(good);
                }
            }
        }
        GoodProfitComparator goodProfitComparator = new GoodProfitComparator();
        illegals.sort(goodProfitComparator);

        return illegals.get(0);
    }

    /*
     * Player pays penalty if it was found guilty by the sheriff
     * else the sheriff pays the given amount
     */
    private void payPenalty(final Player player, final int penalty) {
        Helper convert = Helper.getInstance();

        if (penalty != 0) {
            player.setCoins(player.getCoins() - penalty);
            this.setCoins(this.getCoins() + penalty);
        } else {
            int goodsDeclared = player.getBag().getGoodsList().size();
            String typeDeclared = player.getBag().getDeclaration();
            Good goodDeclared = convert.getGoodByType(typeDeclared);

            player.setCoins(player.getCoins() + goodsDeclared * goodDeclared.getPenalty());
            this.setCoins(this.getCoins() - goodsDeclared * goodDeclared.getPenalty());
        }
    }

    /**
     *
     * @param player - player being inspected
     * @param goodsIdList - List of goods that all players in the game draw from
     */
    protected void inspectBag(final Player player, final List<Integer> goodsIdList) {
        ArrayList<Good> toInspect = player.getBag().getGoodsList();
        ArrayList<Good> remainingGoods = new ArrayList<>();
        String typeDeclared = player.getBag().getDeclaration();
        Helper helper = Helper.getInstance();
        int penalty = 0;

        for (Good good : toInspect) {
            String nameOfGood = helper.getTypeByGood(good);

            if (!(good.isLegal()) || !(typeDeclared.equals(nameOfGood))) {
                goodsIdList.add(good.getId());
                penalty += good.getPenalty();
            } else {
                remainingGoods.add(good);
            }
        }

        player.getBag().setGoodsList(remainingGoods);
        player.setCoins(player.getCoins() + player.getBag().getBribe());
        player.getBag().setBribe(0);
        payPenalty(player, penalty);
    }

    /**
     * Method for inheritance context.
     * @param players - Players currently playing
     * @param goodsIdList - List of goods that all players in the game draw from
     * @param sheriffPos - Position in array for the current sheriff
     */
    public void sheriffStrategy(final Player[] players, final List<Integer> goodsIdList,
                                final int sheriffPos) {
    }

    /**
     * Method for inheritance context.
     * Each type of player fills the bag in an own way
     * being done in this method.
     */
    public abstract void merchantStrategy();
}
