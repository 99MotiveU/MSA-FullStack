package com.pm;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Properties props = new Properties();
        props.setProperty("user", "scott");
        props.setProperty("password", "tiger");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("학생성적관리 프로그램 (ver 0.20.0)");
        boolean boo = true;
        while (boo) {
            System.out.print("1.보기 2.입력 0.종료> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                    boo = false;
                    break;
                case 1:
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection(url, props);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM student_scores");

                        System.out.println("ID\t국어\t영어\t수학\t총점\t평균");
                        while (rs.next()) {
                            System.out.print(rs.getInt("id") + "\t");
                            System.out.print(rs.getInt("kor") + "\t");
                            System.out.print(rs.getInt("eng") + "\t");
                            System.out.print(rs.getInt("math") + "\t");
                            System.out.print(rs.getInt("tot") + "\t");
                            System.out.println(rs.getDouble("avg"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    System.out.println("학생 성적을 입력하세요");
                    System.out.print("국어> ");
                    int kor = sc.nextInt();
                    System.out.print("영어> ");
                    int eng = sc.nextInt();
                    System.out.print("수학> ");
                    int math = sc.nextInt();

                    int tot = kor + eng + math;
                    double avg = Math.round((tot / 3.0) * 100) / 100.0;

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection(url, props);
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO student_scores (kor, eng, math, tot, avg) VALUES (" + kor + ", " + eng + ", " + math + ", " + tot + ", " + avg + ")";
                        stmt.executeUpdate(sql);
                        System.out.println("성적이 저장되었습니다.");
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
            }
        }
        sc.close();
    }
}
