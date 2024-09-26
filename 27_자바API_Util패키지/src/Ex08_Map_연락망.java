import java.util.HashMap;
import java.util.Map;

class Member{
    private String phoneNo;
    private String email;

    public Member(String phoneNo, String email){
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String toString(){
        return "phoneNo: " + phoneNo + ", email: " + email;
    }
   
}
public class Ex08_Map_연락망 {
    public static void main(String[] args) {
        Map<String, Member> map = new HashMap<String, Member>();

        // 객체 생성 후 map에 추가
        Member member1 = new Member("010-1234-5678", "member1@naver.com");
        map.put("철수", member1);
        
        // 참조변수 없이 map에 직접 추가

        map.put("철수",new Member("010-1234-5678", "member1@naver.com"));
        map.put("영희",new Member("010-1234-5678", "member@naver.com"));
        map.put("민수",new Member("010-1234-5678", "member@naver.com"));

        // 저장한 객체 중 하나를 추출하여 내용 확인
        Member output = map.get("철수");
        System.out.println(output.toString());
    }
}
