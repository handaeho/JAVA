// 제네릭은 메소드에도 적용할 수 있다.
class EmployeeInfo_3 {
    public int rank;
    EmployeeInfo_3 (int rank) {this.rank = rank;}
}

class Person_3 <T, S> {
    public T info;
    public S id;
    Person_3 (T info, S id) {
        this.info = info;
        this.id = id;
    }
    // 메소드에 제네릭 적용
    public <U> void printInfo (U info) {
        System.out.println(info);
    }
}

public class ex21_generic_4 {
    public static void main(String[] args) {
        EmployeeInfo_3 e = new EmployeeInfo_3(1);
        Integer i = new Integer(10);

        // 마찬가지로 이렇게 제네릭을 모두 써서 나타내도 되고
        Person_3<EmployeeInfo_3, Integer> p1 = new Person_3<EmployeeInfo_3, Integer>(e, i);
        p1.<EmployeeInfo_3>printInfo(e);

        // 생략해서 나타내도 결과는 같다.
        p1.printInfo(e);
    }
}
