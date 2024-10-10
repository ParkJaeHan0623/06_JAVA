package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Department;

public class DepartmentInsert {
    public static void main(String[] args) {
        // (new) Log4j2 객체 생성
        // Logger logger = LogManager.getLogger("내가 만든거");

        Logger logger = LogManager.getLogger("DepartmentInsert.class");

        // 1) 저장할 데이터와 입력받기
        Scanner scanner = new Scanner(System.in);

        System.out.print("학과명 : ");
        String dname = scanner.nextLine();

        System.out.print("위치 : ");
        String loc = scanner.nextLine();

        scanner.close();

        //입력값을 로그로 기록함
        logger.debug("입력된 데이터 : " + dname + ", " + loc);

        // 2) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 3) INSERT를 수행할 데이터 생성
        // --> Beans에 생성자를 사용하지 않으면 필요한 데이터만 setter로 설정할 수 있음
    
        Department department = new Department();
        department.setDname(dname);
        department.setLoc(loc);

        // 4) 데이터 저장
        int result = 0;
        try{
            sqlSession.insert("DepartmentMapper.insert", department);
        result = department.getDeptNo();
        }
        catch(Exception e){
            logger.error(e.getMessage());
        
        }

        // 5) 결과 판별
        // --> 리턴값이 0이라면 내부적으로 예외가 발생된 상황으로 간주해야 한다
        // system.out.println(result + "개의 행이 추가되었습니다.");
        logger.info(result + "");

        // 6) 데이터베이스 접속 해제
        // 페이지 종료 전에 데이터의 변경사항을 저장(커밋)하고 데이터베이스 접속을 해제해야 한다
        sqlSession.commit();
        sqlSession.close();
    }
}
