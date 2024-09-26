import java.util.Calendar;
import java.util.Scanner;

public class 달력시스템 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 날짜를 입력하는 부분
        System.out.print("년도를 입력하세요 : ");
        int year = scanner.nextInt();
        System.out.print("월을 입력하세요 : ");
        int month = scanner.nextInt();

        System.out.println("=====================================================");

        // 입력받은 년, 월에 해당하는 달력을 출력하는 부분
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, 1);

        int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);

        int[][] data = new int[weekCount][7];
        int count = 1;

        for(int i =0; i<data.length;i++){
            for(int j =0; j<data[i].length;j++){
                if(!(i==0 && j<firstDay-1) && count<=dayCount){
                    data[i][j] = count++;
                }
            }
        }

        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for(int i =0; i<data.length;i++){
            for(int j =0; j<data[i].length;j++){
                if(data[i][j]==0){
                    System.out.print("\t");
                }else{
                    System.out.print(data[i][j] + "\t");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
