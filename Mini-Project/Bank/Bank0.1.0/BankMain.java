import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean boo = true;
        String input = "";
        System.out.println("���ο� �¶��ι�ŷ ���α׷�");

        while (boo) {
            System.out.println("1.���� ����  2.�ܾ� Ȯ�� 3.�Ա� 4.���  0.����");
            System.out.print("���� > ");
            input = sc.nextLine();
            char choice = input.charAt(0);
            switch (choice) {
                case '0': // ����
                    System.out.println("�̿����ּż� �����մϴ�.\t���α׷��� ���� �˴ϴ�.");
                    boo = false;
                    sc.close();
                    break;
                case '1': // ���� ����
                	System.out.println("���¸� �����մϴ�.");
                   	Bank.createacc();
                    	break;
                case '2': // �ܾ� Ȯ��
			Bank.checkBalance();
                 	break;
                case '3': // �Ա�
                	Bank.deposit();
                	break;
                case '4': // ���
                	Bank.withdraw();
                	break;
                default:
                    System.out.println("�Է°��� �߸��Ǿ����ϴ�.");
            }
        }
    }
}
