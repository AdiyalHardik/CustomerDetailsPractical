package com.test.customerDetails.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView insertCustomer(@ModelAttribute(name = "metaModel") CustomerDetailsMetaModel metaModel) {
		try {
			CustomerDetailsMetaModel model = new CustomerDetailsMetaModel();
			model.setName(metaModel.getName());
			model.setEmail(metaModel.getEmail());
			model.setGender(metaModel.getGender());
			model.setAdd1(metaModel.getAdd1());
			model.setAdd2(metaModel.getAdd2());
			model.setState(metaModel.getState());
			model.setZipCode(metaModel.getZipCode());
			model.setCity(metaModel.getCity());
			model.setMobile(metaModel.getMobile());
			model.setCountry(metaModel.getCountry());
			model.setToken(UUID.randomUUID().toString());
			customerRepo.save(model);
			return new ModelAndView("CstAdded");
		} catch (Exception e) {
			return new ModelAndView("Error");
		}
	}

	@PostMapping(value = "/update")
	public Object updateCustomer(@RequestBody CustomerDetailsMetaModel metaModel) {
		try {
			CustomerDetailsMetaModel model = customerRepo.findByToken(metaModel.getToken());
			model.setName(metaModel.getName());
			model.setEmail(metaModel.getEmail());
			model.setGender(metaModel.getGender());
			model.setAdd1(metaModel.getAdd1());
			model.setAdd2(metaModel.getAdd2());
			model.setState(metaModel.getState());
			model.setZipCode(metaModel.getZipCode());
			model.setCity(metaModel.getCity());
			model.setMobile(metaModel.getMobile());
			model.setCountry(metaModel.getCountry());
			model.setToken(UUID.randomUUID().toString());
			customerRepo.save(model);
			return "updated";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not updated";
	}

	@GetMapping(value = "/all")
	public ModelAndView allCustomer() {
		try {
			List<CustomerDetailsMetaModel> customerDetailsMetaModels = customerRepo.findAll();
			return new ModelAndView("viewCst").addObject("list", customerDetailsMetaModels);
//			return customerRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	@GetMapping(value = "/get")
	public Object getCustomer(String token) {
		try {
			return customerRepo.findByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not fetched";
	}

	@GetMapping(value = "/delete")
	public Object deleteCustomer(String token) {
		try {
			customerRepo.delete(customerRepo.findByToken(token));
			return "Deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not deleted";
	}

}

@Controller
class idnexClass {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexMethod() {
		return "index";
	}
}
