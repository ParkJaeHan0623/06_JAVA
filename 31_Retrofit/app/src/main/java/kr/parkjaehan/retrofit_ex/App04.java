package kr.parkjaehan.retrofit_ex;

import java.util.List;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.News;
import kr.parkjaehan.service.MyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App04 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyService service = retrofit.create(MyService.class);

        Call<List<News>> call = service.getNews();

        call.enqueue(new Callback<List<News>>() {
            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> list = response.body();
                
                for (News d : list){
                    System.out.println(d);
                }
            }
            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("통신 에러 발생");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
