public class SavingsAccount extends Account {
private double interestRate; // annual rate in percent (e.g., 4.0 = 4% pa)


public SavingsAccount(Customer owner, double initialDeposit, double interestRate) {
super(owner, initialDeposit);
this.interestRate = interestRate;
}


@Override
public boolean withdraw(double amount) {
if (amount <= 0) return false;
if (amount > balance) return false; // no overdraft for savings
balance -= amount;
transactions.add(new Transaction(Transaction.Type.WITHDRAWAL, amount, "Withdrawal"));
return true;
}


// Apply simple interest for the given number of months
public void applyInterestMonths(int months) {
if (months <= 0) return;
double monthlyRate = (interestRate / 100.0) / 12.0;
double interest = balance * monthlyRate * months;
balance += interest;
transactions.add(new Transaction(Transaction.Type.INTEREST, interest, "Interest for " + months + " months"));
}


public double getInterestRate() { return interestRate; }
public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
}
