package ex00;

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

    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory category;
    private Status status;
    private Integer transferAmount;

    Transaction(User recipient, User sender, Integer transferAmount) {
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
            status = Status.FAIL;
        } else {
            sender.balance = sender.balance - transferAmount;
            recipient.balance = recipient.balance + transferAmount;
            status = Status.SUCCESS;
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

    public Status getStatus() {
        return status;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

}
