package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Department;
public class DepartmentUpdate {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger("DepartmentInsert.class");

        
        Scanner scanner = new Scanner(System.in);

        System.out.print("학과명 : ");
        String dname = scanner.nextLine();

        System.out.print("위치 : ");
        String loc = scanner.nextLine();

        
        System.out.print("수정할 학과 번호 : ");
        int deptNo = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);
        model.setDname(dname);
        model.setLoc(loc);

        int result = 0;
        try {
            result = sqlSession.update("DepartmentMapper.update", model);

            if(result == 0){
                logger.error("해당 학과번호가 존재하지 않습니다.");
                return;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개의 행이 수정되었습니다.");

        sqlSession.commit();
        sqlSession.close();
    }
}
