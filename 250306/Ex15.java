class Ex15{
	public static void main(String[] args){
		System.out.println("Q1. A~Z까지 출력하시오.");
		int cnt = 'Z'-'A'+1; //아스키 코드로 직접 계산x
		for(int i=0; i<cnt; i++){
			System.out.print((char)('A'+i)+" ");
		} // 캐스팅 필요;
		System.out.println();
		System.out.println("--------------------------------");
		
		System.out.println("Q2. 다음을 출력하시오 A(a),B(b),C(c),....Y(y),Z(z)");
		for(char c=65; c<91; c++){
			int d = c+32;
			System.out.print(c+""+"(" +(char)d+") ");
		}
		System.out.println();
		System.out.println("--------------------------------");

		cnt = 'Z'-'A'+1;
		for(int i =0; i<cnt; i++){
			if(i!=0){
				System.out.print(' ');}
			System.out.print((char)('A'+i)+"("+((char)('a'+i))+")");
		}
		
		System.out.println();
		System.out.println("--------------------------------");

		int su='A';
		int gap = 'a' - 'A';
		while(su<='Z'){
			System.out.print((char)su+"("+(char)(gap+su++)+") ");
		}

		System.out.println();
		System.out.println("--------------------------------");
		
		System.out.println(" Q3. 다음을 출력하시오 ");
		// 1 2 3
		// 4 5 6
		// 7 8 9
		cnt=0;
		for(int i =0; i<9; i++){
			System.out.print(i+1);
			cnt++;
			if(cnt==3){
			System.out.println();
			cnt=0;
			}
		}
		System.out.println("--------------------------------");	
		
		for(int j=0; j<3; j++){
			for(int i =1; i<=3; i++){
				System.out.print(3*j+i);
			}
			System.out.println();
		}
		System.out.println("--------------------------------");	
				
		System.out.println("Q4. 다음을 출력하시오");
		// 1 2 3 
		// 2 3 4		
		// 3 4 5
		
		for(int j=0; j<3; j++){
			for(int i =1; i<=3; i++){
				System.out.print(j+i);
			}
			System.out.println();
		}		
		System.out.println("--------------------------------");

		System.out.println("Q5. 다음을 출력하시오.");
		// A B C
		// D E F
		// G H I
		for(int j=0; j<3; j++){
			for(int i =1; i<=3; i++){
				System.out.print((char)(3*j+i+64));
			}
			System.out.println();
		}

		System.out.println("--------------------------------");	
	}
}