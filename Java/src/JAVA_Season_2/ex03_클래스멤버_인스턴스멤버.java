package JAVA_Season_2;

class Calculator_pi {
    static double PI = 3.14; // 'static'을 변수 앞에 붙이면 '클래스의 멤버'가 된다
    static int base = 0; // 또한 클래스 멤버 변수는 이 변수의 변경사항을 모든 인스턴스에서 공유해야 할 때도 사용할 수 있다
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right + base);  // 이렇게 클래스 멤버 변수를 포함시켰다
    }

    public void avg() {
        System.out.println((this.left + this.right + base) / 2);
    }
}

public class ex03_클래스멤버_인스턴스멤버 {
    // 객체의 멤버 = 변수 / 메소드
    // 즉, 클래스의 멤버 -> 변소 / 메소드
    // 인스턴스의 멤버 -> 변수 / 메소드
    public static void main(String[] args) {
        // 인스턴스 변수마다 다른 값을 가지게 할 수도 있지만, 같은 값을 공유하게 할 수 도 있다.
        Calculator_pi c1 = new Calculator_pi();
        System.out.println(c1.PI);

        Calculator_pi c2 = new Calculator_pi();
        System.out.println(c2.PI);
        // ~> c1, c2는 '인스턴스를 통해' PI에 접근

        System.out.println(Calculator_pi.PI);
        // ~> 이번에는 '클래스를 통해' PI에 접근
        // 클래스의 sum, avg 메소드는 필요없고 오직 PI만 알고 싶을 때는 인스턴스를 생성할 필요 없이
        // 이렇게 클래스를 통해서 접근 할 수 있다.

        Calculator_pi cc1 = new Calculator_pi();
        cc1.setOprands(10, 20);
        cc1.sum();

        Calculator_pi cc2 = new Calculator_pi();
        cc2.setOprands(30, 50);
        cc2.avg();

        Calculator_pi.base = 100;
        // ~> 이렇게 클래스를 통해 멤버 변수에 접근함으로써 인스턴스의 생성 없이 단순히 클래스 변수의 값만 변경한다.

        cc1.sum();
        cc2.avg();

        // 따라서 클래스 멤버 변수의 용도는 다음과 같다
        // - 인스턴스에 따라서 변하지 않는 값이 필요한 경우(단, 이런 경우 'final'을 사용해 상수로 선언하는 것이 바람직)
        // - 인스턴스를 생성할 필요가 없는 값을 클래스에 저장하고 싶을 때
        // - 값의 변경 사항을 모든 인스턴스가 공유해야 할 때
    }
}
