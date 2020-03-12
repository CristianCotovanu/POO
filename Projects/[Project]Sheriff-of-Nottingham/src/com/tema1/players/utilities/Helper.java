package com.tema1.players.utilities;

import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.TypeIdentifier;
import com.tema1.goods.Good;
import com.tema1.goods.factory.GoodsFactory;

import java.util.HashMap;

public final class Helper {
    private static Helper instance = null;
    private HashMap<Good, String> goodToType;
    private HashMap<String, Good> typeToGood;

    private Helper() {
        goodToType = new HashMap<>();
        typeToGood = new HashMap<>();
        initializeMap();
    }

    /*
     * Maps a good to it's typeIdentifier
     * and the typeIdentifier to the good itself
     */
    private void initializeMap() {
        GoodsFactory factory = GoodsFactory.getInstance();

        int[] ids = {Id.APPLE, Id.CHEESE, Id.BREAD, Id.CHICKEN, Id.TOMATO,
                Id.CORN, Id.POTATO, Id.WINE, Id.SALT, Id.SUGAR, Id.SILK,
                Id.PEPPER, Id.BARREL, Id.BEER, Id.SEAFOOD};

        String[] goodsNames = {TypeIdentifier.APPLE, TypeIdentifier.CHEESE,
                TypeIdentifier.BREAD, TypeIdentifier.CHICKEN,
                TypeIdentifier.TOMATO, TypeIdentifier.CORN,
                TypeIdentifier.POTATO, TypeIdentifier.WINE,
                TypeIdentifier.SALT, TypeIdentifier.SUGAR,
                TypeIdentifier.SILK, TypeIdentifier.PEPPER,
                TypeIdentifier.BARREL, TypeIdentifier.BEER,
                TypeIdentifier.SEAFOOD};

        for (int i = 0; i < goodsNames.length; i++) {
            Good newGood = factory.getGoodById(ids[i]);
            goodToType.put(newGood, goodsNames[i]);
        }

        for (int i = 0; i < goodsNames.length; i++) {
            Good newGood = factory.getGoodById(ids[i]);
            typeToGood.put(goodsNames[i], newGood);
        }
    }

    public static Helper getInstance() {
        if (instance == null) {
            instance = new Helper();
        }

        return instance;
    }

    public String getTypeByGood(final Good good) {
        return goodToType.get(good);
    }

    public Good getGoodByType(final String type) {
        return typeToGood.get(type);
    }
}
