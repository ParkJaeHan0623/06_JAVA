/*
 * MAP : key-value 쌍으로 데이터를 저장하는 자료구조
 */

import java.util.HashMap;
import java.util.Map;

public class Ex07_Map {
    public static void main(String[] args) {
        
        Map<String, Integer> map = new HashMap<String,Integer>();

        // map 객체에 데이터 추가
        map.put("나이", 28);
        map.put("키", 180);
        map.put("몸무게", 60);

        // 저장된 데이터의 수
        System.out.println("저장된 데이터 수: " + map.size());

        // 저장된 데이터 꺼내서 사용하기
        System.out.println("나이: " + map.get("나이"));
        System.out.println("키: " + map.get("키"));
        System.out.println("몸무게: " + map.get("몸무게"));
    }
}
