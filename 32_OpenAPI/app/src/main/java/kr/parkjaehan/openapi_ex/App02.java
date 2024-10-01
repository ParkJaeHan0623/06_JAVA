package kr.parkjaehan.openapi_ex;

import java.util.List;
import java.util.Scanner;

import kr.parkjaehan.helper.RetrofitHelper;
import kr.parkjaehan.model.KakaoImage;
import kr.parkjaehan.model.KakaoImage.Document;
import kr.parkjaehan.service.KakaoSearchService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색어를 입력하세요: ");
        String keyword = scanner.nextLine();
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("https://dapi.kakao.com");

        KakaoSearchService service = retrofit.create(KakaoSearchService.class);
        
        Call<KakaoImage> call = service.searchImage(keyword);

        call.enqueue(new Callback<KakaoImage>() {

            @Override
            public void onResponse(Call<KakaoImage> call, Response<KakaoImage> response) {
                KakaoImage kakaoImage = response.body();
                @SuppressWarnings("null")
                List<Document> list = kakaoImage.getDocuments();

                for(Document item : list) {
                    System.out.println("이미지 URL: " + item.getImageUrl());
                    System.out.println("썸네일: " + item.getThumbnailUrl());
                    System.out.println("출처: " + item.getDisplaySiteName());
                    System.out.println("문서 URL: " + item.getDocUrl());
                    System.out.printf("가로: %d, 세로: %d\n",item.getWidth(), item.getHeight());
                    System.out.println("=====================================");
                }
            }

            @Override
            public void onFailure(Call<KakaoImage> call, Throwable t) {
               System.out.println("통신 실패: ");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });

        RetrofitHelper.getInstance().shutdown();

    }
}
