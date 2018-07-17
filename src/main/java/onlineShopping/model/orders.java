package onlineShopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private Integer orderId;
	
	@Column(name="shipAddress")
	private String shipAddress;
	
	@Column(name="phone")
	private Integer phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private user user;
	
	@Column(name="enable")
	private boolean enable;
	
	
	@OneToMany(targetEntity=orderItems.class,mappedBy="orders",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<orderItems> orderItems =new ArrayList<>();
	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public List<orderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<orderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	
	
}
