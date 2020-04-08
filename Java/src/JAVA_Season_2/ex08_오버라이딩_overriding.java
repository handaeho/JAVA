package JAVA_Season_2;

// '상속'은 '상위 클래스(부모 클래스)를 하위 클래스(자식 클래스)가 물려 받는 것'
// 그럼 하위 클래스는 부모클래스의 기능을 반드시 유지해야 할까?

// 오버라이딩(Overriding) ~> 하위 클래스가 상위 클래스의 기능을 수정할 수 있는 것

// 예를 들기 위해 다시 Calculator의 기능을 생각해 보자
class Calculator_overriding {
    int left, right;

    // 생성자
    public Calculator_overriding(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public int avg() {
       return (this.left + this.right) / 2;
    }
}

// Calculator_overriding 클래스를 상속 받는 하위 클래스
class Calculator_overriding_inheritance extends Calculator_overriding {

    // 하위 클래스 생성자
    public Calculator_overriding_inheritance(int left, int right) {
        super(left, right);
    }

    // 하위 클래스의 sum() 메소드의 결과가 상위 클래스의 결과와 다르다.
    public void sum() {
        System.out.println("result = " + (this.left + this.right));
    }
    // ~> 상위 클래스의 sum() 메소드의 리턴 타입이 int로 바뀌었으므로 여기도 똑같이

    // 그리고 새로운 빼기 기능 추가
    public void substract() {
        System.out.println(this.left - this.right);
    }
}

// 그리고 'super'를 쓰면 상위 클래스의 멤버를 가리키는 것이므로 변수 뿐만 아닌 메소드도 가리킬수 있다
class Calculator_overriding_inheritance_2 extends Calculator_overriding {

    // 하위 클래스 생성자
    public Calculator_overriding_inheritance_2(int left, int right) {
        super(left, right);
    }

    public void sum() {
        System.out.println("result = " + (this.left + this.right));
    }
    public int avg() {
        return super.avg(); // ---> 이렇게 'super.상위클래스의 메소드이름'을 가리켜 기능을 그대로 가져올 수 있다
    }
    // ~> 상위 클래스의 avg() 메소드의 리턴 타입이 int로 바뀌었으므로 여기도 똑같이

    public void substract() {
        System.out.println(this.left - this.right);
    }
}

public class ex08_오버라이딩_overriding {
    public static void main(String[] args) {
        // 상위 클래스의 인스턴스
        Calculator_overriding c1 = new Calculator_overriding(10, 20);
        c1.sum();
        c1.avg();

        // 하위 클래스의 인스턴스
        Calculator_overriding_inheritance c2 = new Calculator_overriding_inheritance(10, 20);
        c2.sum();
        c2.avg();
        c2.substract();
        // ~> 이렇게 하위 클래스에서 상위 클래스의 기능을 재정의 할 수 있다.

        // <오버라이딩의 조건>
        // 상속 받은 하위 클래스가 오버라이딩을 하기 위해서는 다음 조건을 충족 해야한다.
        // 1) 메소드의 이름이 같아야 한다.
        // 2) 메소드 파라미터의 개수와 데이터 타입, 순서가 같아야 한다.
        // 3) 메소드의 리턴 타입이 같아야 한다.
        //      ~> 상위 클래스인 Calculator_overriding 클래스의 sum(), avg() 메소드는 리턴 타입이 void (public void ~)
        //         즉, 아무것도 리턴하지 않고 있다.
        //         그런데 하위 클래스에서 avg() 메소드의 리턴 타입을 int로 바꾸고,
        //         출력하지 않고 결과를 리턴하겠다 하면 (public int ~ return ~)
        //         상위 클래스와 하위 클래스의 메소드 리턴 타입이 서로 달라 에러가 발생한다.

        Calculator_overriding_inheritance_2 c3 = new Calculator_overriding_inheritance_2(10, 20);
        c3.sum();
        System.out.println("결과는 " + c3.avg());
        c3.substract();
    }
}
