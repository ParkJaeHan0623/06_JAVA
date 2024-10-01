package kr.parkjaehan.professor_ex;

import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Professor;
import kr.parkjaehan.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("직급을 입력하세요: ");
        String position = scanner.next();
        System.out.print("학력을 입력하세요: ");
        String hiredate = scanner.next();
        System.out.print("나이를 입력하세요: ");
        int sal = scanner.nextInt();
        System.out.print("커미션을 입력하세요: ");
        int comm = scanner.nextInt();
        System.out.print("학과번호를 입력하세요: ");
        int deptno = scanner.nextInt();
        

        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);
        ProfessorService service = retrofit.create(ProfessorService.class);
        Call<Professor> call = service.addProfessor(name,position,hiredate,sal,comm,deptno);
        
        call.enqueue(new Callback<Professor>() {

            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if(response.isSuccessful()) {
                    Professor Professor = response.body();
                    System.out.println("저장된 교수 정보" + Professor);
                }
                else {
                    System.out.println("저장 실패");
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
