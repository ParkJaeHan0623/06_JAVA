public class Zilot extends Protoss{
    public Zilot(String name, int hp, int speed, int dps){
        super(name,hp,speed,dps);
    }
    /**메서드 오버라이드
     * 자식 클래스가 부모가 갖고 있는 메서드를 다시 새롭게 재구성 하는것 ==> 기능의 수정
     * 자식 클래스의 객체를 통해 이 메서드를 호출하면 부모가 갖고 있는 기능은 비활성화
     */
    @Override
    public void move(String target){
        System.out.printf("[Zilot] %s(이)가 %s까지 빠른 속도로 이동합니다.\n",this.getName(),target);
    }

    @Override
    public void attack(String target){
        System.out.printf("[Zilot] %s(이)가 %s(을)를 칼로 찌릅니다. >> 데미지 : %d\n",this.getName(),target,this.getDps());
    }

    /**
     * 이 클래스가 독자적으로 갖는 고유의 기능
     * @param target  공격할 대상
     */
    public void swordAttack(String target){
        System.out.printf("[질럿의 고유 스킬] %s가 %s를 칼로 공격합니다.\n",this.getName(),target);
    }
}
