// 제네릭(Generic) = 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
class Person<T> {
    public T info;
}

public class ex21_generic {
    public static void main(String[] args) {
        Person<String> p1 = new Person<String> ();
        Person<StringBuilder> p2 = new Person<StringBuilder>();
        // p1, p2의 데이터 타입은 결과적으로
        // p1.info: String
        // p2.info: StringBuilder
        // 이는 각각의 인스턴스를 생성할 때 사용한 '<>' 사이에 어떤 데이터 타입을 사용했는가에 달렸다.

        // 클래스 'Person'의 필드(변수) 'info'의 데이터 타입 '<T>'는 존재하지 않지만,
        // 아래 'main'에서 지정되는 데이터 타입에 의해 결정된다. (<String> / <StringBuilder>)

        // Person<String> p1 ~> 변수 p1의 데이터 타입을 정의(<String>)
        // new Person<String>(); ~> 인스턴스 생성

        // 즉, 클래스를 정의할 떄는 데이터 타입을 확정짓지 않고,
        // 인스턴스를 생성할 때 데이터 타입을 지정하는 기능이 '제네릭(generic)'
    }
}
