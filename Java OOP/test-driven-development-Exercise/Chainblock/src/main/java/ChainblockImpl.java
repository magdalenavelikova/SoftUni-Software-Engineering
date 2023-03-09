import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        this.getById(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        transactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException("There is no transaction with Id:" + id);
        }
        return transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        if (transactions.values().stream().noneMatch(t -> t.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> senders = new ArrayList<>();
        getByTransactionStatus(status).forEach(t -> senders.add(t.getFrom()));
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receivers = new ArrayList<>();
        getByTransactionStatus(status).forEach(t -> receivers.add(t.getTo()));
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        if (transactions.values().stream()
                .noneMatch(t -> t.getFrom().equals(sender))) {
            throw new IllegalArgumentException("There is no such sender!");
        }
        return transactions.values().stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        if (transactions.values().stream()
                .noneMatch(t -> t.getTo().equals(receiver))) {
            throw new IllegalArgumentException("There is no such receiver!");
        }
        return transactions.values().stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        try {
            return parseIterableToList(getByTransactionStatus(status)).stream()
                    .filter(t -> t.getAmount() <= amount).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            return new ArrayList<>();
        }
    }


    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactionList = parseIterableToList(getBySenderOrderedByAmountDescending(sender)).stream()
                .filter(t -> t.getAmount() > amount).collect(Collectors.toList());
        if (transactionList.size() == 0) {
            throw new IllegalArgumentException("There is no such transactions");
        }
        return transactionList;

    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactionList = parseIterableToList(getByReceiverOrderedByAmountThenById(receiver)).stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi).collect(Collectors.toList());
        if (transactionList.size() == 0) {
            throw new IllegalArgumentException("There is no such transactions");
        }
        return transactionList;

    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactions.values().stream()
                .filter(t -> (t.getAmount() > 51 && t.getAmount() < 100))
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }

    private List<Transaction> parseIterableToList(Iterable<Transaction> transactions) {
        List<Transaction> actual = new ArrayList<>();
        transactions.forEach(actual::add);
        return actual;
    }
}
