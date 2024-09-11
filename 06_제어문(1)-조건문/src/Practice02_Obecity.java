import java.util.Scanner;
public class Practice02_Obecity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("체중을 입력하세요(kg): ");
        int myWeight = scanner.nextInt();
        System.out.print("키를 입력하세요(m): ");
        int myHeight = scanner.nextInt();
        scanner.close();
        
        double standardWeight;
        if(myHeight>=150){
            standardWeight=myHeight-110;
        }
        else{
            standardWeight = (myHeight-110)*0.9;
        }
        double obesity = (myWeight-standardWeight)/standardWeight*100;
        if(obesity<=20){
            System.out.println("정상(안심)");
        }
        else if(obesity<=30){
            System.out.println("경도 비만(주의)");
        }
        else if(obesity<=50){
            System.out.println("중증도 비만(위험)");
        }
        else{
            System.out.println("고도비만(매우 위험)");
        }
    }

}
