package com.matrix.vo;

import com.matrix.pageUtil.Page;

public class BaseModel {
	private Integer uuid;
	private Page page = new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

}
