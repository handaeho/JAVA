// 'ex14_다형성_polymorphism', 'ex14_다형성_polymorphism_2'에서 클래스와 다형성에 대해 알아보았다면,
// 이번에는 인터페이스와 다형성에 대해 알아보자.

// 다형성의 세계에서는 인터페이스도 중요한 수단이다.
// 특정한 인터페이스를 구현하고 있는 클래스가 있을 때 이 클래스의 데이터 타입으로 인터페이스를 지정 할 수 있다.
interface II {}
class AA implements II {}

interface II2 {
    public String A();
}
interface II3 {
    public String B();
}
class BB implements II2, II3 {
    public String A() {
        return "A";
    }
    public String B() {
        return "B";
    }
}

public class ex14_다형성_polymorphism_3 {
    public static void main(String[] args) {
        II obj = new AA();
        // 클래스 C의 데이터 타입으로 인터페이스 I가 될 수 있다.
        // 이것은 다중 상속이 지원되는 인터페이스의 특징과 결합해서 상속과는 다른 양상의 효과를 만들어낸다.

        BB obj2 = new BB();
        II2 obj_ii2 = new BB();
        II3 obj_ii3 = new BB();

        obj2.A();
        obj2.B();

        obj_ii2.A();
        // bj_ii2.B();

        // obj_ii3.A();
        obj_ii3.B();

        // ~> 'obj_ii2.B()', 'obj_ii3.A()'에서 오류가 나는 이유는
        // 'obj_ii2', 'obj_ii3'의 데이터 타입이 인터페이스 II2, II3이기 때문이다.
        // 인터페이스 II2는 메소드 A만을, II3은 메소드 B만을 정의하고 있기 때문에,
        // 'obj_ii2' 인스턴스는 메소드 A만을, 'obj_ii3' 인스턴스는 메소드 B만을 가지고 있는 것처럼 동작하기 때문이다.

        // 이것은 인터페이스의 매우 중요한 특징 중의 하나를 보여준다.
        // 인스턴스 obj_ii2의 데이터 타입을 II2로 한다는 것은
        // 인스턴스를 외부에서 제어할 수 있는 조작 장치를 인스턴스 II2의 멤버로 제한한다는 의미가 된다.
        // 인스턴스 II2와 II3로 인해서 하나의 클래스가 다양한 형태를 띄게 되는 것이다.
    }
}
