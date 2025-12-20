package ATM_MACHINE;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId;
    private String customerName;
    private long accNumber;
    private String pin;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    Customer(int customerId,String customerName, long accNumber, String pin, double balance)
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.accNumber = accNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction t) {
        if (transactions.size() == 10) {
            transactions.remove(0); // keep last 10
        }
        transactions.add(t);
    }


    @Override
    public String toString() {
        return String.format(
                "| %-12d | %-15s | %-12d | %-10s | %-10.2f |",
                customerId,
                customerName,
                accNumber,
                pin,
                balance
        );
    }


}
