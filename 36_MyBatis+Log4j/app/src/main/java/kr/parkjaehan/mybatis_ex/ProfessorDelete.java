package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Professor;

public class ProfessorDelete {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("ProfessorDelete.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 교수 번호 : ");

        int profno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();

        model.setProfno(profno);

        int result = 0;

        try {
            result = sqlSession.delete("ProfessorMapper.delete", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개의 행이 삭제되었습니다.");

        sqlSession.commit();
        sqlSession.close();
    }
}
