package com.megaitacademy.packageex.impl;
import com.megaitacademy.packageex.Fight;
import com.megaitacademy.packageex.Move;
import com.megaitacademy.packageex.Unit;

public class 몬스터 extends Unit implements Move, Fight {

    public 몬스터(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    @Override
    public void attack() {
        System.out.printf("[몬스터] %s(이)가 %d의 힘으로 주인공을 공격합니다.\n",this.getName(),this.getDps());
    }

    @Override
    public void defense() {
        System.out.printf("[몬스터] %s(이)가 주인공의 공격을 방어합니다.\n",this.getName());
    }

    @Override
    public void evade() {
        System.out.printf("[몬스터] %s(이)가 주인공의 공격을 회피합니다.\n",this.getName());
    }

    @Override
    public void walk() {
        System.out.printf("[몬스터] %s(이)가 %d의 속도로 걸어갑니다.\n",this.getName(),getSpeed());
    }

    @Override
    public void run() {
        System.out.printf("[몬스터] %s(이)가 %d의 속도로 달려갑니다.\n",this.getName(),getSpeed());
    }

    @Override
    public void jump() {
        System.out.printf("[몬스터] %s(이)가 %d의 속도로 점프합니다.\n",this.getName(),getSpeed());
    }
    
}
