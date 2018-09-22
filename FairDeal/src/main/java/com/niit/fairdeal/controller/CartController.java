package com.niit.fairdeal.controller;


import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.fairdealbackend.dao.AddressDAO;
import com.niit.fairdealbackend.dao.CartDAO;

import com.niit.fairdealbackend.dao.ProductDAO;
import com.niit.fairdealbackend.dao.UserDAO;
import com.niit.fairdealbackend.dto.Address;
import com.niit.fairdealbackend.dto.Cart;
import com.niit.fairdealbackend.dto.Product;
import com.niit.fairdealbackend.dto.User;



@Controller
public class CartController {

	 @Autowired
	 private CartDAO cartDAO;
	 
	 @Autowired
	 private ProductDAO productDAO;
		

	
	 
	 public static final Logger log = LoggerFactory.getLogger(CartController.class);

	 int q;
	 
	 @RequestMapping(value={"addtoCart/{id}","navproducts/addtoCart/{id}","addtoCart/{userid}/{id}"})
	 public String addtoCart(@ModelAttribute("Cart") Cart cart, BindingResult result, @PathVariable("userid") int userid, @PathVariable("id") int productid, HttpSession session) throws Exception{
	 
	  log.debug("Starting of the method addtoCart");
	  long p;
	  if(cartDAO.getproduct(productid,userid)==null){
	   Cart cart2= new Cart(); 
	   Product product = productDAO.getProductByID(productid);
	   cart2.setProductid(product.getId());
	   cart2.setProductname(product.getName());
	   cart2.setPrice(product.getPrice());
	   cart2.setQuantity(1);
	   q=cart2.getQuantity();
	   cart2.setStatus("C");
	   cart2.setUserid(userid);
	   
	   	   cartDAO.save(cart2);
	   	session.setAttribute("cartsize", cartDAO.cartsize( (Integer) session.getAttribute("userid")));
	  System.out.println("Cart Is Saved Sucessfully...!!!");
	   return "redirect:/Cart";
	  }
	  else
	  {
	   Cart cart1 = cartDAO.getproduct(productid,userid);
	   Product product1 = productDAO.getProductByID(productid);
	   q=cart1.getQuantity();
	   cart1.setStatus("C");
	   p=product1.getPrice();
	   q+=1;
	   p=q*p;
	 cart1.setQuantity(q);
	 cart1.setPrice(p);
	cartDAO.save(cart1);
	System.out.println("Operation Over");

	log.debug("Ending of the method addtoCart");
	return "redirect:/Cart";
	  } 
	 }
	 
	@RequestMapping(value="update/{id}")
	public String update(@ModelAttribute("Cart") Cart cart)
	{
			log.debug("Starting of the method updateCart");
			cartDAO.update(cart);
			log.debug("Ending of the method updateCart");
			return "redirect:/Cart";
	}
	
	 @RequestMapping(value="delete/{id}")
	 public String delete(@ModelAttribute("Cart") Cart cart, HttpSession session)
	 {
	  log.debug("Starting of the method deleteCart");	 
	  cartDAO.delete(cart);
	  session.setAttribute("cartsize", cartDAO.cartsize( (Integer) session.getAttribute("userid")));
	  log.debug("Ending of the method deleteCart");
	  return "redirect:/Cart";
	 }
	 
	 @RequestMapping("editorder/{id}")
	 public String editorder(@PathVariable("id") int id, @RequestParam("quantity") int q, HttpSession session) 
	 {
		 	log.debug("Starting of the method editorder");
			Cart cart = cartDAO.getitem(id);
			Product product = productDAO.getProductByID(cart.getProductid());
			System.out.println("cartlist==="+cart.getProductid());
			System.out.println("productlist="+product);
			cart.setQuantity(q);
			cart.setPrice(q * product.getPrice());
			cartDAO.save(cart);
			session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
			log.debug("Ending of the method editorder");
			return "redirect:/Cart";
		}

	 @RequestMapping(value="/Cart")
	 public ModelAndView cartpage(@ModelAttribute("cart") Cart cart, HttpSession session)
	 {
	  log.debug("Starting of the method cartpage");	 
	  ModelAndView mv= new ModelAndView("/Cart");
	  int userid = (Integer) session.getAttribute("userid");
	  mv.addObject("cartList", cartDAO.get(userid));
	  if(cartDAO.cartsize((Integer) session.getAttribute("userid"))!=0){
		   mv.addObject("cartprice", cartDAO.CartPrice((Integer) session.getAttribute("userid")));
	  }
	  else
	  {
	  mv.addObject("emptycart","Sorry Your Shopping Cart Is Empty");
	  }
	  mv.addObject("isUserClickedCart","true");
	  log.debug("Ending of the method cartpage");
	  return mv;
	 }
	 
	 @Autowired
	 UserDAO userDao;
	 
	 @RequestMapping(value="checkoutFlow",method=RequestMethod.GET)
		public ModelAndView addressForm(HttpServletRequest request){
			
			String id=request.getUserPrincipal().getName();
			System.out.println("Id = "+id);
			User user=userDao.getUserByName(id);
			System.out.println("User ="+user);
			
			Set<Address> addresses=user.getAddresses();
			
			
			
			if(addresses==null){
				ModelAndView mv=new ModelAndView("AddressForm");
				mv.addObject("addressObj",new Address());
				return mv;
			}
			else {
			ModelAndView mv=new ModelAndView("ViewAddress");
			mv.addObject("addressList",addresses);
			return mv;
			}
		}
	 
	 @Autowired
	 HttpServletRequest request;
	 
	 @Autowired
	 AddressDAO addressDAO;
	 
		@RequestMapping(value="addAddress",method=RequestMethod.POST)
		public ModelAndView addAddress(@ModelAttribute("addressObj")Address addrObj){
			
			
			System.out.println("I m here 1");
			String id=request.getUserPrincipal().getName();
			
			User user=userDao.getUserByName(id);
		
			System.out.println("I m here 2"+id);
			addrObj.setUser(userDao.getUserByName(id));
			
			addressDAO.insertAddress(addrObj);
			
			System.out.println("I m here 3");
			Set<Address> addresses=user.getAddresses();
			
			System.out.println("I m here 4");
			ModelAndView mv=new ModelAndView("ViewAddress");
			mv.addObject("addressList",addresses);
			return mv;
			
		}
	 
	
 @RequestMapping(value="placeorder")
	 public String placeorder(Model model)
	 {
	  log.debug("Starting of the method placeorder");	 
	  model.addAttribute("IfPaymentClicked", "true");
	  model.addAttribute("HideOthers","true");
	  log.debug("Ending of the method placeorder");
	  return "tqpage";
	 }

	 @RequestMapping(value="pay")
	 public String payment(HttpSession session) 
	 {
	  log.debug("Starting of the method payment");	 
	  cartDAO.pay((Integer) session.getAttribute("userid"));
	  log.debug("Ending of the method payment");
	  return "tqpage";
	 }
	 
	 @RequestMapping(value="tqpage")
	 public String tqpage(HttpSession session) 
	 {
	  log.debug("Starting of the method tqpage");	 
	  cartDAO.pay((Integer) session.getAttribute("userid"));
	  log.debug("Ending of the method tqpage");
	  return "tqpage";
	 }
}