package onlineShopping.Service;

import onlineShopping.model.user;

public interface userService {
	user select(String userName);
	
	user insert(user user);
	
	user update(user user);
}
