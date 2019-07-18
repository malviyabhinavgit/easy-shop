package com.easy.shop.entities;


public class Customer {
	private final String customerId;

	private final  String customerName;

	private final String customerAddress;

	private final String customerEmailId;

	public String getCustomerId() {
		return customerId;
	}


	public String getCustomerName() {
		return customerName;
	}

	public Customer(String customerId, String customerName, String customerAddress, String customerEmailId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
		if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
			return false;
		return customerAddress != null ? customerAddress.equals(customer.customerAddress) : customer.customerAddress == null;
	}

	@Override
	public int hashCode() {
		int result = customerId != null ? customerId.hashCode() : 0;
		result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
		result = 31 * result + (customerAddress != null ? customerAddress.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId='" + customerId + '\'' +
				", customerName='" + customerName + '\'' +
				", customerAddress='" + customerAddress + '\'' +
				", emailAddress='" + customerEmailId + '\'' +
				'}';
	}

	public String sharedInfoWithCustomer() {
		return "Customer Details:\n" +
				"customerName='" + customerName + '\'' + '\n' +
				"customerAddress='" + customerAddress + '\'' + '\n' +
				"emailAddress='" + customerEmailId + '\'' + '\n';
	}
}
