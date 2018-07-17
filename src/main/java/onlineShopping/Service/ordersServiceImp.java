package onlineShopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onlineShopping.model.orderItems;
import onlineShopping.model.orders;
import onlineShopping.DAO.ordersDAOImp;

@Service
@Transactional
public class ordersServiceImp implements ordersService{
	
	@Autowired
	private ordersDAOImp ordersDAOImp;

	@Override
	public orders getById(int id) {
		
		return ordersDAOImp.getById(id);
	}

	@Override
	public List<orders> findOrderList() {
		
		return ordersDAOImp.findOrderList();
	}

	@Override
	@Transactional
	public void insertOrder(orders orders) {
		
		ordersDAOImp.insertOrder(orders);
		
	}

	@Override
	public List<orderItems> findOrderItemsByOId(int id) {
		
		return ordersDAOImp.findOrderItemsByOId(id);
	}



	@Override
	public void insertOrderItem(orderItems orderItems) {
		ordersDAOImp.insertOrderItem(orderItems);
		
	}

	@Override
	public void updateOrder(orders order) {
		ordersDAOImp.updateOrder(order);
		
	}

}
