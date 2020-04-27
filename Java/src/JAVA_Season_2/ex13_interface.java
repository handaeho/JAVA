// 자바의 대표적인 규제 =  abstract(추상), final, interface
// interface: 어떤 객체가 있고, 그 객체가 특정한 인터페이스를 사용한다면
//            그 객체는 반드시 '인터페이스의 메소드를 구현'해야 한다.
//            만약 인터페이스에서 강제하고 있는 메소드들을 구현하지 않으면 컴파일조차 되지 않는다.

interface I {
    public void z();
}

class A implements I {
    // implements(구현): 이 메소드는 인터페이스를 구현하고 있다.
    public void z() {}
}
// 이렇게 클래스 A는 인터페이스 I를 사용하기 때문에, I에서 강제하는 메소드 z를 반드시 구현해야 한다.
// 만약 구현하지 않으면 아래와 같은 에러가 발생한다.
// 'Class 'A' must either be declared abstract or implement abstract method 'z()' in 'I''

// 'interface'와 'abstract'는 다른 것.
// abstract: 상위 클래스의 기능을 하위 클래스가 '물려받는 것'
// interface: 하위 클래스에 특정 메소드가 '반드시 존재'하도록 강제

// 계산기 예제에 interface 적용하면?
// 만약 계산기를 개발하는데 시간이 없어서 짱구가 클래스를 만들고 맹구가 이 클래스를 사용하는 로직을 만든다면
// 짱구는 처음 만들때 계산하고자 하는 인수를 3개(first, second, third)를 받는 것으로 클래스를 구성했는데,
// 맹구는 그 사실을 모르고 2개(left, right)만 받는것으로 로직을 구성했다.
// 그럼 처음에 짱구가 기대한 기능이 구현되지 않은 것.
// 이와 같은 문제를 방지하고자 'interface'를 사용한다.
interface Calculator_interface {
    public void setOprands (int first, int second, int third);
    public int sum();
    public int avg();
}
class Calculator_i implements Calculator_interface {
    int first, second, third;
    public void setOprands (int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public int sum() {
        return this.first + this.second + this.third;
    }
    public int avg() {
        return (this.first + this.second + this.third) / 3;
    }
}
public class ex13_interface {
    public static void main(String[] args) {
        Calculator_i c_i = new Calculator_i();
        c_i.setOprands(10, 20, 30);
        System.out.println(c_i.sum());
        System.out.println(c_i.avg());
    }
}
// interface의 규칙
// 1. 하나의 클래스가 여러개의 인터페이스를 구현할 수 있다.
interface I1 {
    public void x();
}
interface I2 {
    public void y();
}
class B implements I1, I2 {
    public void x() {}
    public void y() {}
}

// 2. 인터페이스도 상속이 가능하다.
interface I3 {
    public void x();
}
interface I4 extends I3 {
    public void y();
}
class C implements I4 {
    public void x() {}
    public void y() {}
}

// 3. 인터페이스의 멤버는 반드시 'public'이다.
interface I5 {
    public void x();
    // void x();
    // private void x();
    // protected void x();
    // ~> 'public'이 아닌 멤버는 불가능.
}
// ~> 인터페이스는 그 인터페이스를 구현한 클래스를 어떻게 조작하는지에 대한 규정을 담고 있기 때문에,
// 외부에서 제어할 수 있는 가장 개방적인 접근자인 'public'만을 허용한다.
// 만약 'public'을 명시하지 않았다면 접근 제어자는 'default'가 아닌 'public'이 된다.

// abstract VS interface
// abstract: '일반적인 클래스'. 구체적인 로직이나 상태를 가질 수 있다.
// interface: 클래스가 아닌 인터페이스라는 '고유한 형태'. 구체적인 로직이나 상태를 가질 수 없다.
