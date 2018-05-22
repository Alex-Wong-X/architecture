package com.matrix.customer.mng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.customer.mng.dao.CustomerDAO;
import com.matrix.customer.mng.vo.CustomerModel;
import com.matrix.customer.mng.vo.CustomerQueryModel;
import com.matrix.service.BaseService;
@Service
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService {
	private CustomerDAO dao = null;

	@Autowired
	private void setDao(CustomerDAO dao) {
		this.dao = dao;
		super.setDAO(dao);
	}

	@Override
	public CustomerModel getByCustomerId(String customerId) {
		
		return dao.getByCustomerId(customerId);
	}
}
