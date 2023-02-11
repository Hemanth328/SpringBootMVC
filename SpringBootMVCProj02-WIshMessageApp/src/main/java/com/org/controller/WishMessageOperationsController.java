package com.org.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.service.IWishService;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/wish-controller")
public class WishMessageOperationsController {

	@Autowired
	private IWishService service;
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private ServletConfig cg;
	
	@Autowired
	private HttpSession ses; 
	
	/*
	@RequestMapping("/")
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	*/
	
	/*@RequestMapping   // In the recent versions of spring boot this RequestMapping is not supporting
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}*/
	
	/*
	
	@GetMapping   // In the recent versions of spring boot this RequestMapping is not supporting
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	
	
	@PostMapping  // In the recent versions of spring boot this RequestMapping is not supporting
	public String showHomePage2() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	*/
	
	
	
	
	/*@GetMapping("/")  
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	*/
	
	
	/*	@GetMapping("/")  
		public String showHomePage() {
			// return LVN (Logical View Name)
			System.out.println("WishMessageOperationsController.showHomePage()");
	//		return "forward:wish-controller/all";
			return "forward:test-controller/all";
		}*/
	
	
	
	@GetMapping("/")  
	public String showHomePage() {
		// return LVN (Logical View Name)
		System.out.println("WebApplication Name : "+sc.getContextPath());
		System.out.println("Web Application's Name : "+cg.getServletName());
		System.out.println("Session Id : "+ses.getId());
		System.out.println("WishMessageOperationsController.showHomePage()");
//		return "forward:wish-controller/all";
		return "welcome";   
	}
	
	
	
	/*
	@PostMapping("/") 
	public String showHomePage2() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	
	*/
	
	/*
	@RequestMapping("/wish")
	public ModelAndView fetchWishMessage() {
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		//keep results and other data as Model attributes in MAV Object
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("wMsg", msg); //attributeName, Values
		mav.addObject("sysDate", new Date()); // attributeName, Values
		mav.setViewName("show_result");
		
		//return mav
		return mav;
		// Working with ModelAndView as the return type of Handler method is bad practice and legacy style
		// ModelAndView is spring api specific class name, more over we need to create ModelaNdView class obj Manually
	}
	*/
	
	
	/*
	 * Actually to pass data from controller to view comp through DispatcherServlet it is recommended to use
	 * the shared memory given by DispatcherServlet and that shared memory is BindingAwareModelMap obj
	 */
	
	
	/* 
	 * Super class reference variable can refer to one of its subclass object
	 * similarly interface reference variable can refer to one of its impl class obj
	 */
	
	/*
	//Good to use
	@RequestMapping("/wish")
	public String fetchWishMessage(HashMap<String, Object> map) {
		System.out.println("Shared Memory location "+map.getClass());
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		
		return "show_result";
	}
	
	*/

	
	/*
	 * // Not Good to use because Model(I) makes the method invasive method-spring spring specific 
	 * @RequestMapping("/wish")
	public String fetchWishMessage(Model model) {
		System.out.println("Shared Memory location "+model.getClass());
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		model.addAttribute("wMsg", msg);
		model.addAttribute("sysDate", new Date());
		
		
		return "show_result";
	}
	*/
	
	
	/*
	 *   //Not Good because ModelMap(C) makes the method as invasive method-spring specific
	@RequestMapping("/wish")
	public String fetchWishMessage(ModelMap map) {
		System.out.println("Shared Memory location "+map.getClass());
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		
		return "show_result";
	}
	*/
	
	/*
	// (Best) (Good because Map(I) makes the method as non-invasive method-nonspring specific
	@RequestMapping("/wish")
	public String fetchWishMessage(Map<String, Object> map) {
		
		System.out.println("Shared Memory location "+map.getClass());
		
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		return "show_result";
	}
	*/
	
	/*
	// (Bad) there's view name so by default it takes request path
	@RequestMapping("/wish")
	public ModelMap fetchWishMessage() {
				
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		// Keep data in model attributes
		
		ModelMap map = new BindingAwareModelMap();
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		return map;
		// Here we are not returning logical view name so in that case by default it will take request path name as logical view name by excluding slash
	}*/
	
	
	
	/*
	 * If no logical view name is taken then the request path of the handler  method by excluding "/" becomes
	 * logical view name.....For example if the request path is "/wish"... the logical view name will be "wish"
	 * for this it internally uses RequestToViewNameTranslator comp.
	 */
	
	/*
	// Bad
	@RequestMapping("/wish")
	public Model fetchWishMessage() {
				
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		// Keep data in model attributes
		
		Model model = new BindingAwareModelMap();
		
		model.addAttribute("wMsg", msg);
		model.addAttribute("sysDate", new Date());
		
		return model;
	}
	*/
	
	/*
	@RequestMapping("/wish")
	public Map<String, Object> fetchWishMessage() {
				
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		// Keep data in model attributes
		
		Map<String, Object> map = new BindingAwareModelMap();
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		return map;
	}*/
	
	
	@RequestMapping("/wish")
	public void fetchWishMessage(Map<String, Object> map) {
		
		System.out.println("Shared Memory location "+map.getClass());
		
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
	}
	
	
	
	/*
	@RequestMapping("/wish")
	public String fetchWishMessage(Map<String, Object> map) {
		
		System.out.println("Shared Memory location "+map.getClass());
		
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		return null;
		
	}*/
	
		
	/*	@RequestMapping("/wish")
		public String fetchWishMessage(HttpServletResponse res) throws Exception {
			
			System.out.println("Shared Memory location "+res.getClass());
			
			//use Service
			String msg = service.generateWishMessage("Hemanth Kumar");
			
			PrintWriter pw = res.getWriter();
			
			pw.println("<b> Wish Message : "+msg+" </b><br><br>");
			pw.println("<b> Sys Date and Time : "+new Date()+" </b>");
			
			return null;
			
		}*/
	
	/*
	@RequestMapping("/report")
	public String showReport() throws Exception {
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	*/
	
	/*
	@RequestMapping("/REPORT")
	public String showReport1() throws Exception {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}
	*/
	/*
	@RequestMapping({"/report1", "/report2", "/report3"})
	public String showReport() throws Exception {
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	*/
	
	/*//	@RequestMapping(value= "/report", method=RequestMethod.GET)  
		// (OR)
		@GetMapping("/getreport")
		public String showReport() throws Exception {
			System.out.println("WishMessageOperationsController.showReport()");
			return "show_report";
		}*/
	
	
	/*//	@RequestMapping(value="/report", method=RequestMethod.POST)
		//(OR)
		@PostMapping("/postreport")
		public String showReport1() throws Exception {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "show_report1";
		}*/
	
	
	/*	
	//	@RequestMapping(value="/report", method=RequestMethod.POST)
		//(OR)
		@GetMapping("/getreport")
		public String showReport1() throws Exception {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "show_report1";
		}
		
		//Ambiguous mapping. Cannot map 'wishMessageOperationsController' method 
          com.org.controller.WishMessageOperationsController#showReport1()
		
		*/
		
		
		@GetMapping("/all")
		public String showData() throws Exception {
			System.out.println("WishMessageOperationsController.showData()");
			return "redirect:getreport"; // Directing to /show_report1 request path
		}
		
		
		@GetMapping("/getreport")
		public String showReport1() throws Exception {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "show_report1";
		}
	
	
}
