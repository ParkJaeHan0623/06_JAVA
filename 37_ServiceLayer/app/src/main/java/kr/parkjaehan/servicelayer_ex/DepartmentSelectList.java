package kr.parkjaehan.servicelayer_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Department;
import kr.parkjaehan.services.DepartmentService;
import kr.parkjaehan.services.impl.DepartmentServiceImpl;

public class DepartmentSelectList {
    public static void main(String[] args) {
        Logger logger = LogManager.getFormatterLogger(DepartmentSelectList.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        List<Department> result = null;

        try {
            result = departmentService.getList(null);
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
                Department item = result.get(i);
                logger.debug("학과 번호: " + item.getDeptNo());
                logger.debug("학과 이름: " + item.getDname());
                logger.debug("학과 위치: " + item.getLoc());

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
