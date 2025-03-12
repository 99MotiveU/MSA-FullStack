class Ex09{

public static void main(String[] args){
//제어문
// 1.조건문
// 1-1. if문
//	if(조건){실행문들;}
//
//	만약 조건이 참이라면 실행문실행
//	아니면 {}무시
System.out.println("before...");
int su=5;
if(su>3){
	System.out.println("실행1...");
	System.out.println("실행2...");
}
System.out.println("after...");

// else
// if(조건){실행문;}else{실행문;}
// 단독사용불가
// 중복사용불가
// 실행을 보장
System.out.println("------------");
if(su<0){
	System.out.println("음수");
}else{
	System.out.println("양수");
}
// else if
// if(조건){실행문;}
// else if(조건){실행문;}
// else if(조건){실행문;}
// ...
// 단독사용불가
// 중복사용가능
su=0;
System.out.println("------------");
if(su<0){
	System.out.print("음수");
}else if(su>0){
	System.out.print("양수");
}else{
	System.out.print("영");
}
System.out.println("입니다");


}







}