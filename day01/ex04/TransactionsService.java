package ex04;

import java.util.UUID;

public class TransactionsService {
	TransactionsLinkedList unpairedTransactions = new TransactionsLinkedList();
	UsersList usersList = new UsersArrayList();

	public void addUser(User user) {
		usersList.addUser(user);
	}

	public Integer retrieveUserBalance(Integer userId) {
		return usersList.retrieveUserById(userId).getBalance();
	}

	public void performTransfer(Integer recipientId, Integer senderId, Integer amount) {
		UUID identifier = UUID.randomUUID();
		Transaction recipientTransaction = new Transaction(usersList.retrieveUserById(recipientId),
				usersList.retrieveUserById(senderId), amount, identifier);
		Transaction senderTransaction = new Transaction(usersList.retrieveUserById(senderId),
				usersList.retrieveUserById(recipientId), -amount, identifier);
		usersList.retrieveUserById(recipientId).getTransactions().addTransaction(recipientTransaction);
		usersList.retrieveUserById(senderId).getTransactions().addTransaction(senderTransaction);
	}

	public Transaction [] retrieveUserTransfers(User user) {
		return user.getTransactions().toArray();
	}

	public void removeUserTransaction(Integer userId, UUID transferId) {
		usersList.retrieveUserById(userId).getTransactions().removeTransactionById(transferId);
	}

	public Transaction [] retrieveUnpairedTransactions() {
		return unpairedTransactions.toArray();
	}

}
