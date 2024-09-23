
public class 연습문제10_9 {
    public static void main(String[] args) {
        String[] student = {"둘리", "도우너", "또치", "희동"};
        int[][] grade = {
            {78, 89, 96}, 
            {62, 77, 67}, 
            {54, 90, 80}, 
            {100, 99, 98}
        };
        int[] sumarr = new int[student.length];
        double[] avgarr = new double[student.length];

        for (int k = 0; k < student.length; k++) {
            int sum = 0;
            double avg = 0;
            for (int j = 0; j < grade[k].length; j++) {
                sum += grade[k][j];
            }
            avg = (double) sum / grade[k].length;
            sumarr[k] = sum;
            avgarr[k] = avg;

            if (avg == (int) avg) {
                System.out.printf("%s 총점 : %d점 , 평균 : %d점\n", student[k], sumarr[k], (int) avg);
            } else {
                System.out.printf("%s 총점 : %d점 , 평균 : %.2f점\n", student[k], sumarr[k], avg);
            }
        }
    
    }
}
