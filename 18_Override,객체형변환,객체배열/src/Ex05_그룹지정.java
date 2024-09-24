public class Ex05_그룹지정 {
    public static void main(String[] args) {
        Protoss[] p = new Protoss[5];

        p[0] = new Zilot("질럿1호", 300, 150, 120);
        p[1] = new Dragun("드라군 1호", 450,250,200);
        p[2] = new Zilot("질럿2호", 300, 150, 120);
        p[3] = new Dragun("드라군 2호", 450,250,200);
        p[4] = new Zilot("질럿3호", 300, 150, 120);
        System.out.println("-------------------------");

        for(int i = 0; i<p.length;i++){
            p[i].move("저그 본진");
            p[i].attack("저그 본진");


            if(p[i] instanceof Zilot){
                Zilot z = (Zilot) p[i];
                z.swordAttack("저그 본진");
            }
            else if(p[i] instanceof Dragun){
                Dragun d = (Dragun) p[i];
                d.fireAttack("저그 본진");
            }
        }
    }
}
