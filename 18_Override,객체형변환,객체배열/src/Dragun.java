public class Dragun extends Protoss{
    public Dragun(String name, int hp, int speed, int dps){
        super(name,hp,speed,dps);
    }

    @Override
    public void attack(String target){
        super.attack(target);

        System.out.println(">>>>> 원거리 공격을 위한 포탄 발사");
    }

    @Override
    public void move(String position){
        super.move(position);
        System.out.println((">>>>> 지정된 위치까지 지상으로 이동"));
    }

    /**
     * 이 클래스가 독자적으로 갖는 고유의 기능
     * @param target 공격할 대상
     */
    public void fireAttack(String target){
        System.out.printf("[드라군의 고유 스킬] %s가 %s에게 포탄을 발사합니다.", this.getName(),target);
    }


}
