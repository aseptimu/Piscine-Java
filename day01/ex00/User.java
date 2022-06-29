package ex00;

public class User {
    Integer identifier;
    String name;
    Integer balance = 0;

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
        this.balance = balance;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }
}
