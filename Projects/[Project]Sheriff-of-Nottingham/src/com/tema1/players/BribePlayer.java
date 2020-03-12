package com.tema1.players;

import com.tema1.common.GeneralConstants;
import com.tema1.common.players_constants.PlayerStrategies;
import com.tema1.common.goods_constants.TypeIdentifier;
import com.tema1.goods.comparators.BribedGoodsComparator;
import com.tema1.goods.Good;

import java.util.ArrayList;
import java.util.List;


class BribePlayer extends BasicPlayer {

    BribePlayer() {
        super();
        strategy = PlayerStrategies.BRIBED;
    }

    /*
     * Returns the best legal good based on bribed strategy criteria
     */
    private Good getBestLegalGood() {
        ArrayList<Good> handGoods = new ArrayList<>(hand);

        BribedGoodsComparator bribedComparator = new BribedGoodsComparator();
        handGoods.sort(bribedComparator);

        for (Good good : handGoods) {
            if (good.isLegal()) {
                return good;
            }
        }
        return null;
    }

    /*
     * Fills bag with goods, sets declaration and bribe
     */
    private void prepareBag() {
        ArrayList<Good> goodsForBag = getGoodsForBag();
        int bribe;

        if (countIllegalGoods(goodsForBag) <= 2) {
            bribe = GeneralConstants.SMALL_BRIBE;
        } else {
            bribe = GeneralConstants.BIG_BRIBE;
        }

        coins -= bribe;
        bag.setBribe(bribe);
        bag.setGoodsList(goodsForBag);
        bag.setDeclaration(TypeIdentifier.APPLE);
    }

    /*
     * Return an array of goods that will be put in bag
     */
    private ArrayList<Good> getGoodsForBag() {
        ArrayList<Good> goodsForBag = new ArrayList<>();
        Good potentialGood;
        int potentialPenalty = 0;
        boolean ableToGetIllegal = true;

        while (goodsForBag.size() < GeneralConstants.BAG_SIZE_CAP) {
            if (hasIllegalGoods() && ableToGetIllegal) {
                potentialGood = bestIllegalGood();
                potentialPenalty += potentialGood.getPenalty();
                if (coins > potentialPenalty) {
                    goodsForBag.add(potentialGood);
                    hand.remove(potentialGood);
                    goodsNumber--;
                } else {
                    potentialPenalty -= potentialGood.getPenalty();
                    ableToGetIllegal = false;
                }
            } else if (hasLegalGoods()) {
                potentialGood = getBestLegalGood();
                if (potentialGood != null) {
                    potentialPenalty += potentialGood.getPenalty();
                }
                if (coins > potentialPenalty) {
                    goodsForBag.add(potentialGood);
                    hand.remove(potentialGood);
                    goodsNumber--;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return goodsForBag;
    }

    public void merchantStrategy() {
        if (!hasIllegalGoods() || coins <= GeneralConstants.SMALL_BRIBE) {
            super.merchantStrategy();
        } else {
            prepareBag();
        }
    }

    public void sheriffStrategy(final Player[] players, final List<Integer> goodsIdList,
                                final int sheriffPos) {

        Player leftPlayer = players[(players.length + sheriffPos - 1) % players.length];
        Player rightPlayer = players[(sheriffPos + 1) % players.length];

        if (inspectNearbyPlayers(goodsIdList, leftPlayer, rightPlayer)) {
            return;
        }

        getBribesFromRemainingPlayers(players, leftPlayer, rightPlayer);
    }

    /*
     * Inspects left and right players considering the option that they could be the same player
     */
    private boolean inspectNearbyPlayers(final List<Integer> goodsIdList, final Player leftPlayer,
                                         final Player rightPlayer) {
        if (leftPlayer.equals(rightPlayer)) {
            inspectBag(leftPlayer, goodsIdList);
            return true;
        }

        if (coins >= GeneralConstants.SHERIFF_SAFE_AMOUNT) {
            inspectBag(leftPlayer, goodsIdList);
        } else {
            returnBribe(leftPlayer);
        }

        if (coins >= GeneralConstants.SHERIFF_SAFE_AMOUNT) {
            inspectBag(rightPlayer, goodsIdList);
        } else {
            returnBribe(rightPlayer);
        }
        return false;
    }

    /*
     * Returns bribe money to the bribing player
     */
    private void returnBribe(final Player player) {
        int bribe = player.getBag().getBribe();
        player.setCoins(player.getCoins() + bribe);
        player.getBag().setBribe(0);
    }

    /*
     * Accepts the bribes from every player besides the left and right ones
     */
    private void getBribesFromRemainingPlayers(final Player[] players, final Player leftPlayer,
                                               final Player rightPlayer) {
        for (Player player : players) {
            if (!player.equals(this)
                    && !player.equals(rightPlayer)
                    && !player.equals(leftPlayer)) {

                int bribe = player.getBag().getBribe();
                coins += bribe;
                player.getBag().setBribe(0);
            }
        }
    }
}
