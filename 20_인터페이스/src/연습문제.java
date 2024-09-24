public class 연습문제 {
    public static void main(String[] args) {
        Taxi t = new Taxi();
        t.start();

        int taxiPay = t.stop(5);
        System.out.printf("택시요금 : %d원", taxiPay);
    }
}
