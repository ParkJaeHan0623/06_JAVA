import java.util.Scanner;
public class 연습문제05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("100~200사이의 정수를 입력하세요 : ");
        int number = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i<=number;i++){
            if(i%3==0){
                sum+=i;
            }
        }
        System.out.print(sum);
        scanner.close();
    }
}
