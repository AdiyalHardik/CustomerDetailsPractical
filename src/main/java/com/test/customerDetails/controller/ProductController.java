package com.test.customerDetails.controller;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.customerDetails.dto.ProductDTO;
import com.test.customerDetails.model.ProductMetaModel;
import com.test.customerDetails.reportsitory.ProductRepo;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@GetMapping(value = "/all")
	public Object allProdcuts() {
		try {
			return productRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed to fetch";
	}

	@GetMapping(value = "/insert")
	public Object insertProdcuts() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-Shopify-Access-Token", "a87522cc2e2551e43549aceb52e5d141");
			headers.add("Content-Type", "application/json");
			HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(URI.create(
					"https://e3519ce8d2b72750210800f3ba7115f2:a87522cc2e2551e43549aceb52e5d141@securecod4.myshopify.com/admin/api/2020-01/products.json"),
					HttpMethod.GET, entity, JSONObject.class);
			List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) responseEntity.getBody()
					.get("products");
			for (int i = 0; i < 6; i++) {
				ProductMetaModel metaModel = new ProductMetaModel();
				metaModel.setId(Long.valueOf(list.get(i).get("id").toString()));
				metaModel.setTitle(list.get(i).get("title").toString());
				metaModel.setVendor(list.get(i).get("vendor").toString());
				metaModel.setProduct_type((list.get(i).get("product_type")).toString());
				metaModel.setPublished_scope((list.get(i).get("published_scope")).toString());
				productRepo.save(metaModel);
			}

			return "Inserted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed to fetch";
	}

}
