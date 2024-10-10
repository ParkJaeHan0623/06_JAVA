package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;

public class StudentSelectItem {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger("StudentSelectItem.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("학생 번호 : ");

        int studno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();

        model.setStudno(studno);

        Student result = null;

        try {
            result = sqlSession.selectOne("StudentMapper.selectItem", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (result == null) {
            logger.error("해당 학생번호가 존재하지 않습니다.");
            return;
        }else{
            System.out.println(result.toString());
        }

        sqlSession.close();
    }
}
