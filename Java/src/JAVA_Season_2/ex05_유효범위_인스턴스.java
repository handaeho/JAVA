package JAVA_Season_2;

// 이번에는 '인스턴스에서의 유효범위'를 알아보자 ~~~> 'this'

class C {
    int v = 10;

    void m() {
        System.out.println(v);
    }
}

class C2 {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(v);
    }
}

class C3 {
    // 그럼 이런 상황에서 메소드 m에서 인스턴스 변수 v(v=10)에 접근하려면? ~~~> 'this'를 사용
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(this.v);
    }
}

public class ex05_유효범위_인스턴스 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.m();
        // ~> 이때 결과는 10

        C2 c2 = new C2();
        c2.m();
        // ~> 이때 결과는 20
        // 즉, 클래스에서 선언된 v보다 메소드 안에서 선언된 v가 우선순위가 높아 v=20이 되는 것.

        C3 c3 = new C3();
        c3.m();
        // ~> 이때 결과는 10
        // this를 사용해서 메소드 m에서 인스턴스 변수 v=10에 접근한 것
    }
    // 정리하자면 연관된 변수와 메소드를 그룹화하여 전역변수를 조금 더 자유롭게 사용할 수 있다.
    // 그러나 객체지향 프로그래밍의 개념에 맞게 가급적이면 전역변수의 사용을 최소화하고 지역변수를 사용함으로써 모듈화를 하자
}
