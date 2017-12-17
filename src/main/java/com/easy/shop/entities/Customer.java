package com.easy.shop.entities;


import com.easy.shop.constants.CusotmerType;
import org.joda.time.DateTime;

public class Customer {
	private final String customerId;

	private final  String customerName;

	private final int age;

	private final String customerAddressFirstLine;

	private final String customerAddressSecondLine;

	private  CusotmerType cusotmerType;

	private final DateTime registrationDate;

	public Customer(String customerId, String customerName, int age, String customerAddressFirstLine, String customerAddressSecondLine, CusotmerType cusotmerType, DateTime registrationDate) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
		this.customerAddressFirstLine = customerAddressFirstLine;
		this.customerAddressSecondLine = customerAddressSecondLine;
		this.cusotmerType = cusotmerType;
		this.registrationDate = registrationDate;
	}

	public void setCusotmerType(CusotmerType cusotmerType) {
		this.cusotmerType = cusotmerType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getAge() {
		return age;
	}

	public String getCustomerAddressFirstLine() {
		return customerAddressFirstLine;
	}

	public String getCustomerAddressSecondLine() {
		return customerAddressSecondLine;
	}

	public CusotmerType getCusotmerType() {
		return cusotmerType;
	}

	public DateTime getRegistrationDate() {
		return registrationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (age != customer.age) return false;
		if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
		if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
			return false;
		if (customerAddressFirstLine != null ? !customerAddressFirstLine.equals(customer.customerAddressFirstLine) : customer.customerAddressFirstLine != null)
			return false;
		if (customerAddressSecondLine != null ? !customerAddressSecondLine.equals(customer.customerAddressSecondLine) : customer.customerAddressSecondLine != null)
			return false;
		if (cusotmerType != customer.cusotmerType) return false;
		return registrationDate != null ? registrationDate.equals(customer.registrationDate) : customer.registrationDate == null;
	}

	@Override
	public int hashCode() {
		int result = customerId != null ? customerId.hashCode() : 0;
		result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
		result = 31 * result + age;
		result = 31 * result + (customerAddressFirstLine != null ? customerAddressFirstLine.hashCode() : 0);
		result = 31 * result + (customerAddressSecondLine != null ? customerAddressSecondLine.hashCode() : 0);
		result = 31 * result + (cusotmerType != null ? cusotmerType.hashCode() : 0);
		result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId='" + customerId + '\'' +
				", customerName='" + customerName + '\'' +
				", age=" + age +
				", customerAddressFirstLine='" + customerAddressFirstLine + '\'' +
				", customerAddressSecondLine='" + customerAddressSecondLine + '\'' +
				", cusotmerType=" + cusotmerType +
				", registrationDate=" + registrationDate +
				'}';
	}
}
