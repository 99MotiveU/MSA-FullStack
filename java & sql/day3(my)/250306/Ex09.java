class Ex09{

	public static void main(String[] args){
	
		if(true){
			System.out.println("실행1....");
			System.out.println("실행2....");
		}
		
		if(false){
			System.out.println("실행1....");
			System.out.println("실행2....");
		}
		System.out.println("false - after...");	

		System.out.println();	
		int su = 2;
		System.out.println(String.format("su = %d",su));

		if(su<0){
			System.out.println("음수");
		} else {
			System.out.println("양수");
		}
		System.out.println();
//if문만 사용
		System.out.println("if문만 사용");
		if(su<0){
			System.out.println("음수");
		} 
		if(!(su<0)){
			System.out.println("양수");
		}

		System.out.println();
		System.out.println("else if문");
		if(su<0){
			System.out.print("음수");
		} else if(su >0){
			System.out.print("양수");
		} else if(su==0){
			System.out.print("양수");
		}
		System.out.println("입니다");
				
	}
}