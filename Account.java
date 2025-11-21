import java.util.ArrayList;
import java.util.List;


public abstract class Account {
protected final String accountId;
protected final Customer owner;
protected double balance;
protected final List<Transaction> transactions;


public Account(Customer owner, double initialDeposit) {
this.accountId = Utils.generateId("ACC");
this.owner = owner;
this.balance = Math.max(0, initialDeposit);
this.transactions = new ArrayList<>();
if (initialDeposit > 0) {
transactions.add(new Transaction(Transaction.Type.DEPOSIT, initialDeposit, "Initial deposit"));
}
}


public String getAccountId() { return accountId; }
public Customer getOwner() { return owner; }
public double getBalance() { return balance; }


public void deposit(double amount) {
if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
balance += amount;
transactions.add(new Transaction(Transaction.Type.DEPOSIT, amount, "Deposit"));
}


// withdraw should be implemented according to account type behaviour
public abstract boolean withdraw(double amount);


public void addTransaction(Transaction t) {
transactions.add(t);
}


public List<Transaction> getTransactions() { return transactions; }


public void printStatement(int lastN) {
System.out.println("\nAccount Statement for " + accountId + " (Owner: " + owner.getName() + ")");
System.out.println("Current Balance: " + String.format("%.2f", balance));
System.out.println("Last " + lastN + " transactions:");
int start = Math.max(0, transactions.size() - lastN);
for (int i = transactions.size() - 1; i >= start; i--) {
System.out.println(transactions.get(i));
}
}


@Override
public String toString() {
return String.format("%s | %s | Balance: %.2f", accountId, owner.getName(), balance);
}
}
