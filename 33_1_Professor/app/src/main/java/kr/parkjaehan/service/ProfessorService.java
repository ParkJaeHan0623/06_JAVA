package kr.parkjaehan.service;

import java.util.List;
import kr.parkjaehan.model.Professor;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProfessorService {
    public static final String BASE_URL = "http://localhost:3001";

    /**
     * 교수 정보 저장
     * 
     * @param name      이름
     * @param position  직급
     * @param sal       급여
     * @param hiredate  입사일
     * @param comm      커미션
     * @param deptno    학과번호
     * @return          Professor 객체
     */
    @FormUrlEncoded
    @POST("/professor")
    Call<Professor> addProfessor(@Field("name")String name, @Field("position")String position, @Field("hiredate")String hiredate, @Field("sal")int sal, @Field("comm")int comm, @Field("deptno")int deptno);

    
    /**
     * 교수 정보 조회
     * 
     * @param id    교수번호
     * @return      Professor 객체
     */
    @GET("/professor/{id}")
    Call<Professor> getProfessor(@Path("id") int id);

    /**
     * 교수 정보 조회
     * @param name  이름
     * @return      Professor 객체
     */
    @GET("/professor")
    Call<List<Professor>> listProfessor(@Query("position_like")String position);

    /**
     * 교수 정보 수정
     * 
     * @param id        교수번호
     * @param name      이름
     * @param position  직급
     * @param sal       급여
     * @param hiredate  입사일
     * @param comm      커미션
     * @param deptno    학과번호
     * @return          Professor 객체
     */
    @FormUrlEncoded
    @PUT("/professor/{id}")
    Call<Professor> updateProfessor(@Field("name")String name, @Field("position")String position, @Field("hiredate")String hiredate, @Field("sal")int sal, @Field("comm")int comm, @Field("deptno")int deptno, @Path("id")int id);

    /**
     * 교수 정보 삭제
     * 
     * @param id    교수번호
     * @return      Professor 객체
     */
    @DELETE("/professor/{id}")
    Call<Professor> deleteProfessor(@Path("id")int id);
}
