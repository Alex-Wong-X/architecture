package com.matrix.customer.mng.dao;

import org.springframework.stereotype.Repository;

import com.matrix.customer.mng.vo.CustomerModel;
import com.matrix.customer.mng.vo.CustomerQueryModel;
import com.matrix.dao.BaseDAO;

@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel>{
	public CustomerModel getByCustomerId(String customerId);
}
