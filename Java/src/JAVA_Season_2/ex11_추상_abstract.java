package JAVA_Season_2;

// 추상 메소드(Abstract Method) = 메소드의 시그니처만 정의되어 있는 메소드

// 추상 클래스인 Abstract 클래스
abstract class Abstract{
    public abstract int B();
    // ~> 추상 메소드는 '본체를 가질수 없다'.
    // 즉, public abstract int B() { ~~~ }는 불가

    // 그러나 추상 클래스는 추상 메소드가 아닌 메소드(본체를 갖는 메소드)가 존재할 수 있다
    public void C() {
        System.out.println("Hello");
    }
}

// 추상 클래스인 Abstract 클래스를 상속받은 하위 클래스 Abstract_inheritance 생성
class Abstract_inheritance extends Abstract {
    // Abstract 클래스를 오버라이드해 본체(내용)를 생성
    public int B() { return 1; }
}

public class ex11_추상_abstract {
    public static void main(String[] args) {
        // Abstract obj = new Abstract(); ---> 에러 발생
        // ~> 추상 클래스는 본체가 없기 때문에 구체적인 내용이 존재하지 않아 인스턴스화 할 수 없기 때문이다.

        // 그래서 먼저 추상 클래스인 Abstract 클래스를 상속한 하위 클래스를 만들고
        // Abstract 클래스를 '오버라이드'해서 '본체(내용)가 있는 메소드'를 만들어야 한다.
        Abstract_inheritance ai = new Abstract_inheritance();
        System.out.println(ai.B());
    }
}
