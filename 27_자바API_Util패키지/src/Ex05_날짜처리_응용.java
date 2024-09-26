import java.util.Calendar;

public class Ex05_날짜처리_응용 {
    public static void main(String[] args) {
        
        
        Calendar cal = Calendar.getInstance();

        // 이번 달은 몇 주로 되어있는가?
        int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        
        // 이번 달은 몇 일까지 있는가?
        int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 이번 달은 무슨 요일로 시작하는가?
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);

        // weekCount --> 몇 주 인가? --> 행
        // 일~토 --> 7일 --> 열
        int[][] data = new int[weekCount][7];

        // 배열의 원소로 설정할 숫자 --> 날짜 값 --> 1씩 증가하면서 배열에 할당
        int count = 1;

        // 행의 수 만큼 반복 --> "주" 수 만큼 반복
        for(int i =0; i<data.length;i++){
            // 열의 수 만큼 반복 --> "요일" 수 만큼 반복
            for(int j =0; j<data[i].length;j++){
                if(!(i==0 && j<firstDay-1) && count<=dayCount){
                    data[i][j] = count++;
                }
            }
        }

        // 배열 출력을 위한 반복문
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
    }
}
