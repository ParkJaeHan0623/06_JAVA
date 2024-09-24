public class Ex04_SingleTonPattern {
    public static void main(String[] args) {
        int x = 100;
        int y = 50;

        CalcSingleTon cs1 = CalcSingleTon.getInstance();
        System.out.printf("%d + %d = %d\n",x,y,cs1.plus(x,y));
        System.out.printf("%d - %d = %d\n",x,y,cs1.minus(x,y));
        System.out.printf("%d * %d = %d\n",x,y,cs1.times(x,y));
        System.out.printf("%d / %d = %d\n",x,y,cs1.divide(x,y));
    }
}
