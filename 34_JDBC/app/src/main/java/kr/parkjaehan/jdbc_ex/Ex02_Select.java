package kr.parkjaehan.jdbc_ex;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex02_Select {
    @SuppressWarnings("null")
    public static void main(String[] args) {

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
        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno ASC";

        //
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
        } catch (SQLException e) {
            System.out.println("=================SQL Fail=================");
            e.printStackTrace();

        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
        }
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
