class Ex14{
	public static void main(String[] args){
		System.out.println("Q1. 1~20까지 중 홀수를 출력하시오.");
		for(int i=1; i<20; i++){
			if(i%2==1){
				System.out.print(i+" ");	
			}
		}
//		for(int i=1; i<20; i+=2){
//			System.out.print(i+" ");
//		}

//		int su=1;
//		boolean boo=true;
//		while(true&&boo){
//			if(su%2!=0){System.out.print(su+" ");}
//			su++;
//			if(su>=20){boo=false;}
//		}  //이걸 좀 더 익혀 (효율 // 사이즈가 커졌을때 수정용이)
		System.out.println();
		System.out.println("-----------------------------------------------");
		
//		
		System.out.println("Q2. 1~50중 5의 배수만을 출력하시오.");
		for(int i=1; i<51; i++){
			if(i%5==0){
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("-----------------------------------------------");

//		int su=1;
//		boolean boo=true;
//		while(true&&boo){
//			if(true){System.out.print(5*su+" ");}
//			su++;
//			if(5*su>50){boo=false;}
//		}  //while 사용 동일. 실용적;;;
		


//		
		System.out.println("Q3. 1~50의 합계를 구하시오.");
		int sum1 = 0;
		for(int i=1; i<51; i++){
			sum1 +=i;
		}
		System.out.println("1~50의 합은 = " + sum1);

//		su=1;
//		boo=true;
//		temp=0;
//		while(true&&boo){
//			if(su==50){boo=false;}
//			temp=temp+su;
//			su++;
//		}
//		System.out.println("sum="+tmep);
		System.out.println("-----------------------------------------------");
//
		System.out.println("Q4. 다음을 출력하시오.  2+4+6+8+10=???");
		int sum2 =0;
		for(int i=2; i<9; i++){
			if(i%2==0){
				System.out.print(i+"+");
			}
		}
		System.out.println(10+"=???");

//		for(int i=2; i<=10;i+=2){
//			if(i!=2){
//				System.out.print('+');
//				System.out.print(i);
//				sum+=i;
//			}
//		}
//		System.out.println("= "+sum);

		System.out.println("-----------------------------------------------");
		
		System.out.println("Q5. 구구단을 출력하시오. 포멧은 그림대로");
		int i, j =0;
		int mul=0;
		for(i=1;i<10;i++){
			System.out.print("   "+i+"단       ");
		}
		System.out.println();
		for(i=1;i<10;i++){
			for(j=1; j<10;j++){
				mul =i*j;
				System.out.print(String.format("%d x %d = %d   ", j,i,mul));
				if(mul<10){
					System.out.print(" ");
				}
			}
			System.out.println();
		}				
	}
}