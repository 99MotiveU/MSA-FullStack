package com.my.module;

import java.util.Arrays;

public class Module04 implements MyModule {
	String[] arr;
	
	public void setArr(String[] arr) {
		this.arr = arr;
	}

	@Override
	public void func01() {
		System.out.println(Arrays.toString(arr));
	}

}
