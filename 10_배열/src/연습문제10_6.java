public class 연습문제10_6 {
    
        public static void main(String[] args) {
            int[] price = {38000, 20000, 17900, 17900};
            int[] qty = {6, 4, 3, 5};
            int[] arr = new int[4];
            int count = 0;
    
            // 각 상품의 금액 계산
            for (int i = 0; i < price.length; i++) {
                int money = price[i] * qty[i];
                arr[i] = money;
            }
    
            // 무료 배송 기준(80,000원 이상)의 상품 수 계산
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= 80000) {
                    count++;
                }
            }
    
            System.out.printf("무료로 배송되는 상품: %d개\n", count);
        }
    
}
