package com.test.customerDetails.reportsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.customerDetails.model.ProductMetaModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductMetaModel, Integer> {

}
