class Person2{
    String name;
    int age;
    String address;

    Person2(){
        this("이름없음", 1,"주소없음");
    }
    Person2(String name){
        this(name, 1,"주소없음");
    }
    Person2(String name, int age){
        this(name,age,"주소없음");
    }
    Person2(String name, int age, String address){
       this.name = name;
       this.age = age;
       this.address = address;
    }

    public String toString(){
        return String.format("이름: %s, 나이 : %d, 주소 : %s",this.name,this.age,this.address);
    }
}

public class Ex07_생성자_오버로딩_this {
    public static void main(String[] args) {
        Person2 p1 = new Person2();
        System.out.println(p1.toString());
        Person2 p2 = new Person2("홍길동");
        System.out.println(p2.toString());
        Person2 p3 = new Person2("김철수",20);
        System.out.println(p3.toString());
        Person2 p4 = new Person2("이영희",20,"서울시 강남구");
        System.out.println(p4.toString());
    }
}
