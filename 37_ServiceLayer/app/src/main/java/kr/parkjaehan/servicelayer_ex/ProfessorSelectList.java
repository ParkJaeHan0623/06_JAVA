package kr.parkjaehan.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Professor;

import kr.parkjaehan.services.ProfessorService;
import kr.parkjaehan.services.impl.ProfessorServiceImpl;

public class ProfessorSelectList {
    public static void main(String[] args) {
        Logger logger = LogManager.getFormatterLogger(DepartmentSelectList.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        List<Professor> result = null;

        try {
            result = professorService.getList(null);
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
            int size = result.size();
            for (int i =0; i < size; i++) {
                Professor item = result.get(i);
                logger.debug("교수 번호: " + item.getProfno());
                logger.debug("이름: " + item.getName());
                logger.debug("아이디: " + item.getUserid());
                logger.debug("직급: " + item.getPosition());
                logger.debug("월급: " + item.getSal());
                logger.debug("고용날짜: " + item.getHiredate());
                logger.debug("커미션: " + item.getComm());
                logger.debug("부서번호: " + item.getDeptno());

                if(i + 1 < size){
                    logger.debug("------------------------------------");
                }
                logger.debug("------------------------------------");
            }
        } else {
            logger.debug("조회된 데이터가 없습니다.");
        }

        logger.debug("====================================");

        sqlSession.close();
    }
}
