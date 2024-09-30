package kr.parkjaehan.model;

import lombok.Data;

@Data
public class Titanic {
    private int id;
    private boolean survived;
    private int pclass;
    private String name;
    private String sex;
    private Double age; // null이 가능한 Double로 선언
    private int sibsp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;
}
