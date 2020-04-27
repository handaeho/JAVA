// Map = key와 value의 쌍으로 값을 저장하는 컬렉션

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ex22_collections_framework_4 {
    public static void main(String[] args) {
        // String : Integer 쌍의 값
        HashMap<String, Integer> a = new HashMap<String, Integer>();

        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        System.out.println(a.get("one"));   // 1
        System.out.println(a.get("two"));   // 2
        System.out.println(a.get("three")); // 3

        System.out.println("----------");

        iteratorUsingForEach(a);
        // four : 4
        // one : 1
        // two : 2
        // three : 3

        System.out.println("----------");

        iteratorUsingIterator(a);
        // four : 4
        // one : 1
        // two : 2
        // three : 3
    }

    static void iteratorUsingForEach (HashMap map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    // 메소드 'entrySet'은 Map의 데이터를 담고 있는 Set을 반환한다.
    // 반환한 Set의 값이 사용할 데이터 타입은 Map.Entry이다.
    // 'Map.Entry'는 인터페이스인데 아래와 같은 API를 가지고 있다.
    //  1) getKey
    //  2) getValue
    // ~> Map의 key와 value의 관계는 함수의 정의역과 공역의 관계와 같다
    // 즉, key에 따라 value가 변하는 것.
}
