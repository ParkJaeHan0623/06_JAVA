package kr.parkjaehan.model;

import lombok.Data;

@Data
public class Grade {
    private int id;
    private String name;
    private String sex;
    private int kor;
    private int eng;
    private int math;
    private int sin;
}
