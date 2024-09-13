import java.util.Scanner;
public class 연습문제06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("과자 한개의 가격을 입력하세요 : ");
        int K = scanner.nextInt();
        System.out.print("과자의 개수를 입력하세요 : ");
        int N = scanner.nextInt();
        System.out.print("현재 돈의 액수를 입력하세요 : ");
        int M = scanner.nextInt();

        int money = M-K*N;
        int getmoney;
        if(money<0){
            getmoney = -1*(money);
            System.out.printf("받야야 할 돈 : %d ",getmoney);
        }
        else{
            System.out.println("받아야 할 돈 : 0원");
        }
        
        
        scanner.close();
    }
}
