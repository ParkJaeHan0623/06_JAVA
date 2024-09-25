public class 연습문제 {
    public static void main(String[] args) {
        Taxi t = new Taxi();
        t.start();

        int taxiPay = t.stop(5);
        System.out.printf("택시요금 : %d원\n", taxiPay);

        Bus b = new Bus();
        b.start();

        int BusPay = b.stop(5);
        System.out.printf("버스요금 : %d원\n", BusPay);
    }
}
