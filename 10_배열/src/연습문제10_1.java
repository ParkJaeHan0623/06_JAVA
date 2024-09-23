public class 연습문제10_1 {
    public static void main(String[] args) {
        boolean[] checked = {true,false,false,true,false};
        
        System.out.print("before --> ");
        
        for(int i = 0; i < checked.length; i++){
            System.out.print(checked[i]);
            if (i < checked.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
        
        for(int i = 0; i < checked.length; i++){
            checked[i] = !checked[i];  
        }
        
        System.out.print("after --> ");
        
        for(int i = 0; i < checked.length; i++){
            System.out.print(checked[i]);
            if (i < checked.length - 1) {
                System.out.print(",");
            }
        }
    }
}