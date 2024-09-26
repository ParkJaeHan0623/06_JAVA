import java.util.ArrayList;
import java.util.List;

public class Ex09_List {
    public static void main(String[] args) {
        
        List<Integer> numberlist = new ArrayList<Integer>();
        
        // 데이터 추가하기
        numberlist.add(10); //인덱스 0
        numberlist.add(20); //인덱스 1
        numberlist.add(30); //인덱스 2
        numberlist.add(40); //인덱스 3
        numberlist.add(50); //인덱스 4
        numberlist.add(60); //인덱스 5
        numberlist.add(70); //인덱스 6
        numberlist.add(80); //인덱스 7
        numberlist.add(90); //인덱스 8

        //추가된 데이터 확인

        int count = numberlist.size();
        System.out.println("저장된 데이터 수: " + count);

        //인덱스 번호가 4인 데이터 추출
        int value = numberlist.get(4);
        System.out.println("인덱스 4의 데이터: " + value);

        //인덱스 번호가 4인 데이터 삭제
        numberlist.remove(4);

        //하나를 삭제 후 , 전체 크기 다시 조회
        count = numberlist.size();
        System.out.println("저장된 데이터 수: " + count);

        //인덱스 번호가 4인 데이터 다시 얻기
        value = numberlist.get(4);
        System.out.println("인덱스 4의 데이터: " + value);

        // 인덱스 번호가 4인 위치에 데이터 삽입
        numberlist.add(4, 123);
        value = numberlist.get(4);
        System.out.println("인덱스 4의 데이터: " + value);

        // 하나를 삭제 후, 전체 크기 다시 조회
        count = numberlist.size();
        System.out.println("저장된 데이터 수: " + count);

        // 리스트의 원소 탐색
        for(int i = 0; i < numberlist.size(); i++){
            // i 번째 원소 추출 --> 제너릭으로 선언한 클래스에 대한 객체가 된다
            Integer number = numberlist.get(i);
            System.out.println("인덱스 " + i + "의 데이터: " + number);
        }

        // 전체 삭제
        numberlist.clear();
        count = numberlist.size();
        System.out.println("저장된 데이터 수: " + count);
    }
}
