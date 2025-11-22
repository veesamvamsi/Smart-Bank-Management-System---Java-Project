import java.util.ArrayList;
import java.util.List;


public class Bank {
private final String name;
private final List<Customer> customers;
private final List<Account> accounts;


public Bank(String name) {
this.name = name;
this.customers = new ArrayList<>();
this.accounts = new ArrayList<>();
}


public Customer createCustomer(String name, String email, String phone) {
Customer c = new Customer(name, email, phone);
customers.add(c);
return c;
}


public Account createSavingsAccount(Customer owner, double initialDeposit, double interestRate) {
SavingsAccount acc = new SavingsAccount(owner, initialDeposit, interestRate);
accounts.add(acc);
return acc;
}


public Account createCurrentAccount(Customer owner, double initialDeposit, double overdraftLimit) {
CurrentAccount acc = new CurrentAccount(owner, initialDeposit, overdraftLimit);
accounts.add(acc);
return acc;
}


public Account findAccountById(String accId) {
for (Account a : accounts) if (a.getAccountId().equals(accId)) return a;
return null;
}


public Customer findCustomerById(String custId) {
for (Customer c : customers) if (c.getCustomerId().equals(custId)) return c;
return null;
}


public boolean transfer(String fromAccId, String toAccId, double amount) {
Account from = findAccountById(fromAccId);
Account to = findAccountById(toAccId);
if (from == null || to == null) return false;
if (amount <= 0) return false;


boolean withdrew = from.withdraw(amount);
if (!withdrew) return false;
to.deposit(amount);
from.addTransaction(new Transaction(Transaction.Type.TRANSFER_OUT, amount, "Transfer to " + to.getAccountId()));
to.addTransaction(new Transaction(Transaction.Type.TRANSFER_IN, amount, "Transfer from " + from.getAccountId()));
return true;
}


public List<Customer> getCustomers() { return customers; }
public List<Account> getAccounts() { return accounts; }


public void printAllAccounts() {
System.out.println("\nAccounts in " + name + ":");
for (Account a : accounts) System.out.println(a);
}


public void printAllCustomers() {
System.out.println("\nCustomers in " + name + ":");
for (Customer c : customers) System.out.println(c);
}
}
