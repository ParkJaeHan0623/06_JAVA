class Bar{
    String name  = "자바";

    public void setMyName(){
        String name;
        this.name = "java";
    }

    public void setMyName(String name){
        this.name = name;
    }

    public void printMyName(){
        System.out.println(name);
    }
}

public class Ex05_MyNameTest3 {
    public static void main(String[] args) {
        Bar b = new Bar();
        b.setMyName();
        b.printMyName();
    }
}
