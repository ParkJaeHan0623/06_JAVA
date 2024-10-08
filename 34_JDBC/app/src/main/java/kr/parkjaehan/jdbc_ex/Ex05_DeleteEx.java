package kr.parkjaehan.jdbc_ex;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import kr.parkjaehan.helper.DBHelper;

public class Ex05_DeleteEx {
    public static void main(String[] args) {
        Connection conn = DBHelper.getInstance().open();

        String sql = "DELETE FROM department WHERE deptno >= 203";

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

        System.out.println(result + "개의 행이 삭제되었습니다.");
        DBHelper.getInstance().close();
    }
}
