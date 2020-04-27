import java.io.IOException;

// 예외의 여러가지 상황들을 살펴보자
class E {
    void throwArithmeticException() {
        throw new ArithmeticException(); // ~> 정상적으로 컴파일 가능
    }
    void throwIOException() {
        // throw new IOException(); ~> 컴파일 불가
        // 'unreported exception IOException; must be caught or declared to be thrown'
        // ~> 'IOException'은 'try ~ catch'하거나 'throw' 해야 한다

        // ArithmeticException, IOException 모두 Exception이다.
        // 그럼에도 불구하고 유독 'IOException'만 'try ~ catch' 혹은 'throw' 를 해야 한다는 뜻이다.
        // 자바는 이 두개의 예외를 다른 방법으로 대하고 있는 것
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void throwIOException2() throws IOException {
        throw new IOException();
    }
}
// ~> 핵심은 'IOException'은 '예외처리를 강제'하고 있지만 'ArithmeticException'은 '그렇지 않다'

// 이유?
// = ArithmeticException의 부모 클래스 중에 java.lang.Exception 클래스가 있다.
// 즉, ArithmeticException 클래스는 Exception 클래스의 하위 클래스였던 것.
// 그렇기 때문에 Exception 클래스가 더 많은 예외 상황을 포괄하는 것이고
// ArithmeticException 클래스는 더 구체적인 상황을 특정하는 것이다.

// 즉 예외로 '던질 수 있는' 클래스는 반드시 Throwable 클래스를 상속 받아야 한다.

// <중요한 예외 클래스>
// 1. Throwable
// 2. Error
// 3. Exception
// 4. Runtime Exception

// 1. 클래스 'Throwable' ---> 던질수 있는
// = 범 예외 클래스들의 공통된 조상. 모든 예외 클래스들이 가지고 있는 공통된 메소드를 정의하고 있다.

// 2. 클래스 'Error'
// = 애플리케이션의 문제가 아니라 그 애플리케이션이 동작하는 가상머신에 문제가 생겼을 때 발생하는 예외
//   애플리케이션을 구동시키기에는 메모리가 부족한 경우가 이에 속한다.

// 3. 클래스 'Exception' / 4. 클래스 'Runtime Exception'
// = checked 예외 - 'RuntimeException'을 제외한 'Exception'의 하위 클래스
//   unchekced 예외 - 'RuntimeException'의 하위 클래스
// ~> checked 예외는 반드시 예외처리를 해야 하는 되는 것이고, unchekced는 해도 되고 안 해도 되는 예외
//    바로 이 지점이 'IOException'과 'ArithmeticException'의 차이점

// API 문서를 보면 'ArithmeticException'의 부모 중에 'RuntimeException'이 있다.
// 반면에 'IOException'은 'Exception'의 자식이지만 'RuntimeException'의 자식은 아니다.
// 이런 이유로 'IOException'은 'checked'이고 'ArithmeticException'은 'unchekced'이다. ('Error'도 'unchecked'이다)

// 나만의 예외를 직접 만들기

// 예외를 만들기 전에 해야 할 것은 자신의 예외를 checked로 할 것인가? unchecked로 할 것인가를 정해야 한다.
// API 쪽에서 예외를 던졌을 때 API 사용자 쪽에서 예외 상황을 복구 할 수 있다면 checked 예외를 사용한다.
// checked 예외는 사용자에게 문제를 해결할 기회를 주는 것이면서 예외처리를 강제하는 것이다.
// 하지만 checked 예외를 너무 자주 사용하면 API 사용자를 몹시 힘들게 할 수 있기 때문에 적정선을 찾는 것이 중요하다.

// 반면, 사용자가 API의 사용방법을 어겨서 발생하는 문제거나 예외 상황이 이미 발생한 시점에서
// 그냥 프로그램을 종료하는 것이 덜 위험할 때 unchecked를 사용한다.

// 기존의 ArithmeticException을 직접 만든 Exception으로 교체해보자.
class DivideException extends RuntimeException {
    DivideException() {
        super();
    }
    DivideException (String message) {
        super(message);
    }
}
class Calculator_Ex {
    int left, right;

    public void setOprands (int left, int right) {
        this.left = left;
        this.right = right;
    }
    public void divide() {
        if (this.right == 0) {
            throw new DivideException("0으로 나누기는 안됩니다!");
        }
        System.out.println(this.left / this.right);
    }
}

// 만약 'DivideException'을 위처럼 'RuntimeException'이 아닌 'Exception'으로 바꾸면 어떻게 될까?
class DivideException2 extends Exception {
    DivideException2() {
        super();
    }
    DivideException2 (String message) {
        super(message);
    }
}
class Calculator_Ex2 {
    int left, right;

    public void setOprands (int left, int right) {
        this.left = left;
        this.right = right;
    }
    // 방법 2. 사용자에게 예외 던지기 (당연히 이때는 방법 1의 try ~ catch 구문은 없다)
    public void divide() throws DivideException2{
        if (this.right == 0) {
            // 방법 1. 해당 클래스 또는 메소드 안에서 예외처리를 하기
            try {
                throw new DivideException2("0으로 나누기는 안됩니다!");
            } catch (DivideException2 e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.left / this.right);
    }
}

public class ex17_예외만들기_throw_2 {
    public static void main(String[] args) {
        Calculator_Ex cal_ex = new Calculator_Ex();
        cal_ex.setOprands(10, 0);
        cal_ex.divide();
        // Exception in thread "main" DivideException: 0으로 나누기는 안됩니다!

        Calculator_Ex2 cal_ex2 = new Calculator_Ex2();
        cal_ex2.setOprands(10, 0);
        // cal_ex2.divide();
        // 컴파일 에러 발생
        // 이를 해결하기 위해서는 2가지 방법이 있다.
        // 방법 1. 해당 클래스 또는 메소드 안에서 예외처리를 하기
        // 방법 2. 사용자에게 예외 던지기
        try {
            cal_ex2.divide();
        } catch (DivideException2 e) {
            e.printStackTrace();
        }
    }
}
