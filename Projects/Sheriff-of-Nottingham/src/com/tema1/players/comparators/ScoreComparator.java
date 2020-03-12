package com.tema1.players.comparators;

import com.tema1.players.Player;

import java.util.Comparator;

public final class ScoreComparator implements Comparator<Player> {
    public ScoreComparator() { }

    @Override
    public int compare(final Player p1, final Player p2) {
        return p2.getCoins() - p1.getCoins();
    }
}
