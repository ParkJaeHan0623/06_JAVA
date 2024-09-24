public class Starcraft {
    public static void main(String[] args) throws Exception{
        
        Zelot z = new Zelot("질럿 1호",150,130,100);
        z.move("저그 본진");
        z.attack("저그 본진");
        System.out.println("===============================");

        Dragun d = new Dragun("드라군 1호",150,130,100);
        d.move("저그 본진");
        d.attack("저그 본진");
        System.out.println("===============================");


        Protoss p1 = new Zelot("질럿 1호",150,130,100);
        Protoss p2 = new Dragun("드라군 1호",150,130,100);

        p1.move("저그 본진");
        p1.attack("저그 본진"); 
        p2.move("저그 본진");
        p2.attack("저그 본진");
    }
}
