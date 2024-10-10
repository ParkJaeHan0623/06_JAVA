package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Professor;

public class ProfessorUpdate {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("ProfessorUpdate.class");
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
        System.out.print("수정할 교수 번호: ");
        int profno = scanner.nextInt();
        System.out.print("부서번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();
        model.setProfno(profno);
        model.setName(name);
        model.setUserid(userid);
        model.setPosition(position);
        model.setSal(sal);
        model.setHiredate(hiredate);
        model.setComm(comm);
        model.setDeptno(deptno);

        int result = 0;

        try {
            result = sqlSession.update("ProfessorMapper.update", model);

            if (result == 0) {
                logger.error("해당 교수번호가 존재하지 않습니다.");
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
