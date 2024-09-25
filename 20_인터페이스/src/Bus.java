public class Bus implements Meter {

    @Override
    public void start() {
        System.out.println("출발합니다");
    }

    @Override
    public int stop(int distence) {
        return 1500;
    }
    
}
