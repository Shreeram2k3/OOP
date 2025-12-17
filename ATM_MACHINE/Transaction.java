package ATM_MACHINE;

public class Transaction {
    private int transId;
    private String transDescription;
    private String type;
    private double amount;

    public Transaction(int transId, String transDescription, String type, double amount) {
        this.transId = transId;
        this.transDescription = transDescription;
        this.type = type;
        this.amount = amount;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getTransDescription() {
        return transDescription;
    }

    public void setTransDescription(String transDescription) {
        this.transDescription = transDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-8d | %-25s | %-6s | %8.2f |",
                transId,
                transDescription,
                type,
                amount
        );
    }


}
