class Ex03{
	public static void main(String[] args){
		System.out.println('a');
		System.out.println('\uac00');
		char ch = '\uac01';
		char ch1 = '\\';
		char ch2 = '/';
		char ch3 = 65;
		System.out.println(ch);
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);

		System.out.println(ch1+ch3);
	//	System.out.println("문자열");
	//	System.out.println("문자");
		System.out.println("");
		System.out.println("문자"+"열");
	//	System.out.println("문자열"+3.14);
	//	System.out.println(6+2);
		String msg;
		msg = "문자열";
		System.out.println(msg);
		System.out.println(2024+1+"년");
		System.out.println("year"+2024+1);
		System.out.println(5+1);
		System.out.println('5'+1);
		System.out.println("-------------------------------");
		System.out.println("ABCD\tabcd");
		System.out.println("ABCD\babcd");
		System.out.println("ABCD\\abcd");
		System.out.println("ABCD\babcd");
		System.out.println("http:\\\\www.naver.com");
		System.out.println("ABCD\"ab\"cd");
		//System.out.println("ABCD\nabcd");
		System.out.println("ABCD\nabcd");
		System.out.println("ABCD\r\nabcd"); // 위의 \n말고 이걸로 하셈;
		System.out.println("ABCD\u0009abcd");
		int su1 = 0xac00, su2 = 010;
		System.out.println("16진수 ac00 = "+ su1);
		System.out.println("8진수 010 = " + su2);
		}
}