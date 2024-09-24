public class Taxi implements Meter{

    @Override
    public void start() {
        System.out.println("택시가 출발합니다");
    }

    @Override
    public int stop(int distence) {
       return distence*1800;
    }
    
    
}
