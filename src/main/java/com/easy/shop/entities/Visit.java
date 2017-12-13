package com.easy.shop.entities;

import org.joda.time.DateTime;

import java.util.List;


public class Visit {

	private String visitId;
	private Customer customer;
	private List<Product> purchase;
	private DateTime visitDateBillTimong;

	public Visit(String visitId, Customer customer, List<Product> purchase, DateTime visitDateBillTimong) {
		this.visitId = visitId;
		this.customer = customer;
		this.purchase = purchase;
		this.visitDateBillTimong = visitDateBillTimong;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Product> purchase) {
		this.purchase = purchase;
	}

	public DateTime getVisitDateBillTimong() {
		return visitDateBillTimong;
	}

	public void setVisitDateBillTimong(DateTime visitDateBillTimong) {
		this.visitDateBillTimong = visitDateBillTimong;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Visit visit = (Visit) o;

		if (visitId != null ? !visitId.equals(visit.visitId) : visit.visitId != null) return false;
		if (customer != null ? !customer.equals(visit.customer) : visit.customer != null) return false;
		if (purchase != null ? !purchase.equals(visit.purchase) : visit.purchase != null) return false;
		return visitDateBillTimong != null ? visitDateBillTimong.equals(visit.visitDateBillTimong) : visit.visitDateBillTimong == null;
	}

	@Override
	public int hashCode() {
		int result = visitId != null ? visitId.hashCode() : 0;
		result = 31 * result + (customer != null ? customer.hashCode() : 0);
		result = 31 * result + (purchase != null ? purchase.hashCode() : 0);
		result = 31 * result + (visitDateBillTimong != null ? visitDateBillTimong.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Visit{" +
				"visitId='" + visitId + '\'' +
				", customer=" + customer +
				", purchase=" + purchase +
				", visitDateBillTimong=" + visitDateBillTimong +
				'}';
	}
}
