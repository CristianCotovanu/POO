package fileio;

import characters.angels.Angel;
import characters.heroes.Hero;

import java.io.IOException;
import java.util.List;

public final class WriteFile {
    private static WriteFile instance = null;
    private static FileSystem fileSystem;

    private WriteFile(final String inputPath, final String outputPath) {
        try {
            fileSystem = new FileSystem(inputPath, outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewline() {
        try {
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLevelUp(final Hero hero) {
        try {
            fileSystem.writeWord(hero.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(hero.getInitialPosition());
            fileSystem.writeWord(" reached level ");
            fileSystem.writeInt(hero.getLevel());
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAngelSpawning(final Angel angel) {
        try {
            fileSystem.writeWord("Angel ");
            fileSystem.writeWord(angel.getClass().getSimpleName());
            fileSystem.writeWord(" was spawned at ");
            fileSystem.writeInt(angel.getPosX());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(angel.getPosY());
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAngelHit(final Angel angel, final Hero hero) {
        try {
            fileSystem.writeWord(angel.getClass().getSimpleName());
            fileSystem.writeWord(" hit ");
            fileSystem.writeWord(hero.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(hero.getInitialPosition());
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAngelHelp(final Angel angel, final Hero hero) {
        try {
            fileSystem.writeWord(angel.getClass().getSimpleName());
            fileSystem.writeWord(" helped ");
            fileSystem.writeWord(hero.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(hero.getInitialPosition());
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAngelKill(final Hero hero) {
        try {
            fileSystem.writeWord("Player ");
            fileSystem.writeWord(hero.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(hero.getInitialPosition());
            fileSystem.writeWord(" was killed by an angel");
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAngelRevive(final Hero hero) {
        try {
            fileSystem.writeWord("Player ");
            fileSystem.writeWord(hero.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(hero.getInitialPosition());
            fileSystem.writeWord(" was brought to life by an angel");
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHeroKill(final Hero killer, final Hero victim) {
        try {
            fileSystem.writeWord("Player ");
            fileSystem.writeWord(victim.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(victim.getInitialPosition());
            fileSystem.writeWord(" was killed by ");
            fileSystem.writeWord(killer.getClass().getSimpleName());
            fileSystem.writeWord(" ");
            fileSystem.writeInt(killer.getInitialPosition());
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRound(final int roundNumber) {
        try {
            String toWrite = "~~ Round " + (roundNumber + 1) + " ~~";

            fileSystem.writeWord(toWrite);
            fileSystem.writeNewLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLeaderboard(final List<Hero> heroes) {
        try {
            fileSystem.writeWord("~~ Results ~~\n");

            for (Hero hero : heroes) {
                fileSystem.writeWord(hero.getRace());
                fileSystem.writeWord(" ");

                if (hero.isDead()) {
                    fileSystem.writeWord("dead\n");
                } else {
                    fileSystem.writeInt(hero.getLevel());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getCurrentXp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getCurrentHp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getPosX());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getPosY());
                    fileSystem.writeNewLine();
                }
            }
            fileSystem.writeNewLine();
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRoundScore(final List<Hero> heroes, final int roundNumber) {
        try {
            fileSystem.writeWord("~~~ Results at the end of the round ~~~\n");
            fileSystem.writeNewLine();
            for (Hero hero : heroes) {
                fileSystem.writeWord(hero.getRace());
                fileSystem.writeWord(" ");

                if (hero.isDead()) {
                    fileSystem.writeWord("dead\n");
                } else {
                    fileSystem.writeInt(hero.getLevel());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getCurrentXp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getCurrentHp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getPosX());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getPosY());
                    fileSystem.writeNewLine();
                }
            }
            fileSystem.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WriteFile getInstance(final String inputPath, final String outputPath) {
        if (instance == null) {
            instance = new WriteFile(inputPath, outputPath);
        }

        return instance;
    }

    public static WriteFile getInstance() {
        return instance;
    }
}
