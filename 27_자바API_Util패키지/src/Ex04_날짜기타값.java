import java.util.Calendar;

public class Ex04_날짜기타값 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        
        // 요일에 해당하는 인덱스 (일요일 : 1 ~ 토요일 : 7) 
        int day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("요일 인덱스 = " + day);

        // 요일을 출력하기
        String[] day_name = {"일", "월", "화", "수", "목", "금", "토"};
        System.out.println("요일 = " + day_name[day-1]);

        // 이번 달은 몇 주로 되어있는가?
        int week_count = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        System.out.println("이번 달은 " + week_count + "주로 되어있습니다.");

        // 이번 달은 몇 일까지 있는가?
        int day_count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("이번 달은 " + day_count + "일까지 있습니다.");

        // 이번 달은 무슨 요일로 시작하는가?
        int first_day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("이번 달은 " + day_name[first_day-1] + "요일로 시작합니다.");
    }
}
