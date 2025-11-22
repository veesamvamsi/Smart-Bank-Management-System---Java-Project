import java.util.List;
private static void checkBalance() {
System.out.println("\n--- Check Balance ---");
System.out.print("Account ID: ");
String accId = scanner.nextLine().trim();
Account a = bank.findAccountById(accId);
if (a == null) { System.out.println("Account not found."); return; }
System.out.println("Balance: " + String.format("%.2f", a.getBalance()));
}


private static void printStatement() {
System.out.println("\n--- Print Account Statement ---");
System.out.print("Account ID: ");
String accId = scanner.nextLine().trim();
Account a = bank.findAccountById(accId);
if (a == null) { System.out.println("Account not found."); return; }
int n = readInt("How many recent transactions to show: ");
a.printStatement(n);
}


private static void applyInterest() {
System.out.println("\n--- Apply Interest (Savings only) ---");
System.out.print("Account ID: ");
String accId = scanner.nextLine().trim();
Account a = bank.findAccountById(accId);
if (a == null) { System.out.println("Account not found."); return; }
if (!(a instanceof SavingsAccount)) { System.out.println("This is not a savings account."); return; }
int months = readInt("Number of months to apply interest: ");
((SavingsAccount) a).applyInterestMonths(months);
System.out.println("Interest applied. New balance: " + String.format("%.2f", a.getBalance()));
}


// Utility input readers
private static int readInt(String prompt) {
if (prompt != null) System.out.print(prompt);
while (true) {
try {
String line = scanner.nextLine().trim();
return Integer.parseInt(line);
} catch (NumberFormatException e) {
System.out.print("Please enter a valid integer: ");
}
}
}


private static double readDouble(String prompt) {
if (prompt != null) System.out.print(prompt);
while (true) {
try {
String line = scanner.nextLine().trim();
return Double.parseDouble(line);
} catch (NumberFormatException e) {
System.out.print("Please enter a valid number: ");
}
}
}
}
