// 클래스 내에서 여러개의 제네릭을 필요로 하는 경우
class EmployeeInfo_2 {
    public int rank;
    EmployeeInfo_2 (int rank) {this.rank = rank;}
}

class Person_2 <T, S> {
    public T info;
    public S id;
    Person_2 (T info, S id) {
        this.info = info;
        this.id = id;
    }
}

public class ex21_generic_3 {
    public static void main(String[] args) {
        // 제네릭은 참조 데이터 타입에 대해서만 사용할 수 있다. 기본 데이터 타입에서는 사용할 수 없다.
        // Person_2 <EmployeeInfo_2, int> p1 = new Person_2<EmployeeInfo_2, int>(new EmployeeInfo_2(1), 1);
        // ~> 기본 데이터 타입은 int 타입을 사용할 수 없다. 따라서 에러

        EmployeeInfo_2 e = new EmployeeInfo_2(1);
        Integer i = new Integer(10);
        Person_2<EmployeeInfo_2, Integer> p1= new Person_2<EmployeeInfo_2, Integer>(e, i);
        System.out.println(p1.id.intValue());
        // ~> 이렇게 'Integer i = new Integer(10);'로 정수형 참조 데이터 타입을 사용해서 전달 해야한다.
        // 'new Integer()'는 기본 데이터 타입인 'int'를 참조 데이터 타입으로 변환해주는 역할
        // ---> 이러한 클래스를 '래퍼(wrapper) 클래스'라고 한다.
        // 그리고 'new Person_2<EmployeeInfo_2, Integer>(e, i);' 에서 '<EmployeeInfo_2, Integer>'이 제네릭이다.

        // 그런데 이 제네릭은 생략 할 수도 있다.
        Person_2 p2 = new Person_2(e, i);
        System.out.println(p2.id);
        // ~> e와 i의 데이터 타입(int, integer)을 알고 있기 때문이다.
    }
}
