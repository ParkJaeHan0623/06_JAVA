public class 연습문제01 {
    public static void main(String[] args) {
        int a,b;
        int count =0;
        for(a=1;a<7;a++){
            for(b=1;b<7;b++){
                if(a+b==6){
                    System.out.printf("[%d,%d]\n",a,b);
                    count++;
                }
                
            }
        }
        System.out.printf("경우의 수는 %d개 입니다",count);
    }
}
