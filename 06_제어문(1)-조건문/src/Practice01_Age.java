import java.util.Scanner;

public class Practice01_Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이를 입력하세요 : ");
        int myAge = scanner.nextInt()/10;
        scanner.close();
        switch (myAge) {
            case 0: 
                System.out.println("당신은 어린이 입니다");
                break;
            case 1: 
                System.out.printf("당신은 %d대 입니다",myAge*10);
                break;
            case 2: 
                System.out.printf("당신은 %d대 입니다",myAge*10);
                break;
            case 3: 
                System.out.printf("당신은 %d대 입니다",myAge*10);
                break;
            case 4: 
                System.out.printf("당신은 %d대 입니다",myAge*10);
                break;
            case 5: 
                System.out.printf("당신은 %d대 입니다",myAge*10);
                break;
                
            default:
                System.out.printf("당신은 노년층 입니다");
                break;
        }
    }
}
