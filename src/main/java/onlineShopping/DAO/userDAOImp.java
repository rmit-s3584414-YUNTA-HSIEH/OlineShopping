package onlineShopping.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;

import onlineShopping.model.user;

@Repository
public class userDAOImp implements userDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public user select(String userName) {
		user user = new user();
		List<?>list=hibernateTemplate.find("from user as u where u.userName=?", userName);
		if(!list.isEmpty()){
			user=(user)list.get(0);
		}
		System.out.println("DAO"+user.getUserName()+" "+user.getPassword()+" "+user.getRole()+" "+user.getOrders().size());
		return user;
	}

	@Override
	public user insert(user user) {
		this.getSession().save(user);
		return null;
	}

	@Override
	public user update(user user) {
		this.getSession().update(user);
		return user;
	}
	
	
}
