package skills.knight;

public final class KnightConstants {
    public static final int EXECUTE_INITIAL_DMG = 200;
    public static final int EXECUTE_DMG_LVL_UP = 30;
    public static final float EXECUTE_INITIAL_HP_LIMIT = 0.2f;
    public static final float EXECUTE_HP_LIMIT_LVL_UP = 0.01f;
    public static final float EXECUTE_MAX_LIMIT_PERCENTAGE = 0.4f;

    public static final float EXECUTE_VS_ROGUE = 0.15f;
    public static final float EXECUTE_VS_PYROMANCER = 0.1f;
    public static final float EXECUTE_VS_WIZARD = -0.2f;

    public static final int SLAM_INITIAL_DMG = 100;
    public static final int SLAM_DMG_LVL_UP = 40;
    public static final int SLAM_STUN_DURATION = 1;

    public static final float SLAM_VS_ROGUE = -0.2f;
    public static final float SLAM_VS_KNIGHT = 0.2f;
    public static final float SLAM_VS_PYROMANCER = -0.1f;
    public static final float SLAM_VS_WIZARD = 0.05f;

    public static final float KNIGHT_LAND_BONUS = 0.15f;

    private KnightConstants() { }
}
