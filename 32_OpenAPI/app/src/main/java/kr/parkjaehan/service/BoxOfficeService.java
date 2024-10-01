package kr.parkjaehan.service;

import kr.parkjaehan.model.BoxOffice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BoxOfficeService {
    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=7a5a1115c95b43e0b7dc2ffc4a5a18e5")
    Call<BoxOffice> getBoxOffice(@Query("targetDt") String targetDt);
    
} 