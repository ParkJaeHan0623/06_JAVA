package kr.parkjaehan.service;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import kr.parkjaehan.model.News;
import kr.parkjaehan.model.Titanic;
import kr.parkjaehan.model.Traffic_acc;

public interface MyService {
    @GET("/news")
    Call<List<News>> getNews();

    @GET("/titanic")
    Call<List<Titanic>> getTitanic();

    @GET("/traffic_acc")
    Call<List<Traffic_acc>> getTraffic_acc();
}
