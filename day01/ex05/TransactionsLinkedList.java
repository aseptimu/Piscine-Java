package ex05;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private final TransactionNode begin = new TransactionNode(null, null, null);
    private final TransactionNode end = new TransactionNode(null, null, null);
    private Integer numberOfTransactions = 0;

    public TransactionsLinkedList() {
        begin.setNext(end);
        end.setPrev(begin);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        begin.setNext(new TransactionNode(transaction, begin.getNext(), begin));
        numberOfTransactions++;
    }

    @Override
    public void removeTransactionById(UUID id) {
        TransactionNode tmp = begin.getNext();
        while (tmp != end) {
            if (tmp.getData().getIdentifier().equals(id)) {
                numberOfTransactions--;
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
                return ;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException("Transaction not found");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[numberOfTransactions];
        TransactionNode tmp = begin.getNext();

        for (Integer i = 0; i < numberOfTransactions; i++) {
            transactions[i] = tmp.getData();
            tmp = tmp.getNext();
        }
        return transactions;
    }

    public Integer getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public boolean isInTransactionList(UUID identifier) {
        TransactionNode tmp = begin.next;
        while (tmp != end) {
            if (tmp.data.getIdentifier().equals(identifier))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public Transaction getTransactionById(UUID identifier) throws TransactionNotFoundException {
        TransactionNode tmp = begin.next;
        while (tmp != end) {
            if (tmp.data.getIdentifier().equals(identifier)) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException("No transaction");
    }

    class TransactionNode {
        private Transaction data;
        private TransactionNode next;
        private TransactionNode prev;

        public TransactionNode(Transaction data, TransactionNode next, TransactionNode prev) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        public Transaction getData() {
            return data;
        }

        public void setData(Transaction data) {
            this.data = data;
        }

        public TransactionNode getNext() {
            return next;
        }

        public void setNext(TransactionNode next) {
            this.next = next;
        }

        public TransactionNode getPrev() {
            return prev;
        }

        public void setPrev(TransactionNode prev) {
            this.prev = prev;
        }
    }
}
