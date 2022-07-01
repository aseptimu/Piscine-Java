package ex00;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance = 0;

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

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }
}
