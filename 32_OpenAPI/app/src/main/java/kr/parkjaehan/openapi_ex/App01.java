package kr.parkjaehan.openapi_ex;

import java.util.List;
import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.BoxOffice;
import kr.parkjaehan.model.BoxOffice.BoxOfficeResult.DailyBoxOfficeList;
import kr.parkjaehan.service.BoxOfficeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 날짜를 입력하세요 (yyyymmdd): ");
        String targetDt = scanner.next();
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://www.kobis.or.kr/");

        BoxOfficeService service = retrofit.create(BoxOfficeService.class);

        Call<BoxOffice> call = service.getBoxOffice(targetDt);

        call.enqueue(new Callback<BoxOffice>() {
            @Override
            public void onResponse(Call<BoxOffice> call, Response<BoxOffice> response) {
                BoxOffice boxOffice = response.body();
                @SuppressWarnings("null")
                List<DailyBoxOfficeList> list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

                for (DailyBoxOfficeList item : list) {
                    System.out.printf("영화제목: %s\n", item.getMovieNm());
                    System.out.printf("관객수: %d\n", item.getAudiCnt());
                }
            }

            @Override
            public void onFailure(Call<BoxOffice> call, Throwable t) {
                System.out.println("데이터 조회에 실패했습니다.");
                System.out.println(call.toString());
                t.printStackTrace();
            }


        });

        RetrofitHelper.getInstance().shutdown();
    }
}
