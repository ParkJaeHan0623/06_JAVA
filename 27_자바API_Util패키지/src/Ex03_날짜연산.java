import java.util.Calendar;
import kr.ParkJaeHan.helper.DatePrinter;

public class Ex03_날짜연산 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        DatePrinter.printDateTime(cal);

        // 지금으로 부터 100일 후의 날짜를 계산
        cal.add(Calendar.DAY_OF_MONTH, 100);
        DatePrinter.printDateTime(cal);

        //75년 전의 날짜를 계산
        cal.add(Calendar.YEAR, -75);
        DatePrinter.printDateTime(cal);

        // 9시간 후의 시각을 계산
        cal.add(Calendar.HOUR_OF_DAY, 9);
        DatePrinter.printDateTime(cal);

        // 8달 후의 날짜를 계산
        cal.add(Calendar.MONTH, 8);
        DatePrinter.printDateTime(cal);
    }
}
