package com.easy.shop.entities;

import com.easy.shop.constants.ProductCategory;
import org.joda.time.DateTime;

public class Product {

	private final String productID;

	private final String productName;

	private final ProductCategory productCategory;

	private final DateTime  dateOfComingIntoEasyShop;

	private final DateTime  dateOfSellFromEasyShop;

	private final DateTime  dateOfExpriy;

	private final DateTime  dateOfMFG;

	public Product(String productID, String productName, ProductCategory productCategory, DateTime dateOfComingIntoEasyShop, DateTime dateOfSellFromEasyShop, DateTime dateOfExpriy, DateTime dateOfMFG) {
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.dateOfComingIntoEasyShop = dateOfComingIntoEasyShop;
		this.dateOfSellFromEasyShop = dateOfSellFromEasyShop;
		this.dateOfExpriy = dateOfExpriy;
		this.dateOfMFG = dateOfMFG;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}


	public ProductCategory getProductCategory() {
		return productCategory;
	}


	public DateTime getDateOfComingIntoEasyShop() {
		return dateOfComingIntoEasyShop;
	}

	public DateTime getDateOfSellFromEasyShop() {
		return dateOfSellFromEasyShop;
	}

	public DateTime getDateOfExpriy() {
		return dateOfExpriy;
	}

	public DateTime getDateOfMFG() {
		return dateOfMFG;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (productID != null ? !productID.equals(product.productID) : product.productID != null) return false;
		if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
		if (productCategory != product.productCategory) return false;
		if (dateOfComingIntoEasyShop != null ? !dateOfComingIntoEasyShop.equals(product.dateOfComingIntoEasyShop) : product.dateOfComingIntoEasyShop != null)
			return false;
		if (dateOfSellFromEasyShop != null ? !dateOfSellFromEasyShop.equals(product.dateOfSellFromEasyShop) : product.dateOfSellFromEasyShop != null)
			return false;
		if (dateOfExpriy != null ? !dateOfExpriy.equals(product.dateOfExpriy) : product.dateOfExpriy != null)
			return false;
		return dateOfMFG != null ? dateOfMFG.equals(product.dateOfMFG) : product.dateOfMFG == null;
	}

	@Override
	public int hashCode() {
		int result = productID != null ? productID.hashCode() : 0;
		result = 31 * result + (productName != null ? productName.hashCode() : 0);
		result = 31 * result + (productCategory != null ? productCategory.hashCode() : 0);
		result = 31 * result + (dateOfComingIntoEasyShop != null ? dateOfComingIntoEasyShop.hashCode() : 0);
		result = 31 * result + (dateOfSellFromEasyShop != null ? dateOfSellFromEasyShop.hashCode() : 0);
		result = 31 * result + (dateOfExpriy != null ? dateOfExpriy.hashCode() : 0);
		result = 31 * result + (dateOfMFG != null ? dateOfMFG.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productID='" + productID + '\'' +
				", productName='" + productName + '\'' +
				", productCategory=" + productCategory +
				", dateOfComingIntoEasyShop=" + dateOfComingIntoEasyShop +
				", dateOfSellFromEasyShop=" + dateOfSellFromEasyShop +
				", dateOfExpriy=" + dateOfExpriy +
				", dateOfMFG=" + dateOfMFG +
				'}';
	}
}
