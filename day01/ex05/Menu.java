package ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
	TransactionsService service = new TransactionsService();
	Scanner scanner = new Scanner(System.in);
	Launch mode;



	enum Launch {
		Standard,
		Dev
	}

	public Menu(Launch mode) {
		this.mode = mode;
		launching(mode);
	}

	private void launching(Launch mode) {
		Integer input;

		while (true) {
			Hello(mode);
			if (!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("Bad input");
				continue ;
			}
			input = scanner.nextInt();
			if (input < 1 || (input > 5 && mode == Launch.Standard) || input > 7) {
				System.out.println("Bad input");
				continue ;
			}
			if (executeCommand(input, mode) == 1) {
				return;
			}
			System.out.println("---------------------------------------------------------");

		}
	}

	private Integer executeCommand(Integer input, Launch mode) {
		switch (input) {
			case 1:
				addUser();
				break;
			case 2:
				viewBalance();
				break;
			case 3:
				performTransfer();
				break;
			case 4:
				viewUserTransactions();
				break;
			case 5:
				if (mode == Launch.Dev) {
					devRemoveTransferById();
				} else {
					return 1;
				}
				break;
			case 6:
				devCheckTransferValidity();
				break;
			case 7:
				return 1;
		}
		return 0;
	}

	private void addUser() {
		System.out.println("Enter a user name and a balance");
		try {
			String name = scanner.next();
			Integer balance = scanner.nextInt();
			User user = new User(name, balance);
			service.addUser(user);
			System.out.println("User with id = " + user.getIdentifier() + " is added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void viewBalance() {
		System.out.println("Enter a user ID");
		try {
			Integer userId = scanner.nextInt();
			System.out.println(service.usersList.retrieveUserById(userId).getName() + " - " +
					service.usersList.retrieveUserById(userId).getBalance());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void performTransfer() {
		System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");

		try {
			Integer senderId = scanner.nextInt();
			Integer recipientId = scanner.nextInt();
			Integer amount = scanner.nextInt();
			service.performTransfer(recipientId, senderId, amount);
			System.out.println("The transfer is completed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void viewUserTransactions() {
		System.out.println("Enter a user ID");
		try {
			Integer userId = scanner.nextInt();
			Transaction[] transactions = service.usersList.retrieveUserById(userId).getTransactions().toArray();
			for (Integer i = transactions.length - 1; i >= 0; i--) {
				System.out.println("To " + transactions[i].getSender().getName() +
						"(id = " + transactions[i].getSender().getIdentifier() + ")" + " - " +
						-transactions[i].getTransferAmount() + " with id = " +
						transactions[i].getIdentifier());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void devRemoveTransferById() {
		System.out.println("Enter a user ID and a transfer ID");

		try {
			Integer userId = scanner.nextInt();
			UUID transactionId = UUID.fromString(scanner.next());
			System.out.println("UUID: " + transactionId);
			Transaction tr = service.usersList.retrieveUserById(userId).getTransactions().getTransactionById(transactionId);
			service.removeUserTransaction(userId, transactionId);
			System.out.println("Transfer To " + tr.getSender().getName() +
					"(id=" + tr.getSender().getIdentifier() + ") " +
					-tr.getTransferAmount() + " removed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void devCheckTransferValidity() {
		System.out.println("Check results:");

		try {
			Transaction[] transactions = service.retrieveUnpairedTransactions();
			for (Integer i = 0; i < transactions.length; i++) {
				System.out.println(transactions[i].getRecipient().getName() +
						"(id = " + transactions[i].getRecipient().getIdentifier() +
						") has an unacknowledged transfer id = " +
						transactions[i].getIdentifier() + " from " + transactions[i].getSender().getName() +
						"(id = " + transactions[i].getSender().getIdentifier() + ") for " +
						transactions[i].getTransferAmount());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void Hello(Launch mode) {
		System.out.println("1. Add a user\n" +
				"2. View user balance\n" +
				"3. Perform a transfer\n" +
				"4. View all transactions for a specific user");
		if (mode == Launch.Dev) {
			System.out.println("5. DEV - remove a transfer by ID\n" +
					"6. DEV - check transfer validity\n" +
					"7. Finish execution");
		} else {
			System.out.println("5. Finish execution");
		}
	}
}
