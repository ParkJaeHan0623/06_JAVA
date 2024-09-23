public class 연습문제10_14 {
    
        public static void main(String[] args) {
            Object[][] arr = {
                {1, 5, 7, 'J', 'Q', 'A'}, 
                {2, 3, 4, 5, 'Q', 'K', 'A'}
            };
    
            int count = 0;
    
            
            for (int i = 0; i < arr[1].length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[1][i].equals(arr[0][j])) {
                        count++;
                    }
                }
            }
    
            
            int[] arr2 = new int[count];
            Object[] arr3 = new Object[count];
            
            int p = 0;  
            for (int i = 0; i < arr[1].length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[1][i].equals(arr[0][j])) {
                        arr2[p] = j;  
                        arr3[p] = arr[0][j]; 
                        p++;
                    }
                }
            }
    
            System.out.printf("가져올 수 있는 카드의 수: %d 장\n", count);
    
            for (int k = 0; k < arr2.length; k++) {
                System.out.printf("%d번째 >> %s\n", arr2[k], arr3[k].toString());
            }
        }
    }



