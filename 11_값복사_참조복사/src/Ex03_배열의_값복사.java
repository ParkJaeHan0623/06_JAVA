public class Ex03_배열의_값복사 {
    public static void main(String[] args) {
        int [] origin = {1,2};

        int [] copy = new int[origin.length];

        copy[0] = origin[0];
        copy[1] = origin[1];

        System.out.println("origin[0] = " + origin[0]);
        System.out.println("origin[1] = " + origin[1]);
        System.out.println("copy[0] = " + copy[0]);
        System.out.println("copy[1] = " + copy[1]);
        System.out.println("-------------------------");

        //복사본을 수정하더라도 원본의 변화가 없다

        copy[0] += 100;
        copy[1] += 200;

        System.out.println("origin[0] = " + origin[0]);
        System.out.println("origin[1] = " + origin[1]);
        System.out.println("copy[0] = " + copy[0]);
        System.out.println("copy[1] = " + copy[1]);
    }
}
