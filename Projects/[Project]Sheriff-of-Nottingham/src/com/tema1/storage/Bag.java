package com.tema1.storage;

import com.tema1.goods.Good;

import java.util.ArrayList;

public final class Bag {
    private int bribe;
    private String declaration;
    private ArrayList<Good> goodsList;

    public Bag() {
        this.bribe = 0;
        setGoodsList(new ArrayList<>());
    }

    public void setDeclaration(final String declaration) {
        this.declaration = declaration;
    }

    public String getDeclaration() {
        return this.declaration;
    }

    public void setBribe(final int bribe) {
        this.bribe = bribe;
    }

    public Integer getBribe() {
        return this.bribe;
    }

    public void setGoodsList(final ArrayList<Good> list) {
        this.goodsList = list;
    }

    public ArrayList<Good> getGoodsList() {
        return this.goodsList;
    }
}
