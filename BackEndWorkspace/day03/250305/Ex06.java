class Ex06{
	public static void main(String[] args){
		int a =1;
		double b = 3.14;
		char ch ='@';
		boolean boo = true;
		System.out.println("default 정수타입 : "+ a);
		System.out.println("default 실수타입 : "+ b);
		System.out.println("default 문자타입 : "+ ch);
		System.out.println("default 불린타입 : "+ boo);

		System.out.println();
		System.out.println("10진수 정수");
		byte e,x;
		e=127;
		short f =129;
		x=(byte)f;
		long g =f;
		System.out.println("10진수 실수");
		float h = 3.14f;   //  실수 기본은 double이라 f써주기
		System.out.println("128->"+x);
		System.out.println((long)3.14);
		System.out.println((int)2147483647L);
		System.out.println((int)2147483648L);
		System.out.println((long)2147483647);
		
		System.out.println((char)65);
		System.out.println((int)'a');
		int su1 = 65;
		char ch2 = 'a';
		ch2=ch2;
		System.out.println(ch2);


		}

}