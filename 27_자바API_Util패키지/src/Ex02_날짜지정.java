import java.util.Calendar;
import kr.ParkJaeHan.helper.DatePrinter;

public class Ex02_날짜지정 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        DatePrinter.printDateTime(cal);

        // 객체가 저장하고 있는 값을 변경 --> 특정 날짜로 변경
        cal.set(Calendar.YEAR, 2022);
        // 자바는 0부터 월을 관리하므로 5월을 설정할 것임
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.DAY_OF_MONTH, 5);
        // 시,분,초의 설정도 가능하다 --> 오후 3시 30분 33초..
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 33);
        DatePrinter.printDateTime(cal);

        // 특정 날짜로 일괄 지정
        cal.set(1997,05,23);
        DatePrinter.printDateTime(cal);

        // 특정 날짜로 지정(또 다른 방법 > 시,분,초 포함 > 24시간제만 가능함)
        cal.set(1997,05,23,15,30,33);
        DatePrinter.printDateTime(cal);
    }
}
