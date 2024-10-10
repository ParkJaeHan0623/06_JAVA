package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;

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

        int result = 0;
        try {
            sqlSession.insert("StudentMapper.insert", student);
            result = student.getStudno();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(result + "학번의 학생이 추가되었습니다.");

        sqlSession.commit();
        sqlSession.close();



    }
}
