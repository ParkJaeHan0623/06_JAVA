class Foo2{
    String name  = "자바";

    public void setMyName(String name){
        name = name;    //이 메서드 안에서의 name은 파라미터를 의미하는데 결국 자신을 자신에게 복제하는 의미가 되므로 정상적인 코드가 아니게 된다.
    }

    public void printMyName(){
        System.out.println(name);
    }
}

public class Ex04_MyNameTest2 {
    public static void main(String[] args) {
        Foo2 f = new Foo2();
        f.setMyName("java");
        f.printMyName();
    }
}
