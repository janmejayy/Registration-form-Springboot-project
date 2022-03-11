package com.example.submissionform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@Autowired
	CustomerRepo repo;
	@RequestMapping("/")
	public String details()  {
		return "submission";
	}
	@RequestMapping("/details")
	public String details(Customer customer){
		repo.save(customer);
		return "submission";
	}
	@RequestMapping("/getdetails")
	public String getdetails()  {
		return "ViewCustomer";
	}

@PostMapping("/getdetails")
public ModelAndView viewdetails(@RequestParam int cid)
{
	 ModelAndView mv=new ModelAndView("Retrieve");
     Customer customer=repo.findById(cid).orElse(null);
	 mv.addObject(customer);
	 return mv;
}
}