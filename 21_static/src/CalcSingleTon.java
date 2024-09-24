public class CalcSingleTon {
    private static CalcSingleTon current;

    public static CalcSingleTon getInstance() {
        if (current == null) {
            current = new CalcSingleTon();
        }

        return current;
    }

    private CalcSingleTon() {
        super();
    }

    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int times(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

}