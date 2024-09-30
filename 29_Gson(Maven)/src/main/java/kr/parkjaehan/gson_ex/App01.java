package kr.parkjaehan.gson_ex;

import com.google.gson.Gson;

import kr.parkjaehan.helper.FileHelper;
import kr.parkjaehan.model.Data01;

public class App01 {
    public static void main(String[] args) {
        String json =null;
        try {
            json = FileHelper.getInstance().readString("res/01.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
           
        }
        Gson gson = new Gson();
        Data01 data = gson.fromJson(json, Data01.class);
        System.out.println(data.getMessage());
    }
}
