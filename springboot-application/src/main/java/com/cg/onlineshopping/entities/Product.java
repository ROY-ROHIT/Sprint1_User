package com.cg.onlineshopping.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Product")
public class Product {

	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="BRAND_NAME")
	private String brandName;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="SPECIFICATION")
	private String specification;
	
	@Column(name="QUANTITY")
	private int quantity;  // quantity in hand or stock , not quantity ordered
	
	@Column(name="USER_RATINGS")
	private int userRatings;
	
	
	
	public Product() {
		
	}
	
	

	public Product(int productId,String productName, String brandName, String category, int price, String color,
			String specification, int quantity, int userRatings) {
		//super();
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.category = category;
		this.price = price;
		this.color = color;
		this.specification = specification;
		this.quantity = quantity;
		this.userRatings = userRatings;

	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(int userRatings) {
		this.userRatings = userRatings;
	}
//
//	public List<Review> getReview() {
//		return review;
//	}
//
//	public void setReview(List<Review> review) {
//		this.review = review;
//	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", category=" + category + ", price=" + price + ", color=" + color + ", specification="
				+ specification + ", quantity=" + quantity + ", userRatings=" + userRatings + ", review=  "
				+ "]";
	}

}