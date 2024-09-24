public class Zelot extends Protoss{

    public Zelot(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
       
    }

    @Override
    public void move(String position) {
        System.out.printf("[Zilot] %s(이)가 %s까지 빠른 속도로 이동합니다.\n",this.getName(),position);
    }

    @Override
    public void attack(String target) {
        System.out.printf("[Zilot] %s(이)가 %s(을)를 칼로 찌릅니다. >> 데미지 : %d\n",this.getName(),target,this.getDps());
    }
    
}
