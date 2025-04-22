class Ex11{

public static void main(String[] args){
// 반복문
// 1.for문
// ①for(초기화②;조건③;증감④){실행문⑤;}⑥
// ①->②->③(true)->⑤->④->③(true)->⑤->④->③(false)->⑥
int i;
for(i=0; i>10; i+=2){
	System.out.println("출력"+i);
}
System.out.println(i);
}

}