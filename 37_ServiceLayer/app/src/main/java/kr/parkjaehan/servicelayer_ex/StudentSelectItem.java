package kr.parkjaehan.servicelayer_ex;

import java.util.Scanner;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;
import kr.parkjaehan.services.StudentService;
import kr.parkjaehan.services.impl.StudentServiceImpl;
import kr.parkjaehan.exceptions.ServiceNoResultException;

public class StudentSelectItem {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("StudentSelectItem.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("학생 번호 : ");

        int studno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();

        model.setStudno(studno);

        Student result = null;

        StudentService studentService = new StudentServiceImpl(sqlSession);

        try {
            result = studentService.getItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("조회된 결과가 없습니다.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("SQL문 실행 중 오류가 발생했습니다. Mapper를 확인하세요");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        logger.debug("====================================");
        if (result != null) {
            logger.debug("학생 번호: " + result.getStudno());
            logger.debug("이름: " + result.getName());
            logger.debug("아이디: " + result.getUserid());
            logger.debug("생년월일: " + result.getBirthdate());
            logger.debug("학년: " + result.getGrade());
            logger.debug("주민번호: " + result.getIdnum());
            logger.debug("전화번호: " + result.getTel());
            logger.debug("키: " + result.getHeight());
            logger.debug("몸무게: " + result.getWeight());
            logger.debug("학과번호: " + result.getDeptno());
            logger.debug("교수번호: " + result.getProfno());
        } else {
            logger.debug("조회된 데이터가 없습니다.");
            
        }
        logger.debug("====================================");
        sqlSession.close();
    }
}
