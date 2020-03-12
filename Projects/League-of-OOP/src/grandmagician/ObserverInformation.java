package grandmagician;

import characters.angels.Angel;
import characters.heroes.Hero;

public final class ObserverInformation {
    private NotificationType notificationType;
    private Angel angel;
    private Hero heroInAction;
    private Hero victim;

    public ObserverInformation(final NotificationType notificationType, final Angel angel,
                               final Hero heroInAction, final Hero victim) {
        this.notificationType = notificationType;
        this.angel = angel;
        this.heroInAction = heroInAction;
        this.victim = victim;
    }

    public Angel getAngel() {
        return angel;
    }

    Hero getVictim() {
        return victim;
    }

    Hero getHeroInAction() {
        return heroInAction;
    }

    NotificationType getNotificationType() {
        return notificationType;
    }
}
