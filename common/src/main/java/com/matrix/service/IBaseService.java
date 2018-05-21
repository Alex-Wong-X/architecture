package com.matrix.service;

import com.matrix.pageUtil.Page;
import com.matrix.vo.BaseModel;

public interface IBaseService<M, QM extends BaseModel> {
	void create(M cm);

	void update(M cm);

	void delete(int uuid);

	M getByUuid(int uuid);

	Page<M> getByConditionPage(QM cqm);
}
