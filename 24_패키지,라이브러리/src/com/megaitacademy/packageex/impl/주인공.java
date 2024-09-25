package com.megaitacademy.packageex.impl;
import com.megaitacademy.packageex.Fight;
import com.megaitacademy.packageex.Move;
import com.megaitacademy.packageex.Movement;
import com.megaitacademy.packageex.Unit;

public class 주인공 extends Unit implements Move, Fight, Movement{

        public 주인공(String name, int hp, int speed, int dps) {
            super(name, hp, speed, dps);
        }

        @Override
        public void pickUpItem() {
           System.out.printf("[주인공] %s(이)가 아이템을 줍습니다.\n",this.getName());
        }

        @Override
        public void talkNpc() {
            System.out.printf("[주인공] %s(이)가 NPC와 대화를 나눕니다.\n",this.getName());
        }

        @Override
        public void attack() {
            System.out.printf("[주인공] %s(이)가 %d의 힘으로 몬스터를 공격합니다.\n",this.getName(),this.getDps());
        }

        @Override
        public void defense() {
            System.out.printf("[주인공] %s(이)가 상대의 공격을 방어합니다.\n",this.getName());
        }

        @Override
        public void evade() {
            System.out.printf("[주인공] %s(이)가 상대의 공격을 회피합니다.\n",this.getName());
        }

        @Override
        public void walk() {
            System.out.printf("[주인공] %s(이)가 %d의 속도로 걸어갑니다.\n",this.getName(),getSpeed());
        }

        @Override
        public void run() {
            System.out.printf("[주인공] %s(이)가 %d의 속도로 달려갑니다.\n",this.getName(),getSpeed());
        }

        @Override
        public void jump() {
            System.out.printf("[주인공] %s(이)가 %d의 속도로 점프합니다.\n",this.getName(),getSpeed());
        }
}
