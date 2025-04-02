package com.am;

abstract class Ab06{
	abstract void show();
}
interface Inter06{}

public class Ex06 {

	public static void main(String[] args) {
		Object obj=new Object() {
			@Override
			public String toString() {
				return "object를 상속받은 이름없는 클래스";
			}
		};

		System.out.println(obj);
		
//		Ab06 obj2=new Ab06() {};
		Inter06 obj3=new Inter06() {};
		
		Ab06[] arr1= {
				new Ab06() {
					int su1=1111;
				@Override
					void show() {
						System.out.println("su1="+su1);
					}	
				}
				,new Ab06() {
					int su2=2222;
				@Override
					void show() {
						System.out.println("su2="+su2);
					}	
				}
		};
		for(int i=0; i<arr1.length; i++) {
			arr1[i].show();
		}
	}
}