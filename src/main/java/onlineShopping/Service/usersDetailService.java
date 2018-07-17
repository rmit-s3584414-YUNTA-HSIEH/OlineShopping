package onlineShopping.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onlineShopping.model.user;


@Service("usersDetailService")
public class usersDetailService implements UserDetailsService{
	
	@Autowired
	private userService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("get"+userName);
		user user =userService.select(userName);
		if(user==null){
			throw new UsernameNotFoundException("username not found");
		}
		System.out.println("userDetail"+user.getUserName()+" "+user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword()
				,user.isEnable(), true, true, true, getGrantedAuthorities(user));
	}
	 private List<GrantedAuthority> getGrantedAuthorities(user user){  
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        
	        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	        
			return authorities;
	 }
}
