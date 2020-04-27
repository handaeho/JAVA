// abstract 수업의  Calculator_Abstract 예제 코드를 조금 변경해 다형성의 사용 방법을 알아보자.

abstract class Calculator_Abstract {
    int left, right;

    public void setOprands (int left, int right) {
        this.left = left;
        this.right = right;
    }
    int _sum() {
        return this.left + this.right;
    }
    public abstract void sum();
    public abstract void avg();
    public void run() {
        sum();
        avg();
    }
}
class CalculatorDecoPlus extends Calculator_Abstract {
    public void sum() {
        System.out.println("+++ sum = " + _sum());;
    }
    public void avg() {
        System.out.println("+++ avg = " + (this.left + this.right) / 2);
    }
}
class CalculatorDecoMiuns extends Calculator_Abstract {
    public void sum() {
        System.out.println("--- sum = " + _sum());
    }
    public void avg() {
        System.out.println("--- avg = " + (this.left + this.right) / 2);
    }
}

public class ex14_다형성_polymorphism_2 {
    public static void execute(Calculator_Abstract cal_ab){
        System.out.println("실행결과");
        cal_ab.run();
    }
    // execute 메소드는 'CalculatorDecoPlus'와 'CalculatorDecoMinus' 클래스가
    // 'Calculator_Abstract'에게 상속받은 메소드 run을 호출하면서
    // 그것이 '실행 결과'라는 사실을 화면에 표시하는 기능을 가지고 있다.
    // 이 때 메소드 execute 내부에서는 매개변수로 전달된 객체의 메소드 run을 호출하고 있다.

    public static void main(String[] args) {
        Calculator_Abstract ca1 = new CalculatorDecoPlus();
        ca1.setOprands(10, 20);
        ca1.run();

        Calculator_Abstract ca2 = new CalculatorDecoMiuns();
        ca2.setOprands(10, 20);

        // 'Calculator_Abstract'를 상속받은 클래스들을 인스턴스화 할 때,
        // 'Calculator_Abstract'를 데이터 타입으로 사용하고 있다.
        // 이렇게 되면 인스턴스 ca1, ca2를 사용하는 입장에서는
        // 두개 모두 'Calculator_Abstract'처럼 사용할 수 있는 것이다.

        execute(ca1);
        execute(ca2);
        // 만약 메소드 execute의 매개변수 데이터 타입이 Calculator_Abstract가 아니라면 어떻게 해야할까?
        // 위와 같은 로직을 처리 할 수 없을 것이다.
        // 메소드 execute 입장에서는 매개변수로 전달된 값이 Calculator_Abstract이거나 그 자식이라면
        // 메소드 run을 가지고 있다는 것을 보장 받을 수 있게 되는 것이다.
        // 이 맥락에서의 다형성이란 하나의 클래스(Calculator_Abstract)가
        // 다양한 동작 방법(ClaculatorDecoPlus, ClaculatorDecoMinus)을 가지고 있는데 이것을 다형성이라고 할 수 있다.
    }
}
