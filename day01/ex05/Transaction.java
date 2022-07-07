package ex05;

import java.util.UUID;

public class Transaction {
    private enum TransferCategory {
        DEBIT,
        CREDIT
    }

    private enum Status {
        FAIL,
        SUCCESS
    }

    private final UUID identifier;
    private final User recipient;
    private final User sender;
    private final TransferCategory category;
    private final Integer transferAmount;

    public Transaction(User recipient, User sender, Integer transferAmount, UUID identifier, Integer flag) {
        this.recipient = recipient;
        this.sender = sender;
        this.identifier = identifier;

        if (transferAmount < 0) {
            category = TransferCategory.CREDIT;
        } else {
            category = TransferCategory.DEBIT;
        }
        this.transferAmount = transferAmount;
        if (sender.getBalance() < transferAmount && category == TransferCategory.DEBIT ||
                recipient.getBalance() < -transferAmount && category == TransferCategory.CREDIT) {
            throw new IllegalTransactionException("Not enough money, bro!");
        } else if (flag == 1) {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
    }

    public Transaction(User recipient, User sender, Integer transferAmount) {
        this.recipient = recipient;
        this.sender = sender;
        this.identifier = UUID.randomUUID();

        if (transferAmount < 0) {
            category = TransferCategory.CREDIT;
        } else {
            category = TransferCategory.DEBIT;
        }
        this.transferAmount = transferAmount;
        if (sender.getBalance() < transferAmount && category == TransferCategory.DEBIT ||
            recipient.getBalance() < -transferAmount && category == TransferCategory.CREDIT) {
            throw new IllegalTransactionException("Not enough money, bro!");
        } else {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public TransferCategory getCategory() {
        return category;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

}
