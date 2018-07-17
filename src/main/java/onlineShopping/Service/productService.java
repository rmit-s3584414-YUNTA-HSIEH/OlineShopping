package onlineShopping.Service;

import java.util.List;

import onlineShopping.model.product;

public interface productService {

	public product getById(int id);
	
	public product getByTitle(String title);
	
	public List<product> getProList();
	
	public boolean addProduct(product product);
	
	public boolean deleteProduct(product product);
}
