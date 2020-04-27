import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// throws VS throw

// 1. throws
// = 메소드나 생성자를 수행할 때 발생하는 예외를 선언할 때 사용하는 키워드.
// '예외가 발생'하면 자신이 처리하지 않고, '자신을 호출하는 메소드에게 책임을 전가'하는 것으로 볼 수 있다.
// 'throws'를 사용하면 그 메소드를 사용하는 곳에서 예외 처리를 해야 한다.
// 'Function throws SomeException' 형태를 생각해 보자.
// 'Function'이 'SomeException'을 '던진다'는 의미이므로 'Function'을 사용하는(받은) 곳을 'try' 블록으로 감싸준다
class Test1 {
    public static void f() throws ArithmeticException {
        int a = 0;
        a = 10 / a;
    }

    public static void main(String[] args) {
        try {
            Test1.f(); // 이 함수가 예외를 던진다.
        } catch (Exception e) {
            System.out.println("main() 메소드가 예외를 잡아서 처리한다! " + e);
        }
    }
}

// 2. throw
// = 프로그래머가 '강제로 예외를 발생'시키는 것.
// 'throw' 뒤에는 java.lang.Throwable 클래스를 상속받은 자식 클래스 객체를 지정해야 한다.
class Test2 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// 또 다른 예시
class Q1 {
    void run() {
        BufferedReader bReader = null;
        String input = null;
        try {
            bReader = new BufferedReader(new FileReader("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            input = bReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        // 클래스 Q1에서 'Q1.run'이 'FileReader'의 생성자와 'BufferedReader.readLine'가 던진 예외를
        // 'try ~ catch'로 처리한다.
        // 즉 'Q1.run'이 예외에 대한 책임을 지고 있다.

        System.out.println(input);
    }
}

// 그런데 Q.run이 예외 처리를 직접 하지 않고 다음 사용자 W.run에게 넘길 수 있다.
class Q2 {
    void run() throws IOException, FileNotFoundException{
        // ~> 'throws'로 예외를 사용자에게 '던짐'
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("out.txt"));
        input = bReader.readLine();
        System.out.println(input);
    }
}

class W {
    void run() {
        Q1 q = new Q1();
        q.run();
        // Q1은 예외처리를 자신이 직접 처리했기 때문에 사용자 W는 그냥 사용하면 된다.

        Q2 q2 = new Q2();
        try {
            q2.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Q2는 사용자인 W에게 예외 처리를 '전가(던짐)'했으므로
        // 사용자 W는 이렇게 'try ~ catch'로 Q2에 대한 예외 처리를 해주어야 한다.
    }
}

public class ex16_예외던지기_throws_2 {
    public static void main(String[] args) {
        W w = new W();
        w.run();
        // ex16_예외던지기_throw_throws_2.main(클래스 ex16_예외던지기_throw_throws_2의 메소드 main)은 W.run의 사용자이다.
        // 즉, Q1.run의 다음 사용자는 W.run이고 W.run의 다음 사용자는 ex16_예외던지기_throw_throws_2.main이 되는 셈이다.

        // Q2의 다음 사용자는 W이고, 이 W의 다음 사용자는 main이기 때문에
        // W가 예외를 처리하지 않고 main이 처리하게 할 수도 있다.
        Q2 q2 = new Q2();
        try {
            q2.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ~> Q가 예외 발생 시 처리를 다음 사용자에게 '던졌는데' 중간 사용자인 W가 어떻게 할 수 없는 일이라고 가정한다면,
        // 최종적으로 사용하는 main에게 그냥 넘겨주는 것이다. (main은 어플리케이션 실행 시, 진입점이기 때문)
    }
}
