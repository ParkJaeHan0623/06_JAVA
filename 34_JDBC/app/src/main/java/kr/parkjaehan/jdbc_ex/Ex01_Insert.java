package kr.parkjaehan.jdbc_ex;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * JAVA - 데이터베이스에 데이터 저장하기
 * JDBC 기본 코드
 */
public class Ex01_Insert {
    @SuppressWarnings("null")
    public static void main(String[] args) {

        // 데이터베이스에 저장할 데이터를 사용자로부터 입력받기
        Scanner scanner = new Scanner(System.in);

        System.out.print("학과 이름을 입력하세요: ");
        String dname = scanner.nextLine();

        System.out.print("학과 위치를 입력하세요: ");
        String loc = scanner.nextLine();

        scanner.close();

        // 1) 데이터베이스에 접속하기 위한 정보를 변수로 구성
        String db_hostname = "127.0.0.1"; // 이 프로그램이 구동되는 PC 자체의 주소 = local
        int db_portnumber = 3306;
        String db_database = "myschool";
        String db_charset = "utf8";
        String db_username = "root";
        String db_password = "123qwe!@#";

        // 2) 데이터베이스에 접속하기 ==> mysql -u root -p
        // 접속 객체 선언
        Connection conn = null;

        // 접속 주소 구성
        // jdbc:mysql://127.0.0.1:3306/myschool?characterEncoding=utf8&serverTimezone=UTC
        String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
        String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

        // System.out.println(url);

        // MYSQL JDBC 드라이버 클래스를 로딩해서 DriverManager에 등록한다
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /**
             * DriverManager 객체를 사용하여 DB에 접속한다
             * --> 접속 URL, 아이디, 비밀번호를 전달
             * --> DriverManager에 등록된 Driver 객체를 사용하여 DB에 접속후 Connection 객체를 리턴받는다
             * --> import java.sql.DriverManager 필요함
             */
            conn = DriverManager.getConnection(url, db_username, db_password);
        } catch (ClassNotFoundException e) {
            System.out.println("=================MySQL Driver Loading Fail=================");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("=================MySQL Connection Fail=================");
            e.printStackTrace();
        }

        // 3) 수행할 SQL문을 문자열 변수로 준비
        String sql = String.format("INSERT INTO department (dname, loc) VALUES ('" + dname + "', '" + loc + "')");

        // 4) SQL문을 수행하기 위한 객체 선언(예외처리 필요)
        Statement stmt = null;

        int result = 0;

        try {
            stmt = conn.createStatement();
            // 5) SQL문을 수행하고 결과를 리턴받는다(예외처리 필요)
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("=================MySQL Query Fail=================");
            e.printStackTrace();
        } finally {
            // SQL 구문의 에러 여부에 상관없이 stmt 객체를 닫기 위해 finally 블록 사용
            // --> 객체의 유효범위 설정을 위해서 stmt 객체는 try 블록 밖에서 선언
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 6) 결과 출력
        System.out.println(result + "개의 행이 삽입되었습니다.");

        // 7) 데이터베이스 접속 해제
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("=================MySQL Connection Close Fail=================");
                System.out.println(e.getMessage());
            }
        }

    }

}
