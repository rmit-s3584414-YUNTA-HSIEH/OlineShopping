package onlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;  
import org.springframework.security.core.context.SecurityContextHolder;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler; 

import onlineShopping.Service.*;
import onlineShopping.model.product;

@Controller
public class loginController {
	
	@Autowired
	private productService productService;
	
	@RequestMapping(value = "/")  
    public String defaultPage(Model model) {  
        return "redirect:/index";  
    } 
	
    @RequestMapping(value = "/home")  
    public String homePage(Model model) {  
        model.addAttribute("greeting", "Hi, Welcome to mysite");  
        return "welcome";  
    } 
	
	@RequestMapping(value="/admin")
	public String adminPage(Model model){
		model.addAttribute("user",getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "/Access_Denied")  
    public String accessDeniedPage(Model model) {  
        model.addAttribute("user", getPrincipal());  
        return "accessDenied";  
    }  
	
	@RequestMapping(value = "/login")  
    public String loginPage() {  
        return "login";  
    } 
	
	@RequestMapping(value = "/index")  
    public String index(Model model) {  
		List<product> products=	productService.getProList();
		model.addAttribute("products",products );
        return "index";  
    } 
	
	
	@RequestMapping(value="/logout")  
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
            new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
        return "redirect:/login?logout";  
    }  
	
	
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
	
}
