package onlineShopping.DAO;

import onlineShopping.model.user;

public interface userDAO {
	user select(String userName);
	
	user insert(user user);
	
	user update(user user);
}
