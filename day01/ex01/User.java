package ex01;

public class User {

    Integer identifier;
    String name;
    Integer balance;

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);
    }

    public Integer getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }
}
