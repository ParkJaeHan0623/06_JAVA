public class 연습문제07 {
    public static void main(String[] args) {
        double meter = 100;
        int count =0;
        for(int i = 1; i>0;i++){
            meter = meter/5*3;
            System.out.printf("%d번째 : %f\n",i,meter);
            count++;
            if((int)meter==0){
                break;
            }
        }
        System.out.printf("튀어오른 횟수 : %d",count-1);
    }
}
