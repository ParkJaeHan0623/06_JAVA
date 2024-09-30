package kr.parkjaehan.gson_ex;

import java.util.List;

import com.google.gson.Gson;

import kr.parkjaehan.helper.FileHelper;
import kr.parkjaehan.model.Data03;

public class App03 {
    public static void main(String[] args) {
        String json =null;
        try {
            json = FileHelper.getInstance().readString("res/03.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Gson gson = new Gson();
        Data03 data = gson.fromJson(json, Data03.class);
        
        List<String> items = data.getItem();

        //향상된 for문
        for(String item : items) {
            System.out.println(item);
        }

    }
}
