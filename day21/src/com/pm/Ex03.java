package com.pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) throws Exception {
		// 학생성적관리 프로그램(ver 0.20.0)
		/*
		 * 1.보기 2.입력 3.수정 4.삭제 0.종료>
		 */
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Properties props = new Properties();
		props.setProperty("user", "scott");
		props.setProperty("password", "tiger");

		Connection conn = null;
		Statement stmt = null;
		java.sql.ResultSet rs = null;

		int kor = 0;
		int eng = 0;
		int math = 0;
		int tot = kor + eng + math;
		double avg = Math.round(tot/3.0*100)/100;
		System.out.println("학생성적관리 프로그램 (ver 0.20.0)");
		int choice = -1;
		boolean boo = true;
		while (boo) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			choice = sc.nextInt();
			switch (choice) {
			case 0: // 종료
				System.out.println("프로그램을 종료합니다. \t 이용해주셔서 감사합니다.");
				boo = false;
				sc.close();
				break;
			case 1: // 보기

				break;
			case 2: // 입력
				System.out.println("학생 성적을 입력하세요");
				System.out.print("국어> ");
				kor = sc.nextInt();
				System.out.print("영어> ");
				eng = sc.nextInt();
				System.out.print("수학> ");
				math =sc.nextInt();	
				

				String sql = "";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, props);
					stmt = conn.createStatement();

					while (rs.next()) {
						System.out.print(rs.getObject(1) + "\t");
						System.out.print(rs.getObject(2) + "\t");
						System.out.println(rs.getObject(3));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				break;
			case 3: // 수정
				break;
			case 4: // 삭제
				break;
			}
		}

	}

}
