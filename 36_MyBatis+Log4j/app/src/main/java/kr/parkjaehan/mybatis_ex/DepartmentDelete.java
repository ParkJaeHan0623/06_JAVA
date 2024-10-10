package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Department;

public class DepartmentDelete {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("DepartmentDelete.class");

        
        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 학과 번호 : ");
        int deptNo = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);

        int result = 0;
        try {
            result = sqlSession.delete("DepartmentMapper.delete", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개의 행이 삭제되었습니다.");

        sqlSession.commit();
        sqlSession.close();

    }
}
