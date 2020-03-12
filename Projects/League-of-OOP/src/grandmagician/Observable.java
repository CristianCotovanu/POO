package grandmagician;

public abstract class Observable {
    private IObserver observer;

    public Observable(final IObserver grandMagician) {
        this.observer = grandMagician;
    }

    public final void notifyObserver(final ObserverInformation observerInformation) {
        observer.update(observerInformation);
    }
}
