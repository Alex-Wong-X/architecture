package com.customer.mng;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.matrix.customer.mng.dao.CustomerDAO;
import com.matrix.customer.mng.service.ICustomerService;
import com.matrix.customer.mng.vo.CustomerModel;
import com.matrix.customer.mng.vo.CustomerQueryModel;
import com.matrix.pageUtil.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis.cfg.xml" })
public class AppTest {
	@Autowired
	private ICustomerService service = null;

	//@Test
	public void create() {
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c1");
		cm.setPwd("123");
		cm.setRegisterTime("2018-01-01");
		cm.setShowName("c1");
		cm.setTrueName("张三");
		service.create(cm);
	}


	@Test
	public void getByCondition() {
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setNowPage(1);
		Page<CustomerModel> page = service.getByConditionPage(cqm);
		System.out.println(page);
	}

}
