package kr.parkjaehan.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Professor;
import kr.parkjaehan.models.Student;
import kr.parkjaehan.services.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService{

     private SqlSession sqlSession;

    public ProfessorServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;

    }
@Override
    public Professor addItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;
        int rows = sqlSession.insert("ProfessorMapper.insert", params);
        if (rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }
        // params에 설정된 PK값을 활용하여 저장된 내용을 그대로 조회한다
        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);

        return result;
    }

    @Override
    public Professor editItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;
        // update문 수행 --> 수정된 데이터의 수가 리턴된다
        int rows = sqlSession.update("ProfessorMapper.update", params);

        // 수정된 데이터가 없는 경우 예외를 발생시킨다
        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }
        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);
        return result;
    }

    @Override
    public int deleteItem(Professor params) throws ServiceNoResultException, Exception {
        int result = 0;

        // 학과 데이터 삭제를 위해 참조관계에 있는 자식 데이터를 순서대로 삭제
        Student student = new Student();
        student.setDeptno(params.getDeptno());
        sqlSession.delete("StudentMapper.deleteByProfno", student);

        // 교수 데이터 삭제
        result = sqlSession.delete("ProfessorMapper.delete", params);

        // 삭제된 데이터가 없는 경우 예외를 발생시킨다
        if (result == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
            
        }

        return result;
    }

    @Override
    public Professor getItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;

        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);

        if (result == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }
        return result;
    }

    @Override
    public List<Professor> getList(Professor params) throws ServiceNoResultException, Exception {
        return sqlSession.selectList("ProfessorMapper.selectList", params);
    }
    
    
}
