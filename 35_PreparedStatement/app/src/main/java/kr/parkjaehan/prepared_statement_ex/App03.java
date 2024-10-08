package kr.parkjaehan.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.parkjaehan.helper.DBHelper;

public class App03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("교수 이름: ");
        String pname = scanner.nextLine();

        scanner.close();

        String sql = "SELECT profno, name, userid, position, sal, hiredate, comm, deptno "
                + "FROM professor "
                + "WHERE name LIKE concat('%', ? , '%')";

        Connection conn = DBHelper.getInstance().open();

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pname);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int profno = rs.getInt("profno");
                String name = rs.getString("name");
                String userid = rs.getString("userid");
                String position = rs.getString("position");
                int sal = rs.getInt("sal");
                String hiredate = rs.getString("hiredate");
                int comm = rs.getInt("comm");
                int deptno = rs.getInt("deptno");

                System.out.println("교수번호: " + profno);
                System.out.println("교수이름: " + name);
                System.out.println("교수아이디: " + userid);
                System.out.println("직급: " + position);
                System.out.println("급여: " + sal);
                System.out.println("입사일: " + hiredate);
                System.out.println("커미션: " + comm);
                System.out.println("학과번호: " + deptno);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
        }

        DBHelper.getInstance().close();
    }
}
