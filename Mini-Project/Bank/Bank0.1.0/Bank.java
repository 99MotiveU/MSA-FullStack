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
		String accnum; // ���¹�ȣ
		String password; // ��й�ȣ
		int balance; // �ܾ�

		Account(String accnum, String password) {// for acc
			this.accnum = accnum;
			this.password = password;
			this.balance = 0;
		}
	}

//------ �޼���    

	static String createaccnum() { // ���¹�ȣ ����
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(ran.nextInt(9) + 1);
		for (int i = 1; i < 13; i++) {
			sb.append(ran.nextInt(10));
		}
		return sb.toString();
	} // createaccnum end

	public static void createacc() { // ����, ��й�ȣ
		Scanner sc = new Scanner(System.in);

		String accnum = createaccnum();
		System.out.print("���� ��й�ȣ�� �����ϼ���: ");
		String password = sc.nextLine();

		Account newAccount = new Account(accnum, password);
		accounts.put(accnum, newAccount); // map�� �߰�

		System.out.println("���°� �����Ǿ����ϴ�. ���¹�ȣ: " + accnum);
	} // createacc end

	public static boolean checkPassword(String accnum) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ��й�ȣ�� �Է��ϼ���: ");
		String inputPassword = sc.nextLine();

		Account account = accounts.get(accnum);
		return account != null && account.password.equals(inputPassword); // ��� ��
	} // checkPassword end

	public static void checkBalance() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���¹�ȣ�� �Է��ϼ���: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.println("���¹�ȣ: " + accnum + " �� ���� �ܾ�: " + accounts.get(accnum).balance + "��");
				time();
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		} else {
			System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
		}

	}// checkBalance end

	public static void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���¹�ȣ�� �Է��ϼ���: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.print("�Ա��� �ݾ��� �Է��ϼ��� > ");
				int deposit = sc.nextInt();
				System.out.println(deposit + "���� �Ա��մϴ�.");
				accounts.get(accnum).balance = accounts.get(accnum).balance + deposit;
				System.out.println("������ �ܾ��� " + accounts.get(accnum).balance + "�� �Դϴ�.");
				time();
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		} else {
			System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
		}
	} // deposit end

	public static void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���¹�ȣ�� �Է��ϼ���: ");
		String accnum = sc.nextLine();

		if (accounts.containsKey(accnum)) {
			if (checkPassword(accnum)) {
				System.out.print("����� �ݾ��� �Է��ϼ��� > ");
				int withdraw = sc.nextInt();
				if (accounts.get(accnum).balance < withdraw) {
					System.out.println("���� �ܾ��� �����Ͽ� ����� �Ұ��մϴ�.\t���� �޴��� ���ư��ϴ�.");
				} else {
					System.out.println(withdraw + "���� ����մϴ�.");
					accounts.get(accnum).balance = accounts.get(accnum).balance - withdraw;
					System.out.println("������ �ܾ��� " + accounts.get(accnum).balance + "�� �Դϴ�.");
					time();
				}

			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		} else {
			System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
		}
	} // withdraw end

	public static void time() {
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy�� mm�� dd�� HH�� mm�� ss��"));
	}
} // bank end
