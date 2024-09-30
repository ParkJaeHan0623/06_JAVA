package kr.parkjaehan.gson_ex;

import com.google.gson.Gson;

import kr.parkjaehan.helper.FileHelper;
import kr.parkjaehan.model.Data04;

public class App04 {
    public static void main(String[] args) {
        String json =null;

        try {
            json = FileHelper.getInstance().readString("res/04.json");
        } catch (Exception e) {
           System.out.println(e.getMessage());
           return;
        }

        Gson gson = new Gson();
        Data04 data = gson.fromJson(json, Data04.class);
        System.out.println(data.toString());
    }
}
