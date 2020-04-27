// Polymorphism(다형성)
// ~> 하나의 메소드나 클래스가 있을 때, 이것이 다양한 방법으로 동작하는 것.

// 'overloading'은 가장 쉬운 다형성의 일반적인 예
class O {
    public void a (int param) {
        System.out.println("숫자 출력");
        System.out.println(param);
    }
    public void a (String param) {
        System.out.println("문자 출력");
        System.out.println(param);
    }
}

// 클래스와 다형성
// 클래스 Y는 클래스 X를 상속하고 있다. 이런 경우, 클래스 Y는 클래스 X를 '데이터 타입'으로 삼을 수 있다.
class X {
    public String x() {return "X.x";}
}
class Y extends X {
    public String x() {return "Y.x";}
    public String y() {return "y";}
}

// 아래의 1번, 2번에 대한 정리를 좀 더 알아보자.
class A1 {
    public String a() {return "A1.a";}
}
class B1 extends A1 {
    public String a() {return "B1.a";}
    public String b() {return "B1.b";}
}
class B2 extends A1 {
    public String a() {return "B2.a";}
}

public class ex14_다형성_polymorphism {
    public static void main(String[] args) {
        O o = new O();
        o.a(1);
        o.a("one");
        // 이렇게 메소드 a는 같은 이름을 가지고 있지만 서로 다른 동작을 하고 있다.

        X obj = new Y();
        // 이렇게 하위 클래스가 상속 받은 상위 클래스를 '데이터 타입'으로 삼을 수 있다.
        obj.x();
        // obj.y(); ~> 이렇게는 사용할 수 없다.
        // 클래스 Y는 메소드 y를 가지고 있지만, 마치 메소드 y가 없는 것처럼 실행되지 않는다.

        Y obj2 = new Y();
        obj2.y(); // ~>이렇게 하면 이제서야 메소드 y가 실행된다.

        // 즉 클래스 Y의 데이터 형을 클래스 X로 하면 Y는 마치 X처럼 동작하게 된다.
        // 그래서 클래스 Y를 쓰는 사람은 Y를 X인 것처럼 사용하면 된다.
        // 이런 이유를 알기 위해 이렇게 실행되지 않았던 아래의 원래 코드를 수정해 보자
        /*
        class X {
            public String x() {return "X";}
        }
        class Y extends X {
            public String y() {return "Y";}
         }
        */
        X object = new Y();
        System.out.println(object.x());
        // 클래스 A의 메소드 x를 클래스 B에서 오버라이딩하고 있다.
        // 실행 결과는 Y.x

        // 1. 클래스 Y의 데이터 타입을 클래스 X로 인스턴스화 했을 때,
        //    클래스 Y의 메소드 y는 마치 존재하지 않는 것처럼 실행되지 않았다.
        //    ---> 클래스 Y가 클래스 X화 되었다.
        // 2. 클래스 Y의 데이터 타입을 클래스 X로 해서 인스턴스화 했을 때,
        //    클래스 Y의 메소드 x를 실행하면 클래스 X에서 정의한 x(X.x)가 아닌,
        //    클래스 Y에서 정의한 x(Y.x)가 실행 되었다.
        //    ---> 클래스 Y의 기본적인 성질은 그대로 유지하고 있다.
        // 정리하자면,
        // 클래스 Y를 클래스 X의 데이터 타입으로 인스턴스화 했을 때,
        // 클래스 X에 '존재하는 멤버'만이 클래스 Y의 멤버가 된다.
        // 동시에 클래스 Y에서 오버라이딩한 멤버의 동작방식은 그대로 유지한다.

        A1 object_b1 = new B1();
        A1 object_b2 = new B2();
        System.out.println(object_b1.a()); // ~> B1.a
        System.out.println(object_b2.a()); // ~> B2.a
        // 서로 다른 클래스 B1와 B2가 동일한 데이터 타입 A1으로 인스턴스화 되었다.
        // 그러나 두 인스턴스의 메소드 x를 호출한 결과는 서로 다르다.
    }
}
