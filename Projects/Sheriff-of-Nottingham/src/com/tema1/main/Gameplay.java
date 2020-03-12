package com.tema1.main;

import com.tema1.common.GeneralConstants;
import com.tema1.common.players_constants.PlayerStrategies;
import com.tema1.players.comparators.ScoreComparator;
import com.tema1.goods.Good;
import com.tema1.goods.factory.GoodsFactory;
import com.tema1.goods.IllegalGood;
import com.tema1.goods.LegalGood;
import com.tema1.players.GreedyPlayer;
import com.tema1.players.Player;
import com.tema1.players.PlayerFactory;
import com.tema1.storage.Stand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Gameplay {
    private Player[] players;
    private List<Integer> goodsIdList;
    private Integer playersCount;
    private Stand[] playerStands;
    private int roundsNr;

    Gameplay(final GameInput gameInput) {
        List<String> playerTypes = gameInput.getPlayerNames();

        goodsIdList = gameInput.getAssetIds();
        playersCount = playerTypes.size();
        playerStands = new Stand[playersCount];
        players = new Player[playersCount];
        roundsNr = gameInput.getRounds();
        instantiatePlayers(playerTypes);
    }

    private void instantiatePlayers(final List<String> pTypes) {
        PlayerFactory factory = PlayerFactory.getInstance();
        int i = 0;

        for (String type : pTypes) {
            Player player = factory.create(type);
            if (player != null) {
                players[i] = player;
                player.setInitialPosition(i);
                playerStands[i] = new Stand(player);
            }
            ++i;
        }
    }

    /*
     * Game flow function
     */
    void play() {
        for (int round = 0; round < roundsNr; round++) {
            playRound();
        }

        computeScore();
        computeScoreboard();
    }

    private void playRound() {
        setGreedyRoundParity();
        playSubround();
    }

    private void playSubround() {
        for (int subRound = 0; subRound < playersCount; subRound++) {
            Player sheriff = players[subRound];
            int sheriffPos = subRound % playersCount;

            drawGoodsForEachPlayer(sheriff);
            merchantsPlay(sheriff);
            sheriffPlays(sheriff, sheriffPos);
            fillStandForEachPlayer(playerStands[sheriffPos]);
            emptyPlayerHands();
        }
    }

    private void sheriffPlays(final Player sheriff, final int sheriffPos) {
        sheriff.sheriffStrategy(players, goodsIdList, sheriffPos);
    }

    /*
     * Players throw remaining goods from hand
     */
    private void emptyPlayerHands() {
        for (Player p : players) {
            if (!p.getHand().isEmpty()) {
                p.getHand().clear();
                p.setGoodsNumber(0);
            }
        }
    }

    private void fillStandForEachPlayer(final Stand playerStand) {
        for (Stand stand : playerStands) {
            if (!stand.equals(playerStand)) {
                stand.fillStand();
            }
        }
    }

    /*
     * Merchants play their strategies
     */
    private void merchantsPlay(final Player sheriff) {
        for (Player player : players) {
            if (!player.equals(sheriff)) {
                player.merchantStrategy();
            }
        }
    }

    private void drawGoodsForEachPlayer(final Player sheriff) {
        for (Player player : players) {
            if (!player.equals(sheriff)) {
                player.drawGoods(goodsIdList);
            }
        }
    }

    /*
     * Set roundParity if the player is greedy
     */
    private void setGreedyRoundParity() {
        for (Player p : players) {
            if (p.getStrategy().equals(PlayerStrategies.GREEDY)) {
                ((GreedyPlayer) p).setRound(!(((GreedyPlayer) p).getRound()));
            }
        }
    }

    /*
     * Applies bonuses and computes the total score for each player
     */
    private void computeScore() {
        applyIllegalBonuses();
        applyKingQueenBonus();
        sellGoods();
    }

    private void applyIllegalBonuses() {
        for (Stand playerStand : playerStands) {
            Map<Good, Integer> playerTable = playerStand.getTable();
            for (Good good : playerTable.keySet()) {
                if (!good.isLegal() && (playerTable.get(good) != 0)) {
                    int nrBonus = playerTable.get(good);
                    Map<Good, Integer> illegalMap = ((IllegalGood) good).getIllegalBonus();
                    for (Good g : illegalMap.keySet()) {
                        playerTable.put(g, playerTable.get(g) + (nrBonus * illegalMap.get(g)));
                    }
                }
            }
            playerStand.setTable(playerTable);
        }
    }

    /*
     * Sells all goods from each player stand
     */
    private void sellGoods() {
        ArrayList<Good> goodsInGame = getGoodsInGame(playerStands);

        for (int j = 0; j < playerStands.length; j++) {
            Map<Good, Integer> currTable = playerStands[j].getTable();
            Player currPlayer = players[j];

            for (Good good : goodsInGame) {
                currPlayer.setCoins(currPlayer.getCoins() + currTable.get(good) * good.getProfit());
            }
        }
    }

    /*
     * Computes and applies king/queen bonuses
     */
    private void applyKingQueenBonus() {
        GoodsFactory factory = GoodsFactory.getInstance();
        ArrayList<Good> goodsInGame = getGoodsInGame(playerStands);
        int[] playerIdsFreq = new int[playersCount];
        int maxId = GeneralConstants.MAX_LEGAL_ID;

        for (int i = 0; i <= maxId; i++) {
            Good currGood = factory.getGoodById(i);

            if (!goodsInGame.contains(currGood)) {
                continue;
            }

            for (int k = 0; k < playersCount; k++) {
                Map<Good, Integer> currTable = playerStands[k].getTable();
                playerIdsFreq[k] = currTable.get(currGood);
            }

                int kingId = -1;
                int queenId = -1;
                int kingFreq = 0;
                int queenFreq = 0;

                for (int j = 0; j < playersCount; j++) {
                    if (playerIdsFreq[j] > kingFreq) {
                        kingId = j;
                        kingFreq = playerIdsFreq[kingId];
                    }
                }

                playerIdsFreq[kingId] = 0;

                for (int j = 0; j < playersCount; j++) {
                    if (playerIdsFreq[j] > queenFreq) {
                        queenId = j;
                        queenFreq = playerIdsFreq[queenId];
                    }
                }

                if (queenId != kingId && queenId != -1) {
                    Player king = players[kingId];
                    Player queen = players[queenId];

                    king.setCoins(king.getCoins() + ((LegalGood) currGood).getKingBonus());
                    queen.setCoins(queen.getCoins() + ((LegalGood) currGood).getQueenBonus());
                } else {
                    Player king = players[kingId];
                    king.setCoins(king.getCoins() + ((LegalGood) currGood).getKingBonus());
                }
            }
    }

    /*
     * Returns an array with all the goods being played in the game
     */
    private ArrayList<Good> getGoodsInGame(final Stand[] stands) {
        ArrayList<Good> goodsInGame = new ArrayList<>();

        for (Stand stand : stands) {
            Map<Good, Integer> table = stand.getTable();
            for (Good good : table.keySet()) {
                if (table.get(good) != 0 && !goodsInGame.contains(good)) {
                    goodsInGame.add(good);
                }
            }
        }
        return goodsInGame;
    }

    /*
     * Sorts the players based on their final score and prints the final scoreboard
     */
    private void computeScoreboard() {
        sortPlayersByScore();
        printScoreboard();
    }

    private void printScoreboard() {
        for (Player p : players) {
            System.out.println(p.getInitialPosition() + " "
                    + p.getStrategy().toUpperCase() + " " + p.getCoins());
        }
    }

    private void sortPlayersByScore() {
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(players, scoreComparator);
    }
}
