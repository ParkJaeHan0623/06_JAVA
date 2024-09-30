package kr.parkjaehan.retrofit_ex;

import java.util.List;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.Traffic_acc;
import kr.parkjaehan.service.MyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App07 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyService service = retrofit.create(MyService.class);

        Call<List<Traffic_acc>> call = service.getTraffic_acc();

        call.enqueue(new Callback<List<Traffic_acc>>() {
            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Traffic_acc>> call, Response<List<Traffic_acc>> response) {
                List<Traffic_acc> list = response.body();
                
                for (Traffic_acc d : list){
                    System.out.println(d);
                }
            }
            @Override
            public void onFailure(Call<List<Traffic_acc>> call, Throwable t) {
                System.out.println("통신 에러 발생");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
