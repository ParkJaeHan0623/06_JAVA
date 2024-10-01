package kr.parkjaehan.professor_ex;

import java.util.List;
import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Professor;
import kr.parkjaehan.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 교수정보를 입력하세요: ");
        String keyword = scanner.nextLine();
        
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);
        ProfessorService service = retrofit.create(ProfessorService.class);
        Call<List<Professor>> call = service.listProfessor(keyword);
        
        call.enqueue(new Callback<List<Professor>>() {

            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                if(response.isSuccessful()) {
                    List<Professor> Professor = response.body();
                    System.out.println("조회 교수 정보" + Professor);
                }
                else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                System.out.println("서버와 통신 실패" + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
           
    }
}
