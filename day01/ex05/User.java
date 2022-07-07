package ex05;

public class User {

    private Integer identifier;
    private String name;
    private Integer balance;

    private TransactionsLinkedList transactions = new TransactionsLinkedList();

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);
    }
    public void setTransaction(Transaction transaction) {
        this.transactions.addTransaction(transaction);
    }

    public TransactionsLinkedList getTransactions() {
        return transactions;
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
