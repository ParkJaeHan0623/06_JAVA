public class Member {
    private String name;
    private int age;

    //생성자도 메서드의 일종이므로 public 적용
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
