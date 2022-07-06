package ex03;

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
    private final Status status;
    private final Integer transferAmount;

    private Transaction(User recipient, User sender, Integer transferAmount, UUID identifier) {
        this.recipient = recipient;
        this.sender = sender;
        this.identifier = identifier;

        if (transferAmount < 0) {
            category = TransferCategory.CREDIT;
        } else {
            category = TransferCategory.DEBIT;
        }
        this.transferAmount = transferAmount;
        this.status = Status.SUCCESS;
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
            status = Status.FAIL;
        } else {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
            sender.setTransaction(this);
            Transaction tr = new Transaction(sender, recipient, -transferAmount, identifier);
            recipient.setTransaction(tr);
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
