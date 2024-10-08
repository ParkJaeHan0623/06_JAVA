package kr.parkjaehan.jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import kr.parkjaehan.helper.DBHelper;

public class Ex06_SelectEx {
    public static void main(String[] args) {
        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";

        Statement stmt = null;
        
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                System.out.printf("학과번호 : %d\n", deptno);
                System.out.printf("학과이름 : %s\n", dname);
                System.out.printf("학과위치 : %s\n", loc);
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
