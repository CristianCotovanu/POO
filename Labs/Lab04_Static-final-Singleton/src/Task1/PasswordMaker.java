package Task1;

public class PasswordMaker {
    private static PasswordMaker instance = null;

    public static final String alphabet = "abcdefghijklmnopqrstuwxyz1234567890";
    public static final int MAGIC_NUMBER = 21;

    public static final String MAGIC_STRING = new RandomStringGenerator(MAGIC_NUMBER, alphabet).next();

    private String name;
    public static int counterInstace = 0;

//    Eager init
//    private static PasswordMaker instance = new PasswordMaker(generator.next());

//    Static init
//    static {
//        instance = new PasswordMaker(generator.next());
//    }

    public PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance(String name) {
        counterInstace++;

        if (instance != null) {
            return instance;
        }
        instance = new PasswordMaker(name);
        return instance;
    }

    public String getPassword() {
        RandomStringGenerator newGenerator = new RandomStringGenerator(10, MAGIC_STRING);

        return newGenerator.next() + (name.length() + (int) (Math.random() * 100));
    }

}
