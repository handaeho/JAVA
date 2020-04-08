package JAVA_Season_2;

class Calculator_2 {
    public static void sum(int left, int right) {
        System.out.println(left + right);
    }

    public static void avg(int left, int right) {
        System.out.println((left + right) / 2);
    }
}

class C1 {
    static int static_var = 1;  // 'static'을 붙이면 클래스의 멤버. 따라서 이 변수는 '클래스 변수'
    int instance_var = 2;       // 'static'이 없으므로 따라서 이 변수는 '인스턴스 변수'

    // 마찬가지로 'static'을 붙이면 클래스의 멤버가 되니까 이 메소드는 '클래스 메소드'
    static void static_static() {
        System.out.println(static_var);
        // 클래스 메소드니까 클래스 변수에 접근 가능
    }

    static void static_instance() {
        // System.out.println(instance_var);
        // ~> 에러. 클래스 메소드에서는 인스턴스 변수에 접근할 수 없다.
    }

    // 마찬가지로 'static'이 없으므로 이 메소드는 '인스턴스 메소드'
    void instance_static() {
        System.out.println(static_var);
        // ~> 인스턴스 메소드에서는 클래스 변수에 접근할 수 있다.
    }

    void instance_instance() {
        System.out.println(instance_var);
        // ~> 인스턴스 메소드니까 인스턴스 변수 접근 가능
    }
}

public class ex04_클래스메소드 {
    // 앞에서 살펴본 Calculator 클래스는 left, right 변수를 통해 sum과 avg를 계산한다.
    // 그런데 굳이 left, right 변수가 값을 고정하고 있을 필요는 없다.
    // sum을 구할 때와 avg를 구할 때 각각 left, right 변수의 값이 달라도 된다.
    public static void main(String[] args) {
        Calculator_2.sum(10, 20);
        Calculator_2.avg(10, 20);

        Calculator_2.sum(20, 40);
        Calculator_2.avg(20, 40);
        // 만약 메소드가 인스턴스 변수를 참조하지 않는다면 클래스 메소드를 사용해서 불필요한 인스턴스의 생성을 막을수 있다.

        // <중요 원칙>
        // 1. 인스턴스 메소드는 클래스 멤버에 접근할 수 있다.
        // 2. 클래스 메소드는 인스턴스 멤버에 접근할 수 없다.
        //    ~> 인스턴스 변수는 인스턴스가 만들어지면서 생성되는데, 클래스 메소드는 인스턴스 생성 전에 만들어지므로
        //       클래스 메소드가 인스턴스 변수에 접근하는 것은 존재하지 않는 변수에 접근하는 것과 같다.

        C1 c = new C1();    // C1 클래스의 인스턴스 c 생성

        // 인스턴스를 사용해 정적 메소드(클래스 메소드)에 접근 ---> 성공
        // 인스턴스를 사용해 정적 변수(클래스 변수)에 접근 ---> 성공
        c.static_static();

        // 인스턴스를 사용해 정적 메소드(클래스 메소드)에 접근 ---> 성공
        // 정적 메소드(클래스 메소드)가 인스턴스 변수에 접근 ---> 실패
        c.static_instance();

        // 인스턴스를 사용해 인스턴스 메소드에 접근 ---> 성공
        // 인스턴스 메소드가 클래스 변수에 접근 ---> 성공
        c.instance_static();

        // 인스턴스를 사용해 인스턴스 메소드에 접근 ---> 성공
        // 인스턴스 메소드가 인스턴스 변수에 접근 ---> 성공
        c.instance_instance();

        // 클래스를 사용해 클래스 메소드에 접근 ---> 성공
        // 클래스 메소드가 클래스 변수에 접근 ---> 성공
        C1.static_static();

        // 클래스를 사용해 클래스 메소드에 접근 ---> 성공
        // 클래스 메소드가 인스턴스 변수에 접근 ---> 실패
        C1.static_instance();

        // 클래스를 사용해 인스턴스 메소드에 접근 ---> 실패
        // C1.instance_static(); ~> 에러

        // 클래스를 사용해 인스턴스 메소드에 접근 ---> 실패
        // C1.instance_instance() ~> 에러
    }
}
