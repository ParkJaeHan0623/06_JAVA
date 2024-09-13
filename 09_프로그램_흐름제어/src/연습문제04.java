import java.util.Scanner;
public class 연습문제04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1:홀수 단 출력, 2:짝수 단 출력 ");
        int number = scanner.nextInt();

        if(number==1){
            for(int i = 2; i<10 ;i+=2){
                for(int j = 1;j<10;j++){
                    System.out.printf("%d * %d = %d",i,j,i*j);
                    System.out.println();
                }
                System.out.println();
            }
        }
        else if(number==2){
            for(int i = 3; i<10 ;i+=2){
                for(int j = 1;j<10;j++){
                    System.out.printf("%d * %d = %d",i,j,i*j);
                    System.out.println();
                }
                System.out.println();
            }
        }
        else{
            System.out.println("1또는 2를 입력하세요");
        }
        scanner.close();
    }
}
