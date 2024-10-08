package kr.parkjaehan.jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import kr.parkjaehan.helper.DBHelper;

public class Ex07_CountEx {
    public static void main(String[] args) {
        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT COUNT(*) AS `cnt` FROM student WHERE grade = 4";

        Statement stmt = null;
        
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            boolean first =  rs.next();

            if (first) {
                int count = rs.getInt("cnt");
                System.out.printf("4학년 학생 수 : %d\n", count);
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
