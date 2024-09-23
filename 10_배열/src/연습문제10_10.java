public class 연습문제10_10 {
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
        int totalSum = 0; 

        
        for (int k = 0; k < student.length; k++) {
            int sum = 0;
            double avg = 0;
            for (int j = 0; j < grade[k].length; j++) {
                sum += grade[k][j];
            }
            avg = (double) sum / grade[k].length;
            sumarr[k] = sum;
            avgarr[k] = avg;
            totalSum += sum;  
        }

        double classAvg = (double) totalSum / (student.length * grade[0].length);
        System.out.printf("반 평균 : %.2f점\n", classAvg);
    }
}
