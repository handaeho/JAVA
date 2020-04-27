// Collections Framework
// = '컨테이너'라고도 한다. 즉, '값을 담는 그릇'같은 의미.
// 그리고 그 값에 따라 컨테이너의 성격이 조금씩 달라진다.

// Collections Framework
//      1. Collections
//          1) Set -> Hashset, LinkedHashSet, Treeset
//          2) List -> ArrayList, Vector, LinkedList
//          3) Queue -> PriorityQueue
//      2. Map
//          1) SortedMap -> TreeMap
//          2) Hashtable
//          3) LinkedHashMap
//          4) HashMap
// 각각 하위의 클래스들은 모두 같은 인터페이스를 구현하기 때문에 모두 같은 API를 가지고 있다.
// 즉, 클래스의 취지에 따라서 구현방법과 동작방법은 다르지만 공통의 조작방법을 가지고 있는 것이다.

// 익숙한 ArrayList를 바탕으로 나머지 컬렉션들의 성격을 파악해보자.
// List VS Set
// List: 중복 허용 / Set: 중복 허용 X

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ex22_collections_framework_2 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        System.out.println("<array>");
        Iterator ai = al.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }
        // 결과
        // <array>
        // one
        // two
        // two
        // three
        // three
        // five
        // ~> 중복 허용

        HashSet<String> hs = new HashSet<String>();
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        Iterator hi = hs.iterator();
        System.out.println("\n<hashset>");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
        // 결과
        // <hashset>
        // one
        // two
        // three
        // five
        // ~> 중복 허용 X

        // 메소드 'iterator'는 인터페이스 'Collection'에 정의되어 있다.
        // 따라서 'Collection'을 구현하고 있는 모든 컬렉션즈 프레임웍크는 이 메소드를 구현하고 있음을 보증한다.
        // 메소드 'iterator'의 호출 결과는 인터페이스 'iterator'를 구현한 객체를 리턴한다.

        // 인터페이스 'iterator'는 아래의 메소드를 구현하도록 강제하고 있는데 각각의 역할은 아래와 같다.
        // 1) hasNext ~> 반복할 데이터가 더 있으면 true, 더 이상 반복할 데이터가 없다면 false를 리턴한다.
        // 2) next ~> hasNext가 true라는 것은 next가 리턴할 데이터가 존재한다는 의미다.
        // 이러한 기능을 조합하면 for 문을 이용하는 것과 동일하게 데이터를 순차적으로 처리할 수 있다.
    }
}
