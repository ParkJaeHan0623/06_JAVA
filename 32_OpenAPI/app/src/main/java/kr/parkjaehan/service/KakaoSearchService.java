package kr.parkjaehan.service;

import kr.parkjaehan.model.KakaoImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface KakaoSearchService {
    @Headers({"Authorization: KakaoAK 97ed497e10a36978fb41ccded5d2c9e0"})
    @GET("/v2/search/image")
    Call<KakaoImage> searchImage(@Query("query") String query);
}