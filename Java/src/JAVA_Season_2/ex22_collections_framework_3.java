// set = 집합.
// 수학에서의 집합도 순서가 없고 중복되지 않는 특성이 있다
// 수학에서 집합은 교집합(intersect), 차집합(difference), 합집합(union)과 같은 연산을 할 수 있다.

import java.util.HashSet;
import java.util.Iterator;

public class ex22_collections_framework_3 {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);

        // 부분집합(subset)
        System.out.println(A.containsAll(B)); // false ~> B는 A의 부분집합이 아니다
        System.out.println(A.containsAll(C)); // true ~> C는 A의 부분집합이다

        //System.out.println(A.addAll(B)); // ~> 합집합(A ∪ B)
        //System.out.println(A.retainAll(B)); // ~> 교집합(A ∩ B)
        //System.out.println(A.removeAll(B)); // ~> 차집합(A - B)

        Iterator hi = A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}

