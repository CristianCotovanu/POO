package com.tema1.players;

public final class PlayerFactory {
    private static PlayerFactory instance = null;

    private PlayerFactory() { }

    public Player create(final String type) {
        if ("bribed".equals(type)) {
            return new BribePlayer();
        } else if ("greedy".equals(type)) {
            return new GreedyPlayer();
        } else if ("basic".equals(type)) {
            return new BasicPlayer();
        }
        return null;
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }
}
