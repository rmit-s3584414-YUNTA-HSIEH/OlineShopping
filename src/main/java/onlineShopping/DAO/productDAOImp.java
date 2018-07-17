package onlineShopping.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import onlineShopping.model.product;


@Repository
public class productDAOImp implements productDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public product getById(int id) {
		
		product product=getSession().get(product.class, id);
		if(product!=null){
			return product;
		}
		return null;
	}

	@Override
	public product getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> getProList() {
		
		Query<product> theQuery =getSession().createQuery("from product",product.class);
		List<product> products=theQuery.getResultList();
		
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
