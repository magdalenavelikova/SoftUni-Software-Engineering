public interface Transaction {
    public int getId();
    public TransactionStatus getStatus();
    public String getFrom();
    public String getTo();
    public double getAmount();
    public void setStatus(TransactionStatus status);
}
