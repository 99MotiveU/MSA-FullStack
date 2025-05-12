package com.pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Ex03m {
    public static void main(String[] args) {
    	//�л��������� ���α׷� (ver 0.20.0)
    	// 1.���� 2.�Է� 3.���� 4.���� 0.���� >
        Scanner sc = new Scanner(System.in);
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Properties props = new Properties();
        props.setProperty("user", "scott");
        props.setProperty("password", "tiger");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("�л��������� ���α׷� (ver 0.20.0)");
        boolean boo = true;
        while (boo) {
            System.out.print("0.���� 1.���� 2.�Է� 3.���� 4.���� > ");
            String choice = sc.nextLine();
            switch (choice) {
                case "0": //����
                    System.out.println("���α׷��� �����մϴ�.\t �̿����ּż� �����մϴ�.");
                    boo = false;
                    break;
                case "1": //����
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection(url, props);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM student_scores");

                        System.out.println("ID\t����\t����\t����\t����\t���");
                        while (rs.next()) {
                            System.out.print(rs.getInt("id") + "\t");
                            System.out.print(rs.getInt("kor") + "\t");
                            System.out.print(rs.getInt("eng") + "\t");
                            System.out.print(rs.getInt("math") + "\t");
                            System.out.print(rs.getInt("tot") + "\t");
                            System.out.println(rs.getDouble("avg"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                    	e.printStackTrace();
            		}finally {
                        try {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    
                case "2": //�Է�
                    System.out.println("�л� ������ �Է��ϼ���");
                    System.out.print("����> ");
                    int kor = sc.nextInt();
                    System.out.print("����> ");
                    int eng = sc.nextInt();
                    System.out.print("����> ");
                    int math = sc.nextInt();
                    int tot = kor + eng + math;
                    double avg = Math.round((tot / 3.0) * 100) / 100.0;
                    
                    try {
                        conn = DriverManager.getConnection(url, props);
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO student_scores (kor, eng, math, tot, avg) VALUES (" + kor + ", " + eng + ", " + math + ", " + tot + ", " + avg + ")";
                        stmt.execute(sql);
                        System.out.println("������ ����Ǿ����ϴ�.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    
                case "3": //����
                	
                	break;
                case "4": //����
                	
                	break;
                default:
                	System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�.");
            }
        }
    }
}
