public class 연습문제10_11 {
    public static void main(String[] args) {
        int[][] gold = {
            {500, 291}, 
            {320, 586}, 
            {100, 460}, 
            {120, 558}, 
            {92, 18}, 
            {30, 72}
        };

        double sum = 0;

        for (int i = 0; i < gold.length; i++) {
            sum += (gold[i][0] / 100.0 * 90) * gold[i][1]; 
        }

       
        System.out.printf("골드(G)의 총액 : %.1f G\n", sum);
    }
}
