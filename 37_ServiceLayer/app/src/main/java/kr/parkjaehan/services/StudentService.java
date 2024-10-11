package kr.parkjaehan.services;

import java.util.List;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Student;

public interface StudentService {
    /**
     * 학과 정보를 새로 저장하고 저장된 정보를 조회하여 리턴한다
     * @param params - 저장할 정보를 담고 있는 Beans
     * @return Student - 저장된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 저장된 데이터가 없는 경우
     */
    public Student addItem(Student params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 수정하고 수정된 정보를 조회하여 리턴한다
     * @param params - 수정할 정보를 담고 있는 Beans
     * @return Student - 수정된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 수정된 데이터가 없는 경우
     */
    public Student editItem(Student params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 삭제한다. 삭제 후 학과에 속한 학생들도 삭제한다
     * @param params
     * @return Student - 삭제된 데이터
     * @throws ServiceNoResultException
     * @throws Exception
     */
    public Student deleteItem(Student params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다
     * @param params - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return Student - 조회된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     */
    public Student getItem(Student params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다
     * @param params - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return Student - 조회된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     */
    public List<Student> getList(Student params) throws ServiceNoResultException, Exception;
}