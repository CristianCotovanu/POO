package skills.effects;

public final class DamageOverTime {
    private float damagePerRound;
    private int rounds;

    public DamageOverTime() { }

    public DamageOverTime(final float damagePerRound, final int rounds) {
        this.damagePerRound = damagePerRound;
        this.rounds = rounds;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    public float getDamagePerRound() {
        return damagePerRound;
    }

    public int getRounds() {
        return rounds;
    }
}
