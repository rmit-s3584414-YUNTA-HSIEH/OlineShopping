package onlineShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import onlineShopping.Service.productService;
import onlineShopping.model.product;

@Controller
public class productController {
	
	@Autowired
	private productService productService;
	
	@RequestMapping(value="/productPage")
	public String productPage(@RequestParam(value="proId")String proId,Model model){
		System.out.println(proId);
		int id= Integer.parseInt(proId);
		product productDetail=productService.getById(id);
		
		model.addAttribute("productDetail",productDetail);
		
		return "productPage";
		
	}
	
}
