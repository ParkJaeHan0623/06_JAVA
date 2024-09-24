/**프로토스 종족의 기본 특성을 정의하는 클래스
 * - public이 적용된 클래스는 다른 파일에 정의된 class가 활용 가능
 * - public이 적용된 클래스는 소스파일당 단 하나만 존재할 수 있다
 */
public abstract class Protoss {
    /** 이름*/
    private String name;  

    /** 체력 */
    private int hp;

    /** 속도 */
    private int speed;

    /** 초당 공격력 */
    private int dps;

    /**
     * 프로토스 객체를 만들기 위한 생성자
     * @param name
     * @param hp
     * @param speed
     * @param dps
     */
    public Protoss(String name, int hp, int speed, int dps){
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.dps = dps;
        System.out.printf(">> 유닛이 생성되었습니다. --> 이름 : %s, 체력 : %d, 공격력 : %d\n" , name, hp, dps);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDps() {
        return this.dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public abstract void move(String position);

    public abstract void attack(String target);

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", hp='" + getHp() + "'" +
            ", speed='" + getSpeed() + "'" +
            ", dps='" + getDps() + "'" +
            "}";
    }

}
