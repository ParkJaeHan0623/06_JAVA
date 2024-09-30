package kr.parkjaehan.retrofit_ex;

import java.util.List;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Grade;
import kr.parkjaehan.service.MySchoolService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App06 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MySchoolService service = retrofit.create(MySchoolService.class);

        Call<List<Grade>> call = service.getGrades();

        call.enqueue(new Callback<List<Grade>>() {
            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Grade>> call, Response<List<Grade>> response) {
                List<Grade> list = response.body();
                
                for (Grade d : list){
                    System.out.println(d);
                }
            }
            @Override
            public void onFailure(Call<List<Grade>> call, Throwable t) {
                System.out.println("통신 에러 발생");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
