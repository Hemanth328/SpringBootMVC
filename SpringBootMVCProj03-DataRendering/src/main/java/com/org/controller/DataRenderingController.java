package com.org.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.org.model.Product;

@Controller
public class DataRenderingController {
	
	@GetMapping("/")
	public String welcomepage() {
		return "welcome";
	}
	
	@GetMapping("/getData")
	public String showData(Map<String, Object> map) {
		
		map.put("Name", "Hemanth");
		map.put("Age", 25);
		map.put("Address", "Vskp");
		
		return "show_data";
	}
	
	@GetMapping("/detailslist")
	public String listOfDetails(Map<String, Object> map) {
		// add simple values as the model attributes (Generally these values are not hardcoded)
		// static values - these values will come from DB s/w through DAO & Service Class
		
		map.put("favColors", new String[] {"Black", "White", "Blue", "Red", "Yellow", "Green"});
		map.put("nickNames", List.of("Hemanth", "Chinni", "Dady", "Jagadeesh"));
		map.put("phoneNumbers", Set.of(999999999L, 888888888L, 777777777L, 666666666L, 55555555L));
		map.put("idDetails", Map.of("aadhar", 45465897L, "voterId", 123456, "panNo", "HGJSH456JH"));
		
		return "details_list";
	}
	
	@GetMapping("/proddata")
	public String showProductID(Map<String, Object> map) {
		// Create Model class obj having data (Generally this object comes from DAO, Service classes
		// having DB Table record
		
		Product prob = new Product(001245, "Recliner", 62499.0, 1.0);
		
		// make model class obj as the model attribute
		map.put("prodData", prob);
		
		return "prod_page";
	}
	
	@GetMapping("/productslist")
	public String showProductData(Map<String, Object> map) {
		// create List of Model class objs as the model attribute
		
		List<Product> list = List.of(new Product(1243, "Sofa", 5689756.56, 2.0),
				                     new Product(4689, "Recliners", 864896.21, 2.0));
		
		map.put("prodList", list);
		
		return "prod_list";
	}

}
