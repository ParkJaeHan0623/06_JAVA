package kr.parkjaehan.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Department;
import kr.parkjaehan.services.DepartmentService;
import kr.parkjaehan.services.impl.DepartmentServiceImpl;

public class DepartmentSelectItem {
    public static void main(String[] args) {
        Logger logger = LogManager.getFormatterLogger(DepartmentSelectItem.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("조회할 학과 번호: ");
        int deptNo = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        Department result = null;

        try {
            result = departmentService.getItem(model);
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
            logger.debug("학과 번호: " + result.getDeptNo());
            logger.debug("학과 이름: " + result.getDname());
            logger.debug("학과 위치: " + result.getLoc());
        }else{
            logger.debug("조회된 데이터가 없습니다.");
        }

        logger.debug("====================================");
        
        sqlSession.close();

    }
}
