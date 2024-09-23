public class 연습문제10_8 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 9};

        int p = arr.length % 2 == 0 ? arr.length / 2 : (arr.length - 1) / 2;
        
        for (int i = 0; i < p; i++) {
           
            int k = arr.length - i - 1;
            
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }
}
