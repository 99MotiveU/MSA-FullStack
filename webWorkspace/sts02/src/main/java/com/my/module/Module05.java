package com.my.module;

import java.util.List;

public class Module05 implements MyModule {
	List list;
	
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public void func01() {
		System.out.println(list);
	}

}
