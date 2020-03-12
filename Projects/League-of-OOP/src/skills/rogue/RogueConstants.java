package skills.rogue;

public final class RogueConstants {
    public static final int BACKSTAB_INITIAL_DMG = 200;
    public static final int BACKSTAB_DMG_LVL_UP = 20;

    public static final float BACKSTAB_VS_ROGUE = 0.2f;
    public static final float BACKSTAB_VS_KNIGHT = -0.1f;
    public static final float BACKSTAB_VS_PYROMANCER = 0.25f;
    public static final float BACKSTAB_VS_WIZARD = 0.25f;

    public static final int PARALYSIS_INITIAL_DMG = 40;
    public static final int PARALYSIS_DMG_LVL_UP = 10;
    public static final int PARALYSIS_ROUNDS_TICK = 3;
    public static final int PARALYSIS_ROUNDS_TICK_WOODS = 6;

    public static final float PARALYSIS_VS_ROGUE = -0.1f;
    public static final float PARALYSIS_VS_KNIGHT = -0.2f;
    public static final float PARALYSIS_VS_PYROMANCER = 0.2f;
    public static final float PARALYSIS_VS_WIZARD = 0.25f;

    public static final float ROGUE_WOODS_BONUS = 0.15f;
    public static final float ROGUE_CRIT_BONUS = 1.5f;
    public static final int LUCKY_CRIT_ROUND = 3;

    private RogueConstants() { }
}
