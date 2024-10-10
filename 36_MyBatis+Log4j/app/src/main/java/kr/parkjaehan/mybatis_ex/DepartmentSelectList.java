package kr.parkjaehan.mybatis_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Department;

public class DepartmentSelectList {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("DepartmentSelectList.class");

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        List<Department> result = null;

        try {
            result = sqlSession.selectList("DepartmentMapper.selectList",null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if(result == null){
            System.out.println("조회된 데이터가 없습니다.");
        }else{
            for(int i = 0; i < result.size(); i++){
                Department item = result.get(i);

                logger.debug("학과번호 : " + item.getDeptNo());
                logger.debug("학과명 : " + item.getDname());
                logger.debug("위치 : " + item.getLoc());
            }
        }

        sqlSession.close();

    }
}
