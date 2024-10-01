package kr.parkjaehan.professor_ex;

import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Professor;
import kr.parkjaehan.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 교수 번호를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);
        ProfessorService service = retrofit.create(ProfessorService.class);
        Call<Professor> call = service.deleteProfessor(id);
        
        call.enqueue(new Callback<Professor>() {

            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if(response.isSuccessful()) {
                    System.out.println("삭제 성공");
                }
                else {
                    System.out.println("삭제 실패");
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                System.out.println("서버와 통신 실패" + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
           
    }
}
