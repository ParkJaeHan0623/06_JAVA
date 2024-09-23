public class 연습문제10_4 {
    
        public static void main(String[] args) {
            int[] price = {38000, 20000, 17900, 17900};
            int[] qty = {6, 4, 3, 5};
            int money = 0;
    
            for (int i = 0; i < price.length; i++) {
                money += price[i] * qty[i];
            }
    
            System.out.printf("총 결제 금액: %d원\n", money);
        }
    
}
