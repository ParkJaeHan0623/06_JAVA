package kr.parkjaehan.model;

import lombok.Data;

@Data
public class Traffic_acc {
    private int id;
    private int year;
    private int month;
    private int accident;
    private int death;
    private int injury;
}
