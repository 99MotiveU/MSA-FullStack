package com.my.service;

import com.my.module.*;
import com.my.module.MyModule;

public class Service01 {
	MyModule module;
	
	public Service01() {
	}
	
	// DI-의존성 주입 (생성자 주입)
	public Service01(MyModule module) {
		super();
		this.module = module;
	}


	// DI-의존성 주입 (setter)
	public void setModule(MyModule module) {
		this.module = module;
	}

	public void serv01() {
		module.func01();
				
	}
	// IoC 제어의 역전
	public void serv01(MyModule my) {
		MyModule module=my;
		module.func01();
	}
}
