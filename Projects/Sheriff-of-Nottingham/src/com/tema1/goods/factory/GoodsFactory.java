package com.tema1.goods.factory;

import com.tema1.common.goods_constants.Id;
import com.tema1.common.goods_constants.NumBonusCards;
import com.tema1.goods.Good;

import java.util.HashMap;
import java.util.Map;

public final class GoodsFactory {
    private static GoodsFactory instance = null;

    private final Map<Integer, Good> goodById;

    private GoodsFactory() {
        goodById = new HashMap<>();

        initLegalGood();
        initIllegalGood();
    }

    private void initLegalGood() {
        Good apple = new Apple();
        Good cheese = new Cheese();
        Good bread = new Bread();
        Good chicken = new Chicken();
        Good tomato = new Tomato();
        Good corn = new Corn();
        Good potato = new Potato();
        Good wine = new Wine();
        Good salt = new Salt();
        Good sugar = new Sugar();

        goodById.put(Id.APPLE, apple);
        goodById.put(Id.CHEESE, cheese);
        goodById.put(Id.BREAD, bread);
        goodById.put(Id.CHICKEN, chicken);
        goodById.put(Id.TOMATO, tomato);
        goodById.put(Id.CORN, corn);
        goodById.put(Id.POTATO, potato);
        goodById.put(Id.WINE, wine);
        goodById.put(Id.SALT, salt);
        goodById.put(Id.SUGAR, sugar);
    }

    private void initIllegalGood() {
        Map<Good, Integer> bonusSilk = new HashMap<Good, Integer>();
        Map<Good, Integer> bonusPepper = new HashMap<Good, Integer>();
        Map<Good, Integer> bonusBarrel = new HashMap<Good, Integer>();
        Map<Good, Integer> bonusBeer = new HashMap<Good, Integer>();
        Map<Good, Integer> bonusSeafood = new HashMap<Good, Integer>();

        bonusSilk.put(goodById.get(Id.CHEESE), NumBonusCards.SILK);
        bonusPepper.put(goodById.get(Id.CHICKEN), NumBonusCards.PEPPER);
        bonusBarrel.put(goodById.get(Id.BREAD), NumBonusCards.BARREL);
        bonusBeer.put(goodById.get(Id.WINE), NumBonusCards.BEER);
        bonusSeafood.put(goodById.get(Id.CHICKEN), NumBonusCards.SEAFOOD_C);
        bonusSeafood.put(goodById.get(Id.TOMATO), NumBonusCards.SEAFOOD_T);
        bonusSeafood.put(goodById.get(Id.POTATO), NumBonusCards.SEAFOOD_P);

        Good silk = new Silk(bonusSilk);
        Good pepper = new Pepper(bonusPepper);
        Good barrel = new Barrel(bonusBarrel);
        Good beer = new Beer(bonusBeer);
        Good seafood = new Seafood(bonusSeafood);

        goodById.put(Id.SILK, silk);
        goodById.put(Id.PEPPER, pepper);
        goodById.put(Id.BARREL, barrel);
        goodById.put(Id.BEER, beer);
        goodById.put(Id.SEAFOOD, seafood);
    }

    public static GoodsFactory getInstance() {
        if (instance == null) {
            instance = new GoodsFactory();
        }

        return instance;
    }

    public Good getGoodById(final int id) {
        return goodById.get(id);
    }
}
