package JAVA_Season_2;

// 오버로딩(Overloading) ~> 메소드의 이름은 같지만 서로 다른 기능을 수행 할 수 있게 한다
// 예를 들어 test()라는 메소드가 시험 점수의 합을 계산한다고 하자.
// 그런데 이름이 같은 test()라는 다른 메소드는 시험 점수의 등급을 계산한다고 하면,
// 두 메소드의 이름은 test()로 같지만 서로 다른 기능을 수행 하게 되는 것이다.

// 앞에서 보았던 Calculator의 기능으로 오버로딩을 생각해 보자
class Calculator_overloading {
    int left, right;
    int thrid;  // ~> 새로운 변수 추가

    public void setOperands(int left, int right) {
        System.out.println("setOperands(int left, int right)");
        this.left = left;
        this.right = right;
    }

    // setOperands 메소드와 이름이 같지만 새로운 변수 third를 추가한 setOperands 메소드
    public void setOperands(int left, int right, int thrid) {
        System.out.println("setOperands(int left, int right, int third)");
        this.left = left;
        this.right = right;
        this.thrid = thrid;
    }

    public void sum() {
        System.out.println(this.left + this.right + this.thrid);
    }

    public void avg() {
        System.out.println((this.left + this.right + this.thrid) / 3);
    }
}

// 메소드 오버로딩의 조건
class overloading {
    void A () {System.out.println("void A");}
    void A (int arg1) {System.out.println("void A (int arg1)");}
    void A (String arg1) {System.out.println("void A (String arg1)");}
    // int A () {System.out.println("int A ()");} -----------> 여기는 에러.
    // 1, 2번은 파라미터의 개수가 다르다. 즉, 오버로딩이 가능하다
    // 2, 3번은 파라미터의 타입이 다르다. 즉, 오버로딩이 가능하다
    // 그러나 4번처럼 리턴 타입만 다르면 오버로딩이 불가하다.
    // ~> 메소드를 호출할 때, 파라미터의 개수와 타입에 따라 서로 다른 메소드라고 Java가 구분할 수 있지만
    //    리턴 타입은 메소드가 끝나야 알게 되는 것이지 호출할 때는 전달되지 않아서 구분할 수가 없다.
}

// 상속에서의 오버로딩
class overloading_inheritance extends overloading {
    void A (String arg1, String arg2) {System.out.println("sub_class: void A (String arg1, String arg2)");}
    void A () {System.out.println("sub_class: void A ()");}
    // 1번은 데이터 타입이 문자열인 파라미터 2개. 상위 클래스인 overloading 클래스에 이런 형식의 메소드 A가 없으므로 오버로딩 가능
    // 그러나 2번은 파라미터가 없다. 그리고 상위 클래스 overloding에 이런 형식의 메소드 A가 이미 존재하므로 오버로딩 불가
}

public class ex09_오버로딩_overloading {
    public static void main(String[] args) {
        Calculator_overloading c1 = new Calculator_overloading();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();

        c1.setOperands(10, 20, 30);
        c1.sum();
        c1.avg();
        // ~> 이렇게 이름은 setOperands로 같지만 파라미터의 개수는 다른 두개의 메소드를 사용할 수 있다.

        // <오버로딩의 규칙>
        // 결론적으로 말하면 메소드 오버로딩은 '파라미터'를 사용한다.
        // 즉, 메소드의 파라미터가 다르면 메소드 이름이 같아도 서로 다른 메소드가 되는 것이다.
        // 그리고 만약 파라미터는 같지만 리턴 타입이 다르면 에러가 발생한다.

        // 상속 관계에서도 오버로딩이 가능할까?
        overloading_inheritance c2 = new overloading_inheritance();
        c2.A();
        c2.A(1);
        c2.A("Have a nice day");
        c2.A("Hello", "World");
    }
}
