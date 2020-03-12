package main;

import fileio.GameInput;
import fileio.ReadFile;
import fileio.WriteFile;
import game.GameEngine;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        ReadFile readFile = new ReadFile(args[0], args[1]);
        WriteFile writeFile = WriteFile.getInstance(args[0], args[1]);
        GameInput gameInput = readFile.load();
        GameEngine gameEngine = new GameEngine(gameInput, writeFile);

        gameEngine.start();

        writeFile.writeLeaderboard(gameEngine.getHeroesList());
    }
}
