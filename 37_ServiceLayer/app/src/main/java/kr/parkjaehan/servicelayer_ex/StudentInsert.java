package kr.parkjaehan.servicelayer_ex;

import java.util.Scanner;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;
import kr.parkjaehan.services.StudentService;
import kr.parkjaehan.services.impl.StudentServiceImpl;
import kr.parkjaehan.exceptions.ServiceNoResultException;

public class StudentInsert {
    public static void main(String[] args) {
                Logger logger = LogManager.getLogger("StudentInsert.class");

        Scanner scanner = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("아이디: ");
        String userid = scanner.nextLine();
        System.out.print("생년월일: ");
        String birthdate = scanner.nextLine();
        System.out.print("주민번호: ");
        String idnum = scanner.nextLine();
        System.out.print("전화번호: ");
        String tel = scanner.nextLine();
        System.out.print("학년: ");
        int grade = scanner.nextInt();
        System.out.print("키: ");
        int height = scanner.nextInt();
        System.out.print("몸무게: ");
        int weight = scanner.nextInt();
        System.out.print("학과번호: ");
        int deptno = scanner.nextInt();
        scanner.nextLine();
        Integer profno = null;
        System.out.print("교수번호: ");
        String profnoInput = scanner.nextLine();
        if (!profnoInput.isEmpty()) {
            try {
                profno = Integer.parseInt(profnoInput);
            } catch (NumberFormatException e) {
                logger.error("유효하지 않은 교수번호 입력: " + profnoInput);
            }
        }
        
        scanner.close();

        logger.debug("입력된 데이터 : " + name + ", " + userid + ", " + ", " + grade + ", " + idnum + ", " + birthdate + ", " + tel + ", " + height + ", " + weight + ", " + deptno + ", " + profno);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student student = new Student();
        student.setName(name);
        student.setUserid(userid);
        student.setBirthdate(birthdate);
        student.setGrade(grade);
        student.setIdnum(idnum);
        student.setTel(tel);
        student.setHeight(height);
        student.setWeight(weight);
        student.setDeptno(deptno);
        student.setProfno(profno);

        StudentService studentService = new StudentServiceImpl(sqlSession);

        Student result = null;

        try {
            result = studentService.addItem(student);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("저장된 결과가 없습니다.");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("SQL문 실행 중 오류가 발생했습니다. Mapper를 확인하세요");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        if (result != null) {
            logger.debug("====================================");
            logger.debug(result.toString());
            logger.debug("====================================");
        }else {
            logger.debug("저장된 데이터가 없습니다.");
        }

        sqlSession.close();
        
    }
}
