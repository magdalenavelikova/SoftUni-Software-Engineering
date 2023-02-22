package workingWithAbstraction.greedyTimes;

import java.util.*;

import static workingWithAbstraction.greedyTimes.Type.*;

public class Bag {
    private List<Item> items;

    private long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }


    public long getAmountByType(Type type) {
        return items.stream()
                .filter(e -> e.getType().equals(type))
                .mapToLong(Item::getAmount)
                .sum();
    }

    public long getCountByType(Type type) {
        return items.stream()
                .filter(e -> e.getType().equals(type))
                .mapToLong(Item::getAmount)
                .count();
    }
    public long getBagAmount() {
        return getAmountByType(GEM)
                + getAmountByType(CASH)
                + getAmountByType(GOLD);
    }

    public void addToBag(Item item) {
        long currentAmount = item.getAmount();
        if (currentAmount + getBagAmount() <= capacity) {
            Type type = item.getType();

            switch (type.toString()) {
                case "GOLD":
                    if (isAllRulesValid(getAmountByType(GOLD) + currentAmount,
                            getAmountByType(GEM),
                            getAmountByType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "GEM":
                    if (isAllRulesValid(getAmountByType(GOLD),
                            getAmountByType(GEM) + currentAmount,
                            getAmountByType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "CASH":
                    if (isAllRulesValid(getAmountByType(GOLD),
                            getAmountByType(GEM),
                            getAmountByType(CASH) + currentAmount)) {
                        items.add(item);
                    }
                    break;
            }
        }
    }


    public boolean isAllRulesValid(long goldAmount, long gemAmount, long cashAmount) {
        return (goldAmount >= gemAmount && gemAmount >= cashAmount);
    }

    private void printByGroupItem(Type type) {
        Map<String, Long> valueByName = new TreeMap<>();
        items.stream().filter(e -> e.getType().equals(type))
                .forEach(e -> {
                            String name = e.getItemName();
                            valueByName.putIfAbsent(name, 0L);
                            valueByName.put(name, valueByName.get(name) + e.getAmount());
                        }
                );
        Map<String, Long> sortedByAmount = new TreeMap<>(Collections.reverseOrder());
        valueByName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortedByAmount.put(e.getKey(), e.getValue()));

        sortedByAmount.forEach((key, value) -> System.out.printf("##%s - %s%n", key, value));
    }

    public void printContent() {
        if (getCountByType(GOLD) > 0) {
            System.out.printf("<Gold> $%s%n", getAmountByType(GOLD));
            printByGroupItem(GOLD);
        }
        if (getCountByType(GEM) >0) {
            System.out.printf("<Gem> $%s%n", getAmountByType(GEM));
            printByGroupItem(GEM);
        }
        if (getCountByType(CASH) > 0) {
            System.out.printf("<Cash> $%s%n", getAmountByType(CASH));
            printByGroupItem(CASH);
        }

    }

}
