class Foo {
    String name = "자바";
    public void setMyName(){
        String name;    //새로운 지역변수 name을 선언
        name = "java";  //이 메서드 안에서의 name은 더이상 멤버변수를 의미하지 않는다.
    }
    public void printMyName(){
        System.out.println(name);
    }
}

public class Ex03_MyNameTest {
    public static void main(String[] args) {
        Foo f = new Foo();
        f.setMyName();
        f.printMyName();
    }
}
