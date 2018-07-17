package onlineShopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import onlineShopping.Service.*;
import onlineShopping.model.user;

@Controller
public class registerController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping(value="/newUser")
	public String register(Model model){
		
		user user=new user();
		model.addAttribute("newUser", user);
		return "register";
	}
	
	@RequestMapping(value="/saveUser")
	public String saveUser(@Valid@ModelAttribute("newUser")
	user user,BindingResult result){
		if(result.hasErrors()){
			return "register";
		}else{
			user.setRole("USER");
			user.setEnable(true);
			userService.insert(user);
			return "redirect:/";
		}
		
		
		
	}
	
	
	
	
	
	
}
