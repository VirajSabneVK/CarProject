package CarRental;

public class Customer {

	String customerName;
	String customerId;
	
	public Customer(String customerName, String customerId) {
		this.customerName = customerName;
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
}
