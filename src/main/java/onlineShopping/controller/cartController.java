package onlineShopping.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import onlineShopping.model.cartItems;
import onlineShopping.model.orderItems;
import onlineShopping.model.orders;
import onlineShopping.model.product;
import onlineShopping.model.user;
import onlineShopping.Service.productService;
import onlineShopping.Service.userService;
import onlineShopping.Service.ordersService;
@Controller
public class cartController {
	
	@Autowired
	productService productService;
	
	@Autowired
	userService userService;
	
	@Autowired
	ordersService ordersService;
	
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
	
	
	@RequestMapping(value="/addToCart")
	public String productPage(@RequestParam(value="proId")String proId,@RequestParam(value="quantity")String quantity,
			HttpSession session){
			//user has logined 
			int id= Integer.parseInt(proId);
			int qty= Integer.parseInt(quantity);
			product product=productService.getById(id);
			
			cartItems cartItems =new cartItems(product,qty);
			//if cart session is not exist than create cart session 
			if(session.getAttribute("cart")==null){
				List<cartItems> cart= new ArrayList<>();
				int totalPrice=(cartItems.getQuantity())*(cartItems.getProduct().getPrice());
				cartItems.setTotal(totalPrice);
				cart.add(cartItems);
				session.setAttribute("cart",cart);
				session.setMaxInactiveInterval(60*60*24);
			}else{
				//cart session already exist
				List<cartItems> cart = (List<cartItems>) session.getAttribute("cart");
				
				//check if there have same product in cart already
				int count=0;
				for(cartItems Items:cart){
					//add quantity in exist product
					if(Items.getProduct().getProId()==id){
						Items.setQuantity(Items.getQuantity()+qty);
						int totalPrice=(Items.getQuantity())*(Items.getProduct().getPrice());
						Items.setTotal(totalPrice);
					}else{
						count++;
					}
				}
				//new product add in cart
				if(count==cart.size()){
					int totalPrice=(cartItems.getQuantity())*(cartItems.getProduct().getPrice());
					cartItems.setTotal(totalPrice);
					cart.add(cartItems);
				}
				
				session.setAttribute("cart",cart);
			}
		return "cart";
		
	}
	
	@RequestMapping(value="/deleteCart")
	public String deleteCart(@RequestParam(value="proId")String proId,HttpSession session){
		System.out.println(proId);
		int id= Integer.parseInt(proId);
		List<cartItems> cart = (List<cartItems>) session.getAttribute("cart");
		
		for(cartItems items:cart){
			if(items.getProduct().getProId()==id){
				cart.remove(items);
				break;
			}
		}
		session.setAttribute("cart",cart);
		return "cart";
		
	}
	
	@RequestMapping(value="/cart")
	public String cart(){
		return "cart";
	}
	
	@RequestMapping(value="/checkOut")
	public String checkOut(@RequestParam(value="address")String address,@RequestParam(value="phone")String phone,HttpSession session){
		System.out.println(address+" "+phone);
		int contactPhone= Integer.parseInt(phone);
		
		//create current user object
		user user=userService.select(getPrincipal());
		
		//create new order and set up order detail
		orders order=new orders();
		order.setPhone(contactPhone);
		order.setShipAddress(address);
		order.setUser(user);
		order.setEnable(true);
		ordersService.insertOrder(order);
		
		//get cart from session
		List<cartItems> cart = (List<cartItems>) session.getAttribute("cart");
		
		//create a order items list for adding order items from cart items list
		List<orderItems> orderItemsList= new ArrayList<>();
		
		//find order by user id
		List<orders>orderList=ordersService.findOrderList();

		for(orders orderCheck:orderList){
			System.out.println(orderCheck.getOrderId());
			if((user.getId()==orderCheck.getUser().getId())&&orderCheck.isEnable()){
				System.out.println("true"+orderCheck.getOrderId());
				//change cartItems list into orderItems list
				
				Iterator<cartItems> iter=cart.iterator();
				while(iter.hasNext()){
					cartItems cartitems=iter.next();
					System.out.println(cartitems);
					orderItems orderItems =new orderItems();
					orderItems.setOrder(orderCheck);
					orderItems.setProId(cartitems.getProduct().getProId());
					orderItems.setQuantity(cartitems.getQuantity());
					ordersService.insertOrderItem(orderItems);
					iter.remove();
				}
				orderCheck.setEnable(false);
				ordersService.updateOrder(orderCheck);
				break; 
			}
		}
		session.removeAttribute("cart");
		
		return "cart";
		
	}
}
