package kr.parkjaehan.crud_ex;

import java.util.List;
import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Department;
import kr.parkjaehan.service.DepartmentService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 학과이름을 입력하세요: ");
        String keyword = scanner.nextLine();

        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);

        DepartmentService departmentService = retrofit.create(DepartmentService.class);
        Call<List<Department>> call = departmentService.listDepartment(keyword);

        call.enqueue(new Callback<List<Department>>() {

            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if (response.isSuccessful()) {
                    List<Department> department = response.body();
                    System.out.println("조회된 학과 정보 : " + department);
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                System.out.println("서버와 통신 실패" + t.getMessage());
            }

        }

        );

        RetrofitHelper.getInstance().shutdown();

    }
}