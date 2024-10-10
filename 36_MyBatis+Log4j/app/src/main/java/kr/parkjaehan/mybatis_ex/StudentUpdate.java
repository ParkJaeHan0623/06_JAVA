package kr.parkjaehan.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.parkjaehan.MyBatisConnectionFactory;
import kr.parkjaehan.models.Student;

public class StudentUpdate {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger("StudentUpdate.class");

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
        System.out.print("수정할 학생 번호 : ");
        int studno = scanner.nextInt();
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

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();
        model.setStudno(studno);
        model.setName(name);
        model.setUserid(userid);
        model.setBirthdate(birthdate);
        model.setGrade(grade);
        model.setIdnum(idnum);
        model.setTel(tel);
        model.setHeight(height);
        model.setWeight(weight);
        model.setDeptno(deptno);
        model.setProfno(profno);

        int result = 0;

        try {
            result = sqlSession.update("StudentMapper.update", model);

            if(result == 0){
                logger.error("해당 학생번호가 존재하지 않습니다.");
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
