package ex03;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Vasya", 100);
        User user2 = new User("Petya", 200);

        Transaction transaction1 = new Transaction(user1, user2, -50);
        Transaction transaction2 = new Transaction(user1, user2, 100);
        Transaction transaction3 = new Transaction(user2, user1, 100);
        Transaction transaction4 = new Transaction(user2, user1, -50);
        System.out.println("Vasya balance: " + user1.getBalance() + "\nPetya balance: " + user2.getBalance());

        Transaction[] transactions = user1.getTransactions().toArray();
        for (Integer i = 0; i < transactions.length; i++) {
            System.out.println("Transaction info: " + transactions[i].getRecipient().getName() + " to " +
                    transactions[i].getSender().getName() + ". Amount: " + transactions[i].getTransferAmount() +
                    " " + transactions[i].getCategory());
        }
    }
}
