import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("체중을 입력하세요(kg): ");
        int myWeight = scanner.nextInt();
        System.out.print("키를 입력하세요(m): ");
        double myHeight = scanner.nextDouble();

        scanner.close();
        double bmi = myWeight/(myHeight*myHeight);
        System.out.printf("당신의 BMI는 %d 입니다",(int)bmi);
    }
}
