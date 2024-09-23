public class 연습문제10_3 {
    
        public static void main(String[] args) {
            int[] arr = {7, 5, 5, 5, 5, 10, 7};
            int sum = 0;
    
            for(int i = 0; i < arr.length; i++) {
              
                sum += arr[i] * ((i < 4) ? 4500 : 5200);
            }
    
            System.out.printf("일주일간의 총 급여 : %d원\n", sum);
        }
    
    
}
