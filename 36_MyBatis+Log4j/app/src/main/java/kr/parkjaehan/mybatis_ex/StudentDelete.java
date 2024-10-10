package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;

public class StudentDelete {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("StudentDelete.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 학생 번호 : ");
        int studno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();

        model.setStudno(studno);

        int result = 0;

        try {
            result = sqlSession.delete("StudentMapper.delete", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개의 행이 삭제되었습니다.");

        sqlSession.commit();
        sqlSession.close();
    }
}
