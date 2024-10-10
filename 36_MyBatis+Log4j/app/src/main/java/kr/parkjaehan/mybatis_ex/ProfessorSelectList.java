package kr.parkjaehan.mybatis_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Professor;

public class ProfessorSelectList {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger("ProfessorSelectList.class");

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        List<Professor> result = null;

        try {
            result = sqlSession.selectList("ProfessorMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if (result == null) {
            System.out.println("조회된 데이터가 없습니다.");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Professor item = result.get(i);
                logger.debug("교수번호 : " + item.getProfno());
                logger.debug("이름 : " + item.getName());
                logger.debug("아이디 : " + item.getUserid());
                logger.debug("직급 : " + item.getPosition());
                logger.debug("월급 : " + item.getSal());
                logger.debug("고용날짜 : " + item.getHiredate());
                logger.debug("커미션 : " + item.getComm());
                logger.debug("부서번호 : " + item.getDeptno());
            }
        }
    }
}
