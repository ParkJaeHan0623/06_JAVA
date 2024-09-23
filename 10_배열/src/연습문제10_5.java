public class 연습문제10_5 {
    
        public static void main(String[] args) {
            int[] price = {38000, 20000, 17900, 17900};
            int[] qty = {6, 4, 3, 5};
            int[] arr = new int[4];
    
           
            for (int i = 0; i < price.length; i++) {
                int money = price[i] * qty[i];
                arr[i] = money;
            }
    
           
            int max = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
    
            System.out.printf("상품금액이 가장 비싼 항목의 금액: %d원\n", max);
        }
    
}
