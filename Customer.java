public class Customer {
private final String customerId;
private String name;
private String email;
private String phone;


public Customer(String name, String email, String phone) {
this.customerId = Utils.generateId("CUST");
this.name = name;
this.email = email;
this.phone = phone;
}


public String getCustomerId() { return customerId; }
public String getName() { return name; }
public String getEmail() { return email; }
public String getPhone() { return phone; }


public void setName(String name) { this.name = name; }
public void setEmail(String email) { this.email = email; }
public void setPhone(String phone) { this.phone = phone; }


@Override
public String toString() {
return String.format("%s | %s | %s | %s", customerId, name, email, phone);
}
}
