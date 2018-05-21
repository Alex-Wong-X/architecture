package com.matrix.dao;

import java.util.List;

public interface BaseDAO<M, QM> {
	void create(M cm);

	void update(M cm);

	void delete(int uuid);

	M getByUuid(int uuid);

	List<M> getByConditionPage(QM cqm);
}
