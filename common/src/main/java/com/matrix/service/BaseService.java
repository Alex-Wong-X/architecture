package com.matrix.service;

import java.util.List;

import com.matrix.dao.BaseDAO;
import com.matrix.pageUtil.Page;
import com.matrix.vo.BaseModel;

public class BaseService<M,QM extends BaseModel> implements IBaseService<M, QM> {
	private BaseDAO<M,QM> dao = null;
	
	public void setDAO(BaseDAO<M,QM> dao){
		this.dao = dao;
	}

	@Override
	public void create(M cm) {
		dao.create(cm);
	}

	@Override
	public void update(M cm) {
		dao.update(cm);
	}

	@Override
	public void delete(int uuid) {
		dao.delete(uuid);
	}

	@Override
	public M getByUuid(int uuid) {
		return (M)dao.getByUuid(uuid);
	}

	@Override
	public Page<M> getByConditionPage(QM cqm) {
		List<M> list = dao.getByConditionPage(cqm);
		cqm.getPage().setResult(list);
		return cqm.getPage();
	}

}
