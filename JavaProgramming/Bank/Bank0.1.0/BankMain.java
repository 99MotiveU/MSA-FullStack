import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean boo = true;
        String input = "";
        System.out.println("개인용 온라인뱅킹 프로그램");

        while (boo) {
            System.out.println("1.계좌 개설  2.잔액 확인 3.입금 4.출금  0.종료");
            System.out.print("선택 > ");
            input = sc.nextLine();
            char choice = input.charAt(0);
            switch (choice) {
                case '0': // 종료
                    System.out.println("이용해주셔서 감사합니다.\t프로그램이 종료 됩니다.");
                    boo = false;
                    sc.close();
                    break;
                case '1': // 계좌 개설
                	System.out.println("계좌를 개설합니다.");
                    Bank.createacc();
                    break;
                case '2': // 잔액 확인
                    Bank.checkBalance();
                    break;
                case '3': // 입금
                	Bank.deposit();
                	break;
                case '4': // 출금
                	Bank.withdraw();
                	break;
                default:
                    System.out.println("입력값이 잘못되었습니다.");
            }
        }
    }
}
