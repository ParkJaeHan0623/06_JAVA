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


public class DepartmentDelete {
    public static void main(String[] args) {
        Logger logger = LogManager.getFormatterLogger(DepartmentDelete.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 부서번호를 입력하세요: ");
        int deptNo = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        int result = 0;

        try {
            result = departmentService.deleteItem(model);
        }catch(ServiceNoResultException e){
            sqlSession.rollback();
            logger.error("삭제된 결과가 없습니다.");
            logger.error(e.getMessage());
        } 
        catch (Exception e) {
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
