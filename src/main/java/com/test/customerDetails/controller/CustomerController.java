package com.test.customerDetails.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.customerDetails.model.CustomerDetailsMetaModel;
import com.test.customerDetails.reportsitory.CustomersRepo;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	CustomersRepo customerRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ModelAndView insertCustomer(@ModelAttribute(name = "metaModel") CustomerDetailsMetaModel metaModel) {
		try {
			metaModel.setToken(UUID.randomUUID().toString());
			customerRepo.save(metaModel);
			return new ModelAndView("CstAdded").addObject("message", "Customer Data Added...");
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

	@PostMapping(value = "/update")
	public ModelAndView updateCustomer(@ModelAttribute(name = "metaModel") CustomerDetailsMetaModel metaModel) {
		try {
			CustomerDetailsMetaModel model = customerRepo.findByToken(metaModel.getToken());
			customerRepo.delete(model);
			customerRepo.save(metaModel);
			return new ModelAndView("CstAdded").addObject("message", "Customer Data Updated...");
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

	@GetMapping(value = "/all")
	public ModelAndView allCustomer() {
		try {
			List<CustomerDetailsMetaModel> customerDetailsMetaModels = customerRepo.findAll();
			return new ModelAndView("ViewCst").addObject("list", customerDetailsMetaModels);
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

	@GetMapping(value = "/get/{token}")
	public ModelAndView getCustomer(@PathVariable("token") String token) {
		try {
			CustomerDetailsMetaModel customerDetailsMetaModel = customerRepo.findByToken(token);
			ModelAndView andView = new ModelAndView("EditCst");
			andView.addObject("metaModel", customerDetailsMetaModel);
			return andView;
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

	@GetMapping(value = "/delete")
	public ModelAndView deleteCustomer(String token) {
		try {
			customerRepo.delete(customerRepo.findByToken(token));
			return new ModelAndView("DeleteCst");
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

}

@Controller
class idnexClass {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexMethod() {
		return "index";
	}
}
