public class Game {
    public static void main(String[] args) {
        몬스터 m = new 몬스터("골렘", 500, 10, 200);
        주인공 j = new 주인공("기사", 1200, 120, 320);

        m.walk();
        m.run();
        m.jump();

        j.walk();
        j.run();
        j.jump();

        m.attack();
        j.defense();
        j.attack();
        m.evade();
        m.attack();
        j.evade();

        j.pickUpItem();
        j.talkNpc();
    }
}
