package workingWithAbstraction.greedyTimes;

public class Item {
  private   Type type;
  private String itemName;
  private   long amount;

  public Item(Type type, String itemName, long amount) {
    this.type = type;
    this.itemName = itemName;
    this.amount = amount;
  }

  public Type getType() {
    return type;
  }

  public String getItemName() {
    return itemName;
  }

  public long getAmount() {
    return amount;
  }
}
