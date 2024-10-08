package kr.parkjaehan.jdbc_ex;

import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;

import kr.parkjaehan.helper.DBHelper;

public class Ex03_InsertEx {
    public static void main(String[] args) {
        // 데이터베이스에 저장할 데이터를 사용자로부터 입력받기
        Scanner scanner = new Scanner(System.in);

        System.out.print("학과 이름을 입력하세요: ");
        String dname = scanner.nextLine();

        System.out.print("학과 위치를 입력하세요: ");
        String loc = scanner.nextLine();

        scanner.close();

        Connection conn = DBHelper.getInstance().open();

        String sql = "INSERT INTO department (dname, loc) VALUES ('" + dname + "', '" + loc + "')";

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
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        System.out.println(result + "개의 행이 삽입되었습니다.");
        DBHelper.getInstance().close();
    }
}
