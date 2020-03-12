package skills.effects;

public final class Stun {
    private int rounds;

    public Stun() { }

    public Stun(final int rounds) {
        this.rounds = rounds;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }
}
