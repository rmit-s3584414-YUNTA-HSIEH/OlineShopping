package onlineShopping.Service;

import java.util.List;

import onlineShopping.model.orderItems;
import onlineShopping.model.orders;

public interface ordersService {
	
	public orders getById(int id);
	
	public List<orders> findOrderList();
	
	public void insertOrder(orders orders);
	
	public void updateOrder(orders order);
	
	public void insertOrderItem(orderItems orderItems);
	
	public List<orderItems> findOrderItemsByOId(int id);
}
