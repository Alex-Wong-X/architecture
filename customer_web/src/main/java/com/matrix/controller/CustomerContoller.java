package com.matrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matrix.customer.mng.service.ICustomerService;
import com.matrix.customer.mng.vo.CustomerModel;
import com.matrix.customer.mng.vo.CustomerQueryModel;
import com.matrix.pageUtil.Page;
import com.matrix.util.format.DateFormatHelper;
import com.matrix.util.json.JsonHelper;
import com.matrix.web.model.CustomerWebModel;

@Controller
@RequestMapping(value = "/customer")
public class CustomerContoller {
	@Autowired
	private ICustomerService service = null;

	@RequestMapping(value = "toAdd")
	public String toAdd() {
		return "customer/add";
	}

	@RequestMapping(value = "add")
	public String add(@ModelAttribute CustomerModel cm) {
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		service.create(cm);
		return "customer/success";
	}

	@RequestMapping(value = "toUpdate/{customerUuid}")
	public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = service.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/update";
	}

	@RequestMapping(value = "update")
	public String post(@ModelAttribute("cm") CustomerModel cm) {
		service.update(cm);
		return "customer/success";
	}

	@RequestMapping(value = "toDelete/{customerUuid}")
	public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = service.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/delete";
	}

	@RequestMapping(value = "delete")
	public String post(@RequestParam("uuid") int customerUuid) {
		service.delete(customerUuid);
		return "customer/success";
	}
	@RequestMapping(value="toList")
	public String toList(@ModelAttribute("wm")CustomerWebModel wm,Model model){
		System.out.println(wm);
		CustomerQueryModel cqm = null;
		if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0){
			cqm = new CustomerQueryModel();
		}else{
			cqm = (CustomerQueryModel)JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
		}
		cqm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			cqm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page<CustomerModel> dbPage = service.getByConditionPage(cqm);
		
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "customer/list";
	}
	@RequestMapping(value="toQuery")
	public String toQuery(){
		return "customer/query";
	}
}
