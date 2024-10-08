package kr.parkjaehan.jdbc_ex;

import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.parkjaehan.helper.DBHelper;

public class Ex08_SearchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("아이디를 입력하세요: ");
        String userId = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String idnum = scanner.nextLine();

        scanner.close();

        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT studno, s.name, grade, birthdate, tel, height, weight, dname, p.name "
        + "FROM student s "
        + "INNER JOIN department d ON s.deptno = d.deptno "
        + "INNER JOIN professor p ON s.profno = p.profno "
        + "WHERE s.userid = '" + userId + "' AND idnum='" + idnum + "'";

        Statement stmt = null;

        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                int studno = rs.getInt("studno");
                String name = rs.getString("name");
                int grade = rs.getInt("grade");
                String birthdate = rs.getString("birthdate");
                String tel = rs.getString("tel");
                int height = rs.getInt("height");
                int weight = rs.getInt("weight");
                String dname = rs.getString("dname");
                String profName = rs.getString("p.name");

                System.out.printf("학번 : %d\n", studno);
                System.out.printf("이름 : %s\n", name);
                System.out.printf("학년 : %d\n", grade);
                System.out.printf("생년월일 : %s\n", birthdate);
                System.out.printf("전화번호 : %s\n", tel);
                System.out.printf("키 : %d\n", height);
                System.out.printf("몸무게 : %d\n", weight);
                System.out.printf("학과 : %s\n", dname);
                System.out.printf("지도교수 : %s\n", profName);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("=================SQL Fail=================");
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

        DBHelper.getInstance().close();
    }
}
