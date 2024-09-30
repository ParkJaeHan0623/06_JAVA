package kr.parkjaehan.model;

import lombok.Data;

@Data
public class News {
    private String author;
    private String title;
    private String description;
    private String url;
    private String Image;
    private String datetime;
}
