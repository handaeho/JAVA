package JAVA_Season_2;

// 그럼 이렇게 불편한 추상 클래스와 메소드를 사용하는 이유는?
// ~> 추상 클래스를 상위 클래스로 삼고 메소드의 시그니처만 정의하고
// 그 메소드의 실제 내용은 상속 받은 하위 클래스의 책임으로 돌린다.

// Calculator 기능으로 이를 파악해 보자

// 추상 클래스인 Calculator_Abstract 생성
abstract class Calculator_Abstract{
    int left, right;

    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    // 추상 메소드 sum()
    public abstract void sum(); // ~> 내용은 없고 정의만 되어있다.
    // 추상 메소드 avg()
    public abstract void avg(); // ~> 내용은 없고 정의만 되어있다.

    // 추상 클래스를 상속받은 하위 클래스가 인스턴스화 되고 run() 메소드를 호출해 sum, avg 메소드를 수행할 것이다
    public void run() {
        sum();
        avg();
    }
}

// 추상 클래스인 Calculator_Abstract를 상속받는 하위 클래스 Calculator_Abstract_inheritance
class Calculator_Abstract_inheritance extends Calculator_Abstract {
    // 추상 메소드인 sum을 오버라이드해 본체(내용)를 생성
    public void sum() {
        System.out.println("+++ SUM = " + (this.left + this.right));
    }
    // 추상 메소드인 avg를 오버라이드해 본체(내용)를 생성
    public void avg() {
        System.out.println("+++ AVG = " + ((this.left + this.right) / 2));
    }
}

// 추상 클래스인 Calculator_Abstract를 상속받는 하위 클래스 Calculator_Abstract_inheritance_2
class Calculator_Abstract_inheritance_2 extends Calculator_Abstract {
    // 추상 메소드인 sum을 오버라이드해 본체(내용)를 생성
    public void sum() {
        System.out.println("--- SUM = " + (this.left + this.right));
    }
    // 추상 메소드인 avg를 오버라이드해 본체(내용)를 생성
    public void avg() {
        System.out.println("--- AVG = " + ((this.left + this.right) / 2));
    }
}

public class ex11_추상_abstract_예제 {
    public static void main(String[] args) {
        // ~> 이렇게 합계 또는 평균을 구하긴 하지만,
        // 만약 "+++ SUM" 또는 "--- SUM"등으로 상황에 따라 다르게 출력해야만 하는 프로그램이라고 가정하면
        Calculator_Abstract_inheritance c1 = new Calculator_Abstract_inheritance();
        c1.setOperands(10, 20);
        c1.run();

        Calculator_Abstract_inheritance_2 c2 = new Calculator_Abstract_inheritance_2();
        c2.setOperands(10, 20);
        c2.run();
        // ~> 그러면 일단 상황에 따라 기능이 달라지는 메소드를 상위 클래스에 추상 메소드로 정의만 해놓은 다음,
        // 하위 클래스에서 상속받아 오버라이드해서 상황에 맞는 기능을 구현할 수 있게 한다.
        // 그리고 모든 클래스의 공통분모는 (여기서는 setOperands, run) 상위 클래스에 모아두어서 중복을 방지하고 유지보수를 쉽게한다.
    }
}
