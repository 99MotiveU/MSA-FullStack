import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Bank {
	static Map<String, Account> accounts = new HashMap<>();
	Scanner sc;

	public Bank() {
		sc = new Scanner(System.in);
	}

	static class Account {
		String accnum; // 계좌번호
		String password; // 비밀번호
		int balance; // 잔액

		Account(String accnum, String password) {// for acc
			this.accnum = accnum;
			this.password = password;
			this.balance = 0;
		}
	}

//------ 메서드    

	static String createaccnum() { // 계좌번호 생성
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(ran.nextInt(9) + 1);
		for (int i = 1; i < 13; i++) {
			sb.append(ran.nextInt(10));
		}
		return sb.toString();
	} // createaccnum end

	public static void createacc() { // 계좌, 비밀번호
		Scanner sc = new Scanner(System.in);

		String accnum = createaccnum();
		System.out.print("계좌 비밀번호를 설정하세요: ");
		String password = sc.nextLine();

		Account newAccount = new Account(accnum, password);
		accounts.put(accnum, newAccount); // map에 추가

		System.out.println("계좌가 개설되었습니다. 계좌번호: " + accnum);
	} // createacc end

	public static boolean checkPassword(String accnum) {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌 비밀번호를 입력하세요: ");
		String inputPassword = sc.nextLine();

		Account account = accounts.get(accnum);
		return account != null && account.password.equals(inputPassword); // 비번 비교
	} // checkPassword end

	public static void checkBalance() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호를 입력하세요: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.println("계좌번호: " + accnum + " 의 현재 잔액: " + accounts.get(accnum).balance + "원");
				time();
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}

	}// checkBalance end

	public static void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호를 입력하세요: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.print("입금할 금액을 입력하세요 > ");
				int deposit = sc.nextInt();
				System.out.println(deposit + "원을 입금합니다.");
				accounts.get(accnum).balance = accounts.get(accnum).balance + deposit;
				System.out.println("계좌의 잔액은 " + accounts.get(accnum).balance + "원 입니다.");
				time();
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}
	} // deposit end

	public static void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호를 입력하세요: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.print("출금할 금액을 입력하세요 > ");
				int withdraw = sc.nextInt();
				if (accounts.get(accnum).balance < withdraw) {
					System.out.println("계좌 잔액이 부족하여 출금이 불가합니다.\t상위 메뉴도 돌아갑니다.");
				} else {
					System.out.println(withdraw + "원을 출금합니다.");
					accounts.get(accnum).balance = accounts.get(accnum).balance - withdraw;
					System.out.println("계좌의 잔액은 " + accounts.get(accnum).balance + "원 입니다.");
					time();
				}

			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}
	} // withdraw end

	public static void time() {
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 HH시 mm분 ss초"));
	}
} // bank end
