package kr.parkjaehan.retrofit_ex;

import java.util.List;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Titanic;
import kr.parkjaehan.service.MyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyService service = retrofit.create(MyService.class);

        Call<List<Titanic>> call = service.getTitanic();

        call.enqueue(new Callback<List<Titanic>>() {
            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Titanic>> call, Response<List<Titanic>> response) {
                List<Titanic> list = response.body();
                
                for (Titanic d : list){ 
                    System.out.println(d);
                }
            }
            @Override
            public void onFailure(Call<List<Titanic>> call, Throwable t) {
                System.out.println("통신 에러 발생");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
