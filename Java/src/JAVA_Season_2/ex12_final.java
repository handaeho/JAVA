// abstract(추상): 상속을 '강제'하는 것.
// final: 상속/변경을 '금지' 하는 것

class Calculator {
    static final double PI = 3.14;
    int left, right;

    public void setOprands (int left, int right) {
        this.left = left;
        this.right = right;
        // Calculator.PI = 6; ~> 만약 이렇게 final로 정의한 PI를 변경한다면 에러가 발생(변경 허용 X)
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

public class ex12_final {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);
        // Calculator.PI = 10; ~> 마찬가지로 final로 정의된 변수는 변경할 수 없다.
    }
}

// 변경 또는 상속을 금지하는 final은 변수 뿐만 아닌 메소드에도 사용이 가능하다
/*
class A{
    final void b() {}
}

class B extends A {
    void b() {}
}

~> 이렇게 final로 정의된 메소드 A를 B가 상속 받을 수 없다.
 */

// 또한 클래스에도 final을 사용할 수 있다.
/*
final class C{
    final void b(){}
}
class D extends C{}

~> 마찬가지로 final로 정의된 클래스 C를 D가 상속 받을수 없다.
 */


