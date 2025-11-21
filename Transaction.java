import java.time.LocalDateTime;


public class Transaction {
public enum Type { DEPOSIT, WITHDRAWAL, TRANSFER_IN, TRANSFER_OUT, INTEREST }


private final Type type;
private final double amount;
private final LocalDateTime timestamp;
private final String description;


public Transaction(Type type, double amount, String description) {
this.type = type;
this.amount = amount;
this.timestamp = LocalDateTime.now();
this.description = description;
}


public Type getType() { return type; }
public double getAmount() { return amount; }
public LocalDateTime getTimestamp() { return timestamp; }
public String getDescription() { return description; }


@Override
public String toString() {
return String.format("[%s] %s: %.2f -- %s", timestamp, type, amount, description);
}
}
