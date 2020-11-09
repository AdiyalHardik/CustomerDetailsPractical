package com.test.customerDetails.reportsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.customerDetails.model.CustomerDetailsMetaModel;

@Repository
public interface CustomersRepo extends JpaRepository<CustomerDetailsMetaModel, Integer> {

	CustomerDetailsMetaModel findByToken(String token);
}
