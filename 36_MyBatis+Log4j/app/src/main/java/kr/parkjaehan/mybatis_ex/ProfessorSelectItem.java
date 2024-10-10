package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Professor;

public class ProfessorSelectItem {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger("ProfessorSelectItem.class");
        Scanner scanner = new Scanner(System.in);
        System.out.print("교수 번호 : ");
        int profno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();

        model.setProfno(profno);

        Professor result = null;

        try {
            result = sqlSession.selectOne("ProfessorMapper.selectItem", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (result == null) {
            logger.error("해당 교수번호가 존재하지 않습니다.");
            return;
            
        } else {
            System.out.println(result.toString());
        }

        sqlSession.close();
    }
}
