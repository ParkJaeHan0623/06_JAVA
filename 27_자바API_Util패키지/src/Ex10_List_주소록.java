import java.util.ArrayList;
import java.util.List;

class User{
    private String name;
    private String phoneNo;
    private String email;

    public User(String name, String phoneNo, String email){
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String toString(){
        return "name: " + name + ", phoneNo: " + phoneNo + ", email: " + email;
    }
}

public class Ex10_List_주소록 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        
        userList.add(new User("철수","010-1234-5678", "member1@naver.com"));
        userList.add(new User("영희","010-1234-5678", "member1@naver.com"));
        userList.add(new User("민수","010-1234-5678", "member1@naver.com"));

        // 추가된 사용자의 수 만큼 반복
        for(int i = 0; i < userList.size(); i++){
            User item = userList.get(i);
            //추가된 객체의 클래스타입으로 추출 결과를 받는다
            System.out.println(item.toString());
        }
    }
}
