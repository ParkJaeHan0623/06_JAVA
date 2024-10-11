package kr.parkjaehan.servicelayer_ex;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Professor;

import kr.parkjaehan.services.ProfessorService;
import kr.parkjaehan.services.impl.ProfessorServiceImpl;

public class ProfessorInsert {
    public static void main(String[] args) {
    
        Logger logger = LogManager.getFormatterLogger(ProfessorInsert.class);

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

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);
        Professor result = null;
        try {
            result = professorService.addItem(professor);
        } catch (ServiceNoResultException e) {
            logger.error("저장된 데이터가 없습니다.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("SQL처리에 실패했습니다. Mapper를 확인하세요.");
            logger.error(e.getMessage());
        } 
        finally {
            sqlSession.commit();
        }
        if(result != null) {
            logger.debug("=====================================");
            logger.debug(result.toString());
            logger.debug("=====================================");
        }
        else {
            logger.error("저장된 데이터가 없습니다.");
        }

        sqlSession.close();
    
    }
}
