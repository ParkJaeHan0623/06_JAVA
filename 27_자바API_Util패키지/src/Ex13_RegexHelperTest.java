import kr.ParkJaeHan.exceptions.StringFormatException;
import kr.ParkJaeHan.helper.RegexHelper;

public class Ex13_RegexHelperTest {
    public static void main(String[] args) {
        RegexHelper regexHelper = RegexHelper.getInstance();

        String name = "박재한";
        String age = "28";
        String email = "mitshowme@naver.com";
        String phone = "010-1234-5678";

        try {
            regexHelper.isValue(name, "이름을 입력하세요");
            regexHelper.isKor(name, "이름은 한글만 입력 가능합니다");
            regexHelper.isValue(age, "나이를 입력하세요");
            regexHelper.isNum(age, "나이는 숫자만 입력 가능합니다");
            regexHelper.isValue(email, "이메일을 입력하세요");
            regexHelper.isEmail(email, "이메일 형식이 올바르지 않습니다");
            regexHelper.isValue(phone, "전화번호를 입력하세요");
            regexHelper.isCellPhone(phone, "전화번호 형식이 올바르지 않습니다");

        } catch (StringFormatException e) {
            // 에러 메세지 출력 전용 명령
            System.out.println("[Error]" + e.getMessage());
            System.out.println("===================================");
            e.printStackTrace();
        }
    }
}
