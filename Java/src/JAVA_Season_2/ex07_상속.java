package JAVA_Season_2;

// <상속>
// = 말 그대로 물려준다는 뜻.
// 어떤 객체가 있을 때, 그 객체의 필드(변수)와 메소드를 다른 객체가 물려 받는 것이다.

// 앞에서 보았던 Calculator의 기능을 예제로 살펴보자
class Calculator_inheritance {
    int left, right;

    // 생성자
    public Calculator_inheritance(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

// 'Calculator_inheritance' 객체를 물려받고 새롭게 빼기 기능을 추가해보자
class Calculator_inheritance_add_substract extends Calculator_inheritance {

    // 부모 클래스에 생성자가 있을 경우, 물려받는 자식 클래스에도 생성자가 필요하다.
    // 물론 생성자 메소드의 이름은 자식 클래스의 이름과 같으며
    // 인스턴스 변수의 이름과 지역 변수의 이름이 같을 경우 인스턴스 변수 앞에 this 키워드를 사용하여 구분할 수 있다.
    // 이와 마찬가지로 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 사용하여 구별할 수 있다.
    // 이렇게 자바에서는 super 참조 변수를 사용하여 부모 클래스의 멤버에 접근할 수 있다.
    // this와 마찬가지로 super 참조 변수를 사용할 수 있는 대상도 인스턴스 메소드뿐이며, 클래스 메소드에서는 사용할 수 없다.
    public Calculator_inheritance_add_substract(int left, int right) {
        super(left, right);
        // super = 상위 클래스의 멤버를 가리키는 키워드
        // 주의할 점: 하위 클래스의 생성자에서는 반드시 'super'가 먼저 나와야 한다.
        // 부모가 초기화 되기 전에 자식이 초기화 되는 일을 방지 하기 위함
    }

    // 빼기 메소드
    public void substract() {
        System.out.println(this.left - this.right);
    }
}

// Calculator_inheritance 클래스를 상속받아 곱셈 기능 추가
class Calculator_inheritance_add_multiple extends Calculator_inheritance {

    // 여기도 마찬가지로 자식의 생성자
    public Calculator_inheritance_add_multiple(int left, int right) {
        super(left, right);
    }

    // 곱셈 메소드
    public void multiple() {
        System.out.println(this.left * this.right);
    }
}

// 자식 클래스 Calculator_inheritance_add_multiple를 다시 상속 받아 나누기 기능 추가
class Calculator_inheritance_add_division extends Calculator_inheritance_add_multiple {

    // 자식 클래스 생성자
    public Calculator_inheritance_add_division(int left, int right) {
        super(left, right);
    }

    public void division() {
        System.out.println(this.left / this.right);
    }
}

public class ex07_상속 {
    public static void main(String[] args) {
        Calculator_inheritance c1 = new Calculator_inheritance(10, 20);
        c1.sum();
        c1.avg();

        // 그런데 이때 '빼기' 기능을 추가하고 싶다면...
        // ---> 기존의 'Calculator_inheritance' 클래스라는 객체는 그대로 유지하면서
        // 기능은 물려받고 새로운 기능을 추가하는 방법이 바로 '상속'
        Calculator_inheritance_add_substract c2 = new Calculator_inheritance_add_substract(10, 20);
        c2.sum();
        c2.avg();
        c2.substract();
        // ~> 이렇게 Calculator_inheritance_add_substract 클래스는 Calculator_inheritance 클래스의
        // 기능은 유지하고 새로운 빼기 기능을 추가해 쓸 수 있다.

        // 그렇다면 이번에는 곱셈 기능을 추가해 보자.
        Calculator_inheritance_add_multiple c3 = new Calculator_inheritance_add_multiple(10, 20);
        c3.sum();
        c3.avg();
        c3.multiple();

        // 부모에게서 상속을 받은 자식 클래스를 또다시 상속할 수 있을까?
        Calculator_inheritance_add_division c4 = new Calculator_inheritance_add_division(10, 20);
        c4.sum();
        c4.avg();
        c4.multiple();
        c4.division();
    }
}
