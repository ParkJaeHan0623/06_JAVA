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

public class DepartmentInsert {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(DepartmentInsert.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("학과명: ");
        String dname = scanner.nextLine();

        System.out.print("위치: ");
        String loc = scanner.nextLine();

        scanner.close();

        logger.debug("입력된 데이터 : " + dname + ", " + loc);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department dept = new Department();
        dept.setDname(dname);
        dept.setLoc(loc);

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);
        Department result = null;

        try {
            result = departmentService.addItem(dept);
        } catch (ServiceNoResultException e) {
            logger.error("저장된 데이터가 없습니다.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("SQL처리에 실패했습니다. Mapper를 확인하세요.");
            logger.error(e.getMessage());
        } 
        finally {
            sqlSession.commit();
        }

        if(result != null) {
            logger.debug("=====================================");
            logger.debug(result.toString());
            logger.debug("=====================================");
        }
        else {
            logger.error("저장된 데이터가 없습니다.");
        }

        sqlSession.close();
    }
}
