package kr.parkjaehan.servicelayer_ex;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Professor;

import kr.parkjaehan.services.ProfessorService;
import kr.parkjaehan.services.impl.ProfessorServiceImpl;

public class ProfessorDelete {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger("ProfessorDelete.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 교수 번호 : ");

        int profno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();

        model.setProfno(profno);

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);
        int result = 0;

        try {
            result = professorService.deleteItem(model);
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
