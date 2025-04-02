import java.util.Scanner;





public class RspGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Q03. 가위 바위 보 게임(ver 0.1.0)
		System.out.println("---------------------------\\n가위 바위 보 게임ver 0.1.0\\n---------------------------");
		// String menu = "가위(1),바위(2),보(3),종료(0)> ";
		int wcount = 0, ccount = 0, lcount = 0;
		while (true) {
			System.out.print("가위(1),바위(2),보(3),종료(0)> "); // menu
			int g = sc.nextInt();
			int c = (int) ((Math.random() * 3) + 1); // 랜덤 1,2,3 뽑기
			// 사람(입력)
			if (g == 1) {
				System.out.println("당신은 가위");
			} else if (g == 2) {
				System.out.println("당신은 바위");
			} else if (g == 3) {
				System.out.println("당신은 보");
			} else if (g == 0) { 
			// 1,2,3 이외에는 모두 종료로 설정 || switch-case+예외처리로 가능할듯
				System.out.println("누적 승률");
				System.out.println(String.format("%d승 %d무 %d패", wcount, ccount, lcount));
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			} else {
				System.out.println("1,2,3,0 이외의 숫자를 입력하여 프로그램이 종료됩니다.");
				System.out.print("누적 승률 : " + String.format("%d승 %d무 %d패 ", wcount, ccount, lcount));
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}
			// 컴퓨터
			if (c == 1) {System.out.println("컴퓨터는 가위");}
			if (c == 2) {System.out.println("컴퓨터는 바위");}
			if (c == 3) {System.out.println("컴퓨터는 보");}
			// 비교
			if (g == 1 && c == 3 || g == 2 && c == 1 || g == 3 && c == 2) {
				System.out.println("이겼습니다.");
				wcount++;
			} else if (g == 1 && c == 2 || g == 2 && c == 3 || g == 3 && c == 1) {
				System.out.println("졌습니다.");
				lcount++;
			} else {
				System.out.println("비겼습니다.");
				ccount++;
			}
			System.out.println(); // 다음 반복 console 구분
		}
		sc.close();
	}
} //메서드화 해보기