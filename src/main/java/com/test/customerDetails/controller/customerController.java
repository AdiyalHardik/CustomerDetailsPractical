package com.test.customerDetails.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.customerDetails.model.CustomerDetailsMetaModel;
import com.test.customerDetails.reportsitory.CustomersRepo;

@RestController
@RequestMapping(value = "/customers")
public class customerController {

	@Autowired
	CustomersRepo customerRepo;

	@PostMapping(value = "/insert")
	public Object insertCustomer(@RequestBody CustomerDetailsMetaModel metaModel) {
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
			return "inserted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not inserted";
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
	public Object allCustomer() {
		try {
			return customerRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Not fetched";
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
