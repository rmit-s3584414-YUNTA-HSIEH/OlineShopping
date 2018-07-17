package onlineShopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onlineShopping.model.user;
import onlineShopping.DAO.*;

@Service
@Transactional
public class userServiceImp implements userService {
	
	@Autowired
	private userDAOImp userDAOImp;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public user select(String userName) {
		
		return userDAOImp.select(userName);
	}
	
	@Transactional
	@Override
	public user insert(user user) {
		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return userDAOImp.insert(user);
	}

	@Override
	public user update(user user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDAOImp.update(user);
	}

}
