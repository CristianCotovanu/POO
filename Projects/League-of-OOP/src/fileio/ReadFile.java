package fileio;

import java.util.ArrayList;
import java.util.List;

public final class ReadFile {
    private final String inputPath;
    private final String outputPath;

    public ReadFile(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public GameInput load() {
        List<String> playerRaceAndPosition = new ArrayList<>();
        List<String> landTypesPerRow = new ArrayList<>();
        List<String> movesForRound = new ArrayList<>();
        List<String> angelsForRound = new ArrayList<>();
        int mapCols = 0;
        int mapRows = 0;
        int playersNr;
        int roundsNr;

        try {
            FileSystem fileSystem = new FileSystem(inputPath, outputPath);

            mapRows = fileSystem.nextInt();
            mapCols = fileSystem.nextInt();

            for (int i = 0; i < mapRows; i++) {
                landTypesPerRow.add(fileSystem.nextWord());
            }

            playersNr = fileSystem.nextInt();

            for (int i = 0; i < playersNr; i++) {
                playerRaceAndPosition.add(fileSystem.nextWord() + " "
                        + fileSystem.nextWord() + " " + fileSystem.nextWord());
            }

            roundsNr = fileSystem.nextInt();

            for (int i = 0; i < roundsNr; i++) {
                movesForRound.add(fileSystem.nextWord());
            }

            for (int i = 0; i < roundsNr; i++) {
                int angelsNumber = Integer.parseInt(fileSystem.nextWord());
                StringBuilder angelsThisRound = new StringBuilder();

                if (angelsNumber == 0) {
                    angelsForRound.add("0");
                    continue;
                }

                for (int j = 0; j < angelsNumber; j++) {
                    angelsThisRound.append(fileSystem.nextWord()).append(" ");
                }
                angelsForRound.add(angelsThisRound.toString());
            }

            fileSystem.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new GameInput(mapCols, mapRows, landTypesPerRow,
                playerRaceAndPosition, movesForRound, angelsForRound);
    }
}
