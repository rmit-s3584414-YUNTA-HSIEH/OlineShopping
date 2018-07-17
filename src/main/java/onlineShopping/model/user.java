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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="userName")
	@NotEmpty(message="cannot be empty")
	private String userName;
	
	@Column(name="password")
	@Size(min=6,max=200,message="need to longer than 6 characters")
	private String password;
	
	@Column(name="email")
	@NotEmpty(message="cannot be empty")
	 @Email(message="invaild type")
	private String email;
	
	
	@Column(name="address")
	private String address;
	
	@Column(name="enable")
	private boolean enable;
	
	@Column(name="role")
	private String role;
	
	
	@OneToMany(targetEntity=orders.class,mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<orders> orders =new ArrayList<>();
	
	
	public List<orders> getOrders() {
		return orders;
	}


	public void setOrders(List<orders> orders) {
		this.orders = orders;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
