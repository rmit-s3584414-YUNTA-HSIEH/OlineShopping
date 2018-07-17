package onlineShopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import onlineShopping.Service.userService;
import onlineShopping.model.user;

@Controller
public class updateUserController {
	
	@Autowired
	private userService userService;
	
	
	private String getPrincipal(){  
        String userName = null;  
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
   
        if (principal instanceof UserDetails) {  
            userName = ((UserDetails)principal).getUsername();  
        } else {  
            userName = principal.toString();  
        }  
        return userName;  
    }  
	
	
	@RequestMapping(value="/update")
	public String updateUser(Model model){
		String userName= getPrincipal();
		user updateUser = userService.select(userName);
		model.addAttribute("updateUser", updateUser);
		return "updateUser";
	}
	
	
	@RequestMapping(value="/updated")
	public String updated(@Valid@ModelAttribute("updateUser")
	user user,BindingResult result){
		if(result.hasErrors()){
			return "updateUser";
		}else{
			user.setRole("USER");
			user.setEnable(true);
			userService.update(user);
			return "redirect:/";
		}
	}
	
}
