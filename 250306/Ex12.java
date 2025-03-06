import java.util.Scanner;

class Ex12{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 몇 단을 출력할까요? ");
		int dan= sc.nextInt();
		System.out.println("구구단"+ dan+"단 출력");
		for(int i=1; i<10; i++){
			int gu = dan*i;
			System.out.println(String.format("%d * %d = %d",dan,i,gu));
		}
	}
}