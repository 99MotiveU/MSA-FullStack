package com.am;

class MyArray{
	Object[] arr=new Object[0];
	
	void add(Object su) {
		Object[] before=arr;
		arr=new Object[arr.length+1];
		for(int i=0; i<before.length; i++) {
			arr[i]=before[i];
		}
		arr[arr.length-1]=su;
	}//add end
	
	int size() {
		return arr.length;
	}//size end
	
	Object get(int idx) {
		return arr[idx];
	}//get end
	
	void remove(int idx) {
		Object[] before=arr;
		arr=new Object[before.length-1];
		for(int i=0; i<idx; i++) {
			arr[i]=before[i];
		}
		for(int i=idx+1; i<before.length; i++) {
			arr[i-1]=before[i];
		}
	}//remove end
	
	void set(int idx,Object val) {
		arr[idx]=val;
	}//set end
	
}//MyArray end

public class Ex03 {

	public static void main(String[] args) {
		MyArray arr=new MyArray();
		arr.add(1111);
		arr.add(2222);
		arr.add(3333);
		arr.add(4444);
		arr.add(5555);
		arr.add(6666);
		arr.add(7777);
		arr.add(8888);
		
		arr.remove(7);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}//main end

}//end
















