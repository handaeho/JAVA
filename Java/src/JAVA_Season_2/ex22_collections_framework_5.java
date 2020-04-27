// 정렬
// 컬렉션을 사용하는 이유 중의 하나는 정렬과 같은 데이터와 관련된 작업을 하기 위해서이다.

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.*;

// 정렬하는 법을 알아보자.
// 패키지 java.util 내에는 'Collections'라는 클래스가 있다. 이 클래스를 사용하는 법을 알아보자.
class Computer implements Comparable {
    int serial;
    String owner;
    Computer (int serial, String owner) {
        this.serial = serial;
        this.owner = owner;
    }
    public int compareTo (Object o) {
        return this.serial - ((Computer) o).serial;
    }
    public String toString() {
        return serial + " " + owner;
    }
}

public class ex22_collections_framework_5 {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));

        Iterator i = computers.iterator();
        System.out.println("before");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        // before
        // 500 egoing
        // 200 leezche
        // 3233 graphittie

        Collections.sort(computers);
        System.out.println("\nafter");
        i = computers.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        // after
        // 200 leezche
        // 500 egoing
        // 3233 graphittie
        // ~> sort(정렬) 되었다

        // sort의 시그니처 ~> public static <T extends Comparable<? super T>> void sort(List<T> list)
        // sort의 인자인 list는 데이터 타입이 List이다.
        // 즉 메소드 sort는 List 형식의 컬렉션을 지원한다는 것을 알 수 있다.
        // 그리고 인자 list의 제네릭 <T>는 comparable을 extends 하고 있어야 한다.

        // 'Comparable'은 인터페이스인데 이를 구현하고 있는 클래스는 'compareTo(T o)' 메소드를 가지고 있어야 한다.
        // 따라서 아래의 메소드는 이러한 제약 조건을 준수하기 위한 메소드이다
        /*
        public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
        }
         */
        // ~> 메소드 sort를 실행하면 내부적으로 compareTo를 실행하고 그 결과에 따라서 객체의 선후 관계를 판별하게 된다.
    }
}
