package ex03;

public class UserIdsGenerator {
    private static final UserIdsGenerator IDGEN = new UserIdsGenerator();

    private static int id = 0;

    private UserIdsGenerator() { }

    public static UserIdsGenerator getInstance() {
        return IDGEN;
    }

    public int generateId() {
        return ++id;
    }


}
