package kr.parkjaehan.service;
import kr.parkjaehan.model.Department;
import kr.parkjaehan.model.Grade;
import kr.parkjaehan.model.Professor;
import kr.parkjaehan.model.Student;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MySchoolService {
    @GET("/student")
    Call<List<Student>> getStudents();

    @GET("/professor")
    Call<List<Professor>> getProfessors();

    @GET("/department")
    Call<List<Department>> getDepartments();

    @GET("/grade")
    Call<List<Grade>> getGrades();
}