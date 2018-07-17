package onlineShopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onlineShopping.DAO.productDAOImp;
import onlineShopping.model.product;

@Service
@Transactional
public class productServiceImp implements productService{
	
	@Autowired
	private productDAOImp productDAOImp;

	@Override
	public product getById(int id) {
		
		return productDAOImp.getById(id);
	}

	@Override
	public product getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> getProList() {
		List<product> products=	productDAOImp.getProList();
		return products;
		
	}

	@Override
	public boolean addProduct(product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
