package com.tema1.storage;

import com.tema1.common.goods_constants.Id;
import com.tema1.goods.Good;
import com.tema1.goods.factory.GoodsFactory;
import com.tema1.players.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Stand {
    private Player player;
    protected Map<Good, Integer> table;

    public Stand(final Player player) {
        this.player = player;
        initializeStand();
    }

    /*
     *  Fill a table with all goods and their quantities.
     */
    private void initializeStand() {
        GoodsFactory factory = GoodsFactory.getInstance();
        table = new HashMap<>();

        int[] ids = {Id.APPLE, Id.CHEESE, Id.BREAD, Id.CHICKEN, Id.TOMATO,
                Id.CORN, Id.POTATO, Id.WINE, Id.SALT, Id.SUGAR, Id.SILK,
                Id.PEPPER, Id.BARREL, Id.BEER, Id.SEAFOOD};

        for (int id : ids) {
            Good newGood = factory.getGoodById(id);
            table.put(newGood, 0);
        }
    }

    public Map<Good, Integer> getTable() {
        return table;
    }

    public void setTable(final Map<Good, Integer> table) {
        this.table = table;
    }

    /*
     * Puts all the goods in a player bag on the stand's table
     */
    public void fillStand() {
        List<Good> goodsList = player.getBag().getGoodsList();

        if (goodsList.isEmpty()) {
            return;
        }

        for (Good good : goodsList) {
            table.put(good, table.get(good) + 1);
        }
    }
}
