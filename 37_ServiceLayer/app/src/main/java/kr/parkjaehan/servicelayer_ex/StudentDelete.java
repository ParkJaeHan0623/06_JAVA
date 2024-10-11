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

public class StudentDelete {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("StudentDelete.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 학생 번호 : ");
        int studno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();

        model.setStudno(studno);

        StudentService studentService = new StudentServiceImpl(sqlSession);

        Student result = null;

        try {
            result = studentService.deleteItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("삭제된 결과가 없습니다.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("SQL문 실행 중 오류가 발생했습니다. Mapper를 확인하세요");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }
        
        logger.debug("====================================");
        logger.debug("삭제된 데이터: " + result + "개");
        logger.debug("====================================");

        sqlSession.close();
    }
}
