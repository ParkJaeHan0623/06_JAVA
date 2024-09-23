public class Ex04_값복사_참조복사_ArrayCopy {
    public static void main(String[] args) {
        int[] origin = {1,2,3,4,5};
        int[] copy = new int[origin.length];

        System.arraycopy(origin, 0, copy, 1, 3); //origin의 0번째 부터 copy의 1번쨰에 3칸을 복사

        for(int i = 0; i < origin.length; i++){
            System.out.printf("origin[%d]=%d \t copy[%d] = %d\n",i,origin[i],i,copy[i]);

        }
        System.out.println("--------------------------------");

        System.arraycopy(origin, 0, copy, 0, 0); //통째로 복사
        
        for(int i = 0; i < origin.length; i++){
            System.out.printf("origin[%d]=%d \t copy[%d] = %d\n",i,origin[i],i,copy[i]);
        }
    }
}
