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

public class ProfessorSelectItem {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("ProfessorSelectItem.class");
        Scanner scanner = new Scanner(System.in);
        System.out.print("교수 번호 : ");
        int profno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();
        model.setProfno(profno);

        Professor result = null;

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        try {
            result = professorService.getItem(model);
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
            logger.debug("교수 번호: " + result.getProfno());
            logger.debug("이름: " + result.getName());
            logger.debug("아이디: " + result.getUserid());
            logger.debug("직급: " + result.getPosition());
            logger.debug("월급: " + result.getSal());
            logger.debug("고용날짜: " + result.getHiredate());
            logger.debug("커미션: " + result.getComm());
            logger.debug("부서번호: " + result.getDeptno());
        } else {
            logger.debug("조회된 데이터가 없습니다.");
        }

        logger.debug("====================================");

        sqlSession.close();
    }
}
