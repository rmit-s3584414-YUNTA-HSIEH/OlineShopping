package onlineShopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderItems")
public class orderItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemId")
	 private int itemId;

	@Column(name="proId")
	 private int proId;
	
	@Column(name="quantity")
	 private int quantity ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId")
	private orders orders;
	
	
	public orderItems(int proId,int quantity){
		this.proId=proId;
		this.quantity=quantity;
	}
	
public orderItems(){
		
	}
	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public orders getOrder() {
		return orders;
	}

	public void setOrder(orders order) {
		this.orders = order;
	}
	
	
	
	
	
	
	
}
