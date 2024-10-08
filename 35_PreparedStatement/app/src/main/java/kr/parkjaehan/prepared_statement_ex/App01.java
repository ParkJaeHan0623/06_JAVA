package kr.parkjaehan.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.parkjaehan.helper.DBHelper;

public class App01 {
    public static void main(String[] args) {
        // 1) 저장할 데이터와 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("학과명: ");
        String dname = scanner.nextLine();

        System.out.print("위치: ");
        String loc = scanner.nextLine();

        scanner.close();

        // 2) SQL 구문 정의하기

        // 'department' 테이블에 '컴퓨터정보과'를 추가하기 위한 SQL문
        // deptno 컬럼은 AUTO_INCREMENT로 자동 증가되므로 값을 지정하지 않는다.
        String sql = "INSERT INTO department (dname, loc) VALUES (?, ?)";

        Connection conn = DBHelper.getInstance().open();

        // 3) SQL 실행하기
        // SQL문의 템플릿을 사용하여 쿼리 실행을 준비하는 객체
        // --> import java.sql.PreparedStatement;
        PreparedStatement pstmt = null;

        // 처리 결과를 받을 객체
        // --> import java.sql.ResultSet;
        ResultSet rs = null;

        // 결과값(저장된 데이터의 수)
        int result = 0;

        // 결과값(생성된 AUTO_INCREMENT 값)
        int autoGeneratedID = 0;

        try {
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, dname);
            pstmt.setString(2, loc);

            result = pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            rs.next();
            autoGeneratedID = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        System.out.println(result + " 개의 행이 추가되었습니다.");
        System.out.println("New Deptno = " + autoGeneratedID);

        DBHelper.getInstance().close();
    }
}
