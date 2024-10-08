package kr.parkjaehan.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import kr.parkjaehan.helper.DBHelper;

public class App02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학번: ");
        int studno = scanner.nextInt();

        scanner.close();

        String sql = "DELETE FROM student WHERE studno = ?";

        Connection conn = DBHelper.getInstance().open();

        PreparedStatement pstmt = null;

        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, studno);

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
        }

        System.out.println(result + "개의 행이 삭제되었습니다.");

        DBHelper.getInstance().close();

    }
}
