import java.util.Scanner;

public class Ex05_예외처리2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x를 입력하세요 : ");
        int x = scanner.nextInt();

        System.out.print("y를 입력하세요 : ");
        int y = scanner.nextInt();

        scanner.close();

        Calc c = Calc.getInstance();

        int z = c.divided(x, y);
        
        System.out.printf("[divided] %d 나누기 %d는 %d 입니다\n",x,y,z);
        System.out.println("================================");

        int a = 0;

        try {
            a=c.divided(x, y);
        } catch (Exception e) {
            System.out.println("[divided 에러] 0으로 나눌 수 없습니다");
        }
        System.out.printf("[dividedEx] %d 나누기 %d는 %d 입니다\n",x,y,a);
    }
}
