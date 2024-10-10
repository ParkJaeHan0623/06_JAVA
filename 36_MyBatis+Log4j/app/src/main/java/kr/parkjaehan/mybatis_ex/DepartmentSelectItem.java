package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Department;
public class DepartmentSelectItem {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger("DepartmentSelectItem.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("학과 번호 : ");

        int deptNo = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);

        Department result = null;

        try {
            result = sqlSession.selectOne("DepartmentMapper.selectItem", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (result == null) {
            logger.error("해당 학과번호가 존재하지 않습니다.");
            return;
        }else{
            System.out.println(result.toString());
        }

        sqlSession.close();
    }
}
