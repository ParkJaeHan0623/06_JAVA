public class Taxi implements Meter{

    @Override
    public void start() {
        System.out.println("출발합니다");
    }

    @Override
    public int stop(int distence) {
       int pay = distence*1800;
        return pay;
    }
    
    
}
