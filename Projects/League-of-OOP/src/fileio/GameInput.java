package fileio;

import java.util.List;

public final class GameInput {
    private int mapCols;
    private int mapRows;
    private List<String> playerRaceAndPosition;
    private List<String> landTypesPerRow;
    private List<String> movesForRound;
    private List<String> angelsForRound;

    GameInput(final int mapCols, final int mapRows, final List<String> landTypesPerRow,
              final List<String> playerRaceAndPosition,
              final List<String> movesForRound,
              final List<String> angelsForRound) {
        this.mapCols = mapCols;
        this.mapRows = mapRows;
        this.landTypesPerRow = landTypesPerRow;
        this.playerRaceAndPosition = playerRaceAndPosition;
        this.movesForRound = movesForRound;
        this.angelsForRound = angelsForRound;
    }

    public int getMapCols() {
        return mapCols;
    }

    public int getMapRows() {
        return mapRows;
    }

    public List<String> getPlayerRaceAndPosition() {
        return playerRaceAndPosition;
    }

    public List<String> getLandTypesPerRow() {
        return landTypesPerRow;
    }

    public List<String> getMovesForRound() {
        return movesForRound;
    }

    public List<String> getAngelsForRound() {
        return angelsForRound;
    }
}
