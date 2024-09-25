public class Ex06_사용자_정의_예외 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("헬로 월드");

        try {
            s.setKor(-123);
        } catch (MyKorException e) {
            System.err.println("[MyKorException] >> " + e.getMessage());
        }
        try {
            s.setKor(123);
        } catch (MyKorException e) {
            System.err.println("[MyKorException] >> " + e.getMessage());
        }
        try {
            s.setMath(-1);
        } catch (MyMathException e) {
            System.err.println("[MyMathException] >> " + e.getMessage());
        }
        try {
            s.setMath(101);
        } catch (MyMathException e) {
            System.err.println("[MyMathException] >> " + e.getMessage());
        }

    }
}
