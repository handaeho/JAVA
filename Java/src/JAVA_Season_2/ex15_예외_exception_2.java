// '0으로 나누기' 이외에도 더 다양한 예외 상황들을 알아보자

class ex {
    private int[] arr = new int[3];
    ex() {
        arr[0] = 0;
        arr[1] = 10;
        arr[2] = 20;
    }
    public void z(int first, int second) {
        try {
            System.out.println(arr[first] / arr[second]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("***** ArrayIndexOutOfBoundsException *****");
        } catch (ArithmeticException e) {
            System.out.println("***** ArithmeticException *****");
        } catch (Exception e) {
            System.out.println("***** Exception *****");
        } finally {
            System.out.println(" ***** Finally ***** ");
        }

    }
}

public class ex15_예외_exception_2 {
    public static void main(String[] args) {
        ex e = new ex();
        e.z(10, 1);
        // 최대 크기가 3인 배열에서 10번째 인덱스를 호출하므로 'ArrayIndexOutOfBoundsException: 10' 발생
        // 예외 처리(try ~ catch)를 통해 '***** ArrayIndexOutOfBoundsException *****' 출력
        e.z(1, 0);
        // 0으로 나누기를 실행하므로 'ArithmeticException: / by zero' 발생
        // // 예외 처리(try ~ catch)를 통해 '***** ArithmeticException *****' 출력

        e.z(2, 1);
        // 2
        // 정상 실행

        // 이렇게 하나의 'try'에 다중으로 'catch'를 사용할 수 있다.
        // 그리고 여기서 중요한 점은
        // 'Exception'이 'ArrayIndexOutOfBoundsException', 'ArithmeticException' 보다 포괄적인 예외를 의미하기 때문에
        // Exception 이후에 등장하는 catch 문은 실행될 수 없는 구문이 된다.
        // 따라서 만약 다중으로 'catch'를 사용하고자 한다면 'Exception'은 제일 나중에 쓰도록 하자.

        //  ***** Finally *****
        // 'finally'는 예외 여부와 상관없이 반드시 실행되는 로직을 담고 있다.
        // 예를 들어 데이터베이스 서버에 접속해 어떤 작업을 한다면 예외 여부와 관계없이 작업이 끝나면
        // 반드시 접속을 끊어야하므로 그 때의 로직을 이 'finally'에 작성한다.
    }
}
