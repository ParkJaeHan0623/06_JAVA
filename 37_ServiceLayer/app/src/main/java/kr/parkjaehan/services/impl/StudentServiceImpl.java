package kr.parkjaehan.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Student;
import kr.parkjaehan.services.StudentService;

public class StudentServiceImpl implements StudentService {
    
    private SqlSession sqlSession;

    public StudentServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Student addItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;
        int rows = sqlSession.insert("StudentMapper.insert", params);
        if (rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }
        // params에 설정된 PK값을 활용하여 저장된 내용을 그대로 조회한다
        result = sqlSession.selectOne("StudentMapper.selectItem", params);
        return result;
    }

    @Override
    public Student editItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;
        // update문 수행 --> 수정된 데이터의 수가 리턴된다
        int rows = sqlSession.update("StudentMapper.update", params);
        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }
        result = sqlSession.selectOne("StudentMapper.selectItem", params);
        return result;
        
    }

    @Override
    public Student deleteItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;
        int rows = sqlSession.delete("StudentMapper.delete", params);
        if (rows == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }
        result = sqlSession.selectOne("StudentMapper.selectItem", params);
        return result;
    }

    @Override
    public Student getItem(Student params) throws ServiceNoResultException, Exception {
        Student result = sqlSession.selectOne("StudentMapper.selectItem", params);
        if (result == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }
        return result;
    }

    @Override
    public List<Student> getList(Student params) throws ServiceNoResultException, Exception {
        return sqlSession.selectList("StudentMapper.selectList", params);
    }

    
    
}
