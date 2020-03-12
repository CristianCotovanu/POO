package grandmagician;

import characters.angels.Angel;
import characters.heroes.Hero;
import fileio.WriteFile;

public final class GrandMagician implements IObserver {
    private WriteFile writeFile;
    private static GrandMagician instance = null;

    private GrandMagician() {
        this.writeFile = WriteFile.getInstance();
    }

    public static GrandMagician getInstance() {
        if (instance == null) {
            instance = new GrandMagician();
        }
        return instance;
    }

    @Override
    public void update(final ObserverInformation observerInformation) {
        Angel angel = observerInformation.getAngel();
        Hero heroInAction = observerInformation.getHeroInAction();
        Hero victim = observerInformation.getVictim();
        NotificationType notificationType = observerInformation.getNotificationType();

        switch (notificationType) {
            case AngelSpawn:
                writeFile.writeAngelSpawning(angel);
                break;
            case AngelHit:
                writeFile.writeAngelHit(angel, heroInAction);
                break;
            case AngelHelp:
                writeFile.writeAngelHelp(angel, heroInAction);
                break;
            case AngelKill:
                writeFile.writeAngelKill(heroInAction);
                break;
            case AngelRevive:
                writeFile.writeAngelRevive(heroInAction);
                break;
            case PlayerKill:
                writeFile.writeHeroKill(heroInAction, victim);
                break;
            case LevelUp:
                writeFile.writeLevelUp(heroInAction);
                break;
            default:
                break;
        }
    }
}
