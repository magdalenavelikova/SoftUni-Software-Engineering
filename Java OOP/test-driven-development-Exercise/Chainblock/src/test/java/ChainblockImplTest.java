
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


import static org.junit.Assert.*;

public class ChainblockImplTest {

    ChainblockImpl chainblock;
    List<Transaction> transactions = new ArrayList<>();

    @Before
    public void setup() {
        chainblock = new ChainblockImpl();
        transactions = List.of(
                new TransactionImpl(0, TransactionStatus.UNAUTHORIZED, "David", "Ignat", 50.0),
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "David", "Ignat", 51.0),
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Ignat", "David", 5.0),
                new TransactionImpl(3, TransactionStatus.ABORTED, "Sam", "ALex", 10.0),
                new TransactionImpl(4, TransactionStatus.ABORTED, "David", "Ignat", 205.0)
        );
    }

    @Test
    public void testAddShouldBeAddIfTransactionIdIsUnique() {
        transactions.forEach(chainblock::add);
        assertEquals(transactions.size(), chainblock.getCount());
        for (Transaction transaction : transactions) {
            assertEquals(transaction.getId(), chainblock.getById(transaction.getId()).getId());
        }
    }

    @Test
    public void testAddShouldBeNotAddIfTransactionIdIsNotUnique() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainTransactionShouldReturnTrueIfItIsPresent() {
        chainblock.add(transactions.get(0));
        assertTrue(chainblock.contains(transactions.get(0)));
    }

    @Test
    public void testContainTransactionShouldReturnFalseIfAbsent() {
        assertFalse(chainblock.contains(transactions.get(0).getId()));
    }

    @Test
    public void testContainIDShouldReturnTrueIfItIsPresent() {
        chainblock.add(transactions.get(0));
        assertTrue(chainblock.contains(0));
    }

    @Test
    public void testContainIDShouldReturnFalseIfAbsent() {
        assertFalse(chainblock.contains(0));
    }

    @Test
    public void testChangeTransactionStatusShouldChangeStatus() {
        chainblock.add(transactions.get(0));
        TransactionStatus expected = TransactionStatus.ABORTED;
        chainblock.changeTransactionStatus(transactions.get(0).getId(), expected);
        assertEquals(expected, chainblock.getById(transactions.get(0).getId()).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowIfIdAbsent() {
        chainblock.add(transactions.get(0));
        TransactionStatus expected = TransactionStatus.ABORTED;
        chainblock.changeTransactionStatus(100, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowException() {
        chainblock.getById(100);
    }

    @Test
    public void testGetByIdShouldReturnTransaction() {
        chainblock.add(transactions.get(0));
        chainblock.getById(0);
        assertEquals(transactions.get(0).getId(), chainblock.getById(0).getId());
    }

    @Test
    public void testRemoveTransactionShouldRemove() {
        chainblock.add(transactions.get(0));
        chainblock.removeTransactionById(0);
        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionShouldThrowIfIdAbsent() {
        chainblock.add(transactions.get(0));
        chainblock.removeTransactionById(100);
    }

    @Test
    public void testGetByTransactionStatusShouldReturn() {
        addAllTransactions(transactions);
        List<Transaction> actual = parseIterableToList(chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL));
        assertEquals(2, actual.size());
    }

    @Test
    public void testGetByTransactionStatusShouldReturnOrderedByAmountDesc() {
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed()).collect(Collectors.toList());
        addAllTransactions(transactions);
        List<Transaction> actual;
        actual = parseIterableToList(chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL));
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getAmount(), actual.get(i).getAmount(), 0.0);
        }


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowIfStatusIsAbsent() {
        chainblock.getByTransactionStatus(TransactionStatus.FAILED);

    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturn() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());

        List<String> actual = parseIterableToStringList(chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL));
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            String expectedSender = expected.get(i).getFrom();
            assertEquals(expectedSender, actual.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowIfStatusIsAbsent() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);

    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturn() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());

        List<String> actual = parseIterableToStringList(chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL));
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            String expectedReceivers = expected.get(i).getTo();
            assertEquals(expectedReceivers, actual.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowIfStatusIsAbsent() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);

    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
        }

    }

    @Test
    public void testGetBySenderOrderedByAmountDescending() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getFrom().equals("David"))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getBySenderOrderedByAmountDescending("David"));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowIfSenderIsAbsent() {
        chainblock.getBySenderOrderedByAmountDescending("Missing");

    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTo().equals("Ignat"))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getByReceiverOrderedByAmountThenById("Ignat"));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowIfReceiverIsAbsent() {
        addAllTransactions(transactions);
        chainblock.getByReceiverOrderedByAmountThenById("Missing");

    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturn() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(t -> t.getAmount() <= 51)
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 51));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollection() {
        List<Transaction> actual = parseIterableToList(chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 1));
        assertEquals(0, actual.size());
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getFrom().equals("David") && t.getAmount() > 5)
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getBySenderAndMinimumAmountDescending("David", 5));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void tesGetBySenderOrderedByAmountDescendingShouldThrowIfNoSuchTransaction() {
        addAllTransactions(transactions);
        chainblock.getBySenderAndMinimumAmountDescending("David", 210);

    }

    @Test
    public void testGetByReceiverAndAmountRange() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTo().equals("Ignat") &&
                        (t.getAmount() >= 51 && t.getAmount() < 100))
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getByReceiverAndAmountRange("Ignat", 51, 100));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }

    @Test
    public void testGetAllInAmountRange() {
        addAllTransactions(transactions);
        List<Transaction> expected = transactions.stream()
                .filter(t -> (t.getAmount() > 51 && t.getAmount() < 100))
                .collect(Collectors.toList());

        List<Transaction> actual = parseIterableToList(chainblock.getAllInAmountRange(51, 100));
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowIfNoSuchTransaction() {
        addAllTransactions(transactions);
        chainblock.getByReceiverAndAmountRange("Ignat", 210, 260);

    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyList() {
        addAllTransactions(transactions);
        List<Transaction> actual = parseIterableToList(chainblock.getAllInAmountRange(210, 250));
        assertEquals(0, actual.size());
    }

    @Test
    public void testIterator() {
        addAllTransactions(transactions);
        Iterator<Transaction> iterator = chainblock.iterator();
        List<Transaction> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        assertEquals(transactions.size(), actual.size());
        assertEquals(transactions,actual);

    }

    public void addAllTransactions(List<Transaction> transactions) {
        transactions.forEach(chainblock::add);
    }

    public List<Transaction> parseIterableToList(Iterable<Transaction> transactions) {
        List<Transaction> actual = new ArrayList<>();
        transactions.forEach(actual::add);
        return actual;
    }

    public List<String> parseIterableToStringList(Iterable<String> transactions) {
        List<String> actual = new ArrayList<>();
        transactions.forEach(actual::add);
        return actual;
    }
}
