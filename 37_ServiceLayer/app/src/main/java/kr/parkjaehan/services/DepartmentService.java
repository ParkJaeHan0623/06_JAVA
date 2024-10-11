package kr.parkjaehan.services;

import java.util.List;
import kr.parkjaehan.exceptions.ServiceNoResultException;
import kr.parkjaehan.models.Department;

public interface DepartmentService {
    /**
     * 학과 정보를 새로 저장하고 저장된 정보를 조회하여 리턴한다
     * @param params - 저장할 정보를 담고 있는 Beans
     * @return Department - 저장된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 저장된 데이터가 없는 경우
     */
    public Department addItem(Department params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 수정하고 수정된 정보를 조회하여 리턴한다
     * @param params - 수정할 정보를 담고 있는 Beans
     * @return Department - 수정된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 수정된 데이터가 없는 경우
     */
    public Department editItem(Department params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 삭제한다. 삭제된 데이터의 수가 리턴된다
     * @param params - 삭제할 학과의 일련번호를 담고 있는 Beans
     * @return int - 삭제된 데이터 수
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 삭제된 데이터가 없는 경우
     */
    public int deleteItem(Department params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다
     * @param params - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return Department - 조회된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     */
    public Department getItem(Department params) throws ServiceNoResultException, Exception;

    /**
     * 학과 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다
     * @param params - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return Department - 조회된 데이터
     * @throws MyBatisException - SQL처리에 실패한 경우
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     */
    public List<Department> getList(Department params) throws ServiceNoResultException, Exception;
}
