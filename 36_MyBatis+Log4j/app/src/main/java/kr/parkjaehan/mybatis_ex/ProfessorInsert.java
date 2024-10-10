package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Professor;

public class ProfessorInsert {
    public static void main(String[] args) {
    
        Logger logger = LogManager.getLogger("ProfessorInsert.class");

        Scanner scanner = new Scanner(System.in);

        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("아이디: ");
        String userid = scanner.nextLine();
        System.out.print("직급: ");
        String position = scanner.nextLine();
        System.out.print("고용날짜: ");
        String hiredate = scanner.nextLine();
        System.out.print("월급: ");
        int sal = scanner.nextInt();
        scanner.nextLine();
        Integer comm = null;
        System.out.print("커미션: ");
        String commInput = scanner.nextLine();
        if (!commInput.isEmpty()) {
            try {
                comm = Integer.parseInt(commInput);
            } catch (NumberFormatException e) {
                logger.error("유효하지 않은 커미션 입력: " + commInput);
            }
        }
        System.out.print("부서번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        logger.debug("입력된 데이터 : " + name + ", " + userid + ", " + position + ", " + sal + ", " + hiredate + ", " + comm + ", " + deptno);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor professor = new Professor();

        professor.setName(name);
        professor.setUserid(userid);
        professor.setPosition(position);
        professor.setSal(sal);
        professor.setHiredate(hiredate);
        professor.setComm(comm);
        professor.setDeptno(deptno);

        int result = 0;

        try {
            result = sqlSession.insert("ProfessorMapper.insert", professor);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "번의 교수가 추가되었습니다.");

        sqlSession.commit();
        sqlSession.close();


    }
}
