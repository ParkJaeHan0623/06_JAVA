class StaticCounter2 {
    static int count = 0; // static은 객체가 생성되지 않더라도 존재하는 값
    boolean created = false; // 일반 멤버변수는 객체가 생성되어야만 존재하게 되는 값

    public StaticCounter2() {
        count++;
        created = true;
    }

    public int getNormal() {
        created = true;
        return count;
    }

    public static int getStatic() {
        return count;
    }
}

public class Ex03_StaticMethod {
    public static void main(String[] args) {
        System.out.printf("전체 객체의 수 : %d\n", StaticCounter2.count);
        System.out.println("-----------------");

        
        StaticCounter2 c1 = new StaticCounter2();
        StaticCounter2 c2 = new StaticCounter2();

        System.out.printf("c1의 getNormal() 리턴값 : %d\n", c1.getNormal());
        System.out.printf("c2의 getNormal() 리턴값 : %d\n", c2.getNormal());
        System.out.println("-----------------");


        System.out.printf("c1의 getStatic() 리턴값 : %d\n", StaticCounter2.getStatic());
        System.out.printf("c2의 getStatic() 리턴값 : %d\n", StaticCounter2.getStatic());
        System.out.println("-----------------");


        System.out.printf("전체 객체의 수 : %d\n", StaticCounter2.count);
    }
}
