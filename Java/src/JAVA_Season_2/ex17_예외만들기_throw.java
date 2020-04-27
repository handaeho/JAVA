// 지금까지는 API가 던지는 예외를 소비자로써 처리했다면, 이번에는 API의 생산자로서 예외를 직접 만들어보자.
class Calculator_E {
    int left, right;

    public void setOprands (int left, int right) {
        this.left = left;
        this.right = right;
        // 조치 1번. setOprands의 두번째 인자로 0이 들어오면 예외를 발생.
        if (right == 0) {
            throw new IllegalArgumentException("두번째 파라미터는 0이 될 수 없습니다.");
        }
    }
    public void divide() {
        // 조치 2번. 메소드 divide를 실행할 때 right의 값이 0이라면 예외를 발생시킨다.
        if (right == 0) {
            throw new IllegalArgumentException("두번째 파라미터는 0이 될 수 없습니다.");
        }
        try {
            System.out.println("계산 결과는 " + this.left/this.right + " 입니다!");
        } catch (Exception e) {
            System.out.println("\n\ne.getMessage()\n"+e.getMessage());
            System.out.println("\n\ne.toString()\n"+e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }
    }
}

public class ex17_예외만들기_throw {
    public static void main(String[] args) {
        Calculator_E cal_e = new Calculator_E();
        cal_e.setOprands(10, 0);
        cal_e.divide();
        // 이렇게 0으로 나누기를 시도할 때, 우리가 할 수 있는 조치는
        // 1. setOprands의 두번째 인자로 0이 들어오면 예외를 발생시킨다.
        // 2. 메소드 divide를 실행할 때 right의 값이 0이라면 예외를 발생시킨다.

        // 'throw'는 앞서 공부한 것처럼, 개발자가 강제로 '예외를 발생시키는 것'이다.
        //  throw 뒤에는 예외 정보를 가지고 있는 예외 클래스가 위치한다.
        //  자바 가상 머신은 이 클래스를 기준으로 어떤 catch 구문을 실행할 것인지를 결정한다.
        //  또 실행되는 catch 구문에서는 예외 클래스를 통해서 예외 상황의 원인에 대한 다양한 정보를 얻을 수 있다.
        //  이 정보를 바탕으로 문제를 해결하게 된다.

        /*
        <주요 Exception>
            예외	                      사용해야 할 상황
            IllegalArgumentException	매개변수가 의도하지 않은 상황을 유발시킬 때
            IllegalStateException	    메소드를 호출하기 위한 상태가 아닐 때
            NullPointerException	    매개 변수 값이 null 일 때
            IndexOutOfBoundsException	인덱스 매개 변수 값이 범위를 벗어날 때
            ArithmeticException	        산술적인 연산에 오류가 있을 때
         */
    }
}
