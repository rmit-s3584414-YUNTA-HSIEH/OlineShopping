package onlineShopping.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import onlineShopping.model.orderItems;
import onlineShopping.model.orders;

@Repository
public class ordersDAOImp implements ordersDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	

	@Override
	public orders getById(int id) {
		  String hql = "from orders o where o.id = ?";
	        Query query = getSession().createQuery(hql);
	        query.setParameter(0,id);
	        return (orders) query.uniqueResult();
	}

	@Override
	public List<orders> findOrderList() {
		Query<orders> theQuery =getSession().createQuery("from orders",orders.class);
		List<orders> orders=theQuery.getResultList();
		return orders;
	}

	@Override
	public void insertOrder(orders orders) {
		this.getSession().save(orders);
		
	}

	@Override
	public List<orderItems> findOrderItemsByOId(int id) {
		String hql="from orderItems oi where oi.orderId=?";
		Query query= getSession().createQuery(hql);
		query.setParameter(0, id);
		List<orderItems> list=query.list();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}



	@Override
	public void insertOrderItem(orderItems orderItems) {
		this.getSession().save(orderItems);
	}



	@Override
	public orders getByUserId(int userId) {
		String hql = "from orders o where o.userId = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,userId);
        return (orders) query.uniqueResult();
		
	}



	@Override
	public void updateOrder(orders order) {
		this.getSession().update(order);
		
	}
}
