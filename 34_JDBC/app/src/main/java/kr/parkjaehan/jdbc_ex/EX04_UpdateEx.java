package kr.parkjaehan.jdbc_ex;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import kr.parkjaehan.helper.DBHelper;

public class EX04_UpdateEx {
    public static void main(String[] args) {
        Connection conn = DBHelper.getInstance().open();

        String sql = "UPDATE department SET dname = 'hello', loc = 'world' WHERE deptno >=203";

        Statement stmt = null;
        int result = 0;

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
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

        System.out.println(result + "개의 행이 수정되었습니다.");
        DBHelper.getInstance().close();
    }
}
