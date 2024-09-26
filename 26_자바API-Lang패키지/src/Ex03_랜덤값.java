import kr.ParkJaeHan.helper.UtilHelper;

public class Ex03_랜덤값 {
    public static void main(String[] args) {
        UtilHelper utilHelper = UtilHelper.getInstance();   //싱글톤 객체 생성

        int randomNumber = utilHelper.random(0, 9); //랜덤 숫자 만들기 테스트
        System.out.printf("randomNumber = %d\n", randomNumber);

        // 6자리의 인증번호 생성하기
        String authNum = " ";

        for(int i = 0; i< 6; i++){
            authNum += utilHelper.random(0, 9);     //문자열과 숫자의 덧셈은 글자결합. 글자결합을 6번 수행하므로 6개의 숫자가 하나의 문자열로 결합된다
        }

        System.out.printf("인증 번호 = %s", authNum);
    }
}
