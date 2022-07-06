package ex04;

public class Program {
	public static void main(String[] args) {
		TransactionsService service = new TransactionsService();
		User user1 = new User("Vanya", 1000);
		User user2 = new User("Olya", 200);

		service.addUser(user1);
		service.addUser(user2);

		System.out.println("Vanya balance: " + service.retrieveUserBalance(user1.getIdentifier()));
		System.out.println("Olya balance: " + service.retrieveUserBalance(user2.getIdentifier()));

		service.performTransfer(user1.getIdentifier(), user2.getIdentifier(), 20);
		service.performTransfer(user2.getIdentifier(), user1.getIdentifier(), 100);
		service.performTransfer(user1.getIdentifier(), user2.getIdentifier(), -10);
		Transaction[] olyaTrans = service.retrieveUserTransfers(user2);
		Transaction[] vanyaTrans = service.retrieveUserTransfers(user1);
		for (Integer i = 0; i < olyaTrans.length; i++) {
			System.out.println("Transaction info: " + olyaTrans[i].getRecipient().getName() + " to " +
					olyaTrans[i].getSender().getName() + ". Amount: " + olyaTrans[i].getTransferAmount() +
					" " + olyaTrans[i].getCategory());
		}
		System.out.println();
		for (Integer i = 0; i < olyaTrans.length; i++) {
			System.out.println("Transaction info: " + vanyaTrans[i].getRecipient().getName() + " to " +
					vanyaTrans[i].getSender().getName() + ". Amount: " + vanyaTrans[i].getTransferAmount() +
					" " + vanyaTrans[i].getCategory());
		}
		service.removeUserTransaction(user1.getIdentifier(), vanyaTrans[0].getIdentifier());
		System.out.println();
		for (Integer i = 0; i < olyaTrans.length; i++) {
			System.out.println("Transaction info: " + vanyaTrans[i].getRecipient().getName() + " to " +
					vanyaTrans[i].getSender().getName() + ". Amount: " + vanyaTrans[i].getTransferAmount() +
					" " + vanyaTrans[i].getCategory());
		}
	}
}
