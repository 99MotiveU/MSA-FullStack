package com.my.service;

import com.my.module.Module10;
import com.my.module.MyModule2;

public class Service02 {
//	Module10 module=new Module10();
	MyModule2 module;
	
	public void setModule(MyModule2 module) {
		this.module = module;
	}

	public void exec() {
		module.func01();	
		module.func02(1234);
		String msg=module.func03();
		System.out.println("f3 result:"+msg);
		try {
			module.func04();
		}catch (Exception e) {
			System.out.println("exception ¹ß»ý");
		}
	}
}




