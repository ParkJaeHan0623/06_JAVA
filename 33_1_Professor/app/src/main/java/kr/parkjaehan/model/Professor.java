package kr.parkjaehan.model;

import lombok.Data;

@Data
public class Professor {
    private int id;
    private String name;
    private String position;
    private int sal;
    private String hiredate;
    private int comm;
    private int deptno;
    
}