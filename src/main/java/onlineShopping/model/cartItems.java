package onlineShopping.model;



public class cartItems {
	
	private product product=new  product();
	 
	 private int quantity;
	 
	 private int total;

	 public product getProduct() {
	  return product;
	 }

	 public void setProduct(product product) {
	  this.product = product;
	 }

	 public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
	  return quantity;
	 }

	 public void setQuantity(int quantity) {
	  this.quantity = quantity;
	 }

	 public cartItems(product product, int quantity) {
	  super();
	  this.product = product;
	  this.quantity = quantity;
	 }

	 public cartItems() {
	  super();
	 }
}
