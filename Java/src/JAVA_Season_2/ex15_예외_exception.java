// 프로그램을 만든 프로그래머가 상정한 정상적인 처리에서 벗어나는 경우에 이를 처리하기 위한 방법

/*

try ~ catch ~ finally

try {
        예외의 발생이 예상되는 로직
} catch (예외클래스 인스턴스) {
        예외 발생시 실행되는 로직
} finally {
        예외 여부와 상관없이 실행되는 로직
}

 */

class Calculator_exception {
    int left, right;

    public void setOprands (int left, int rigth) {
        this.left = left;
        this.right = rigth;
    }
    public void divide() {
        try {
            System.out.println("결과는 " + this.left / this.right);
        } catch (Exception e) {
            // e.getMessage() -> 오류에 대한 기본적인 내용 출력
            System.out.println("\\n\\ne.getMessage()\\n" + e.getMessage());;
            // e.toString() -> 'e.getMessage()' 보다 조금 더 자세한 정보 출력
            System.out.println("\n\ne.toString()\n"+e.toString());
            // e.printStackTrace() -> 메소드 'getMessage', 'toString'과는 다르게 'printStackTrace'는 리턴값이 없다.
            // 이 메소드를 호출하면 메소드가 내부적으로 예외 결과를 화면에 출력한다.
            // 'printStackTrace'는 가장 자세한 예외 정보를 제공한다.
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }
    }
}
public class ex15_예외_exception {
    public static void main(String[] args) {
        Calculator_exception cal_ex = new Calculator_exception();
        cal_ex.setOprands(10, 0);
        cal_ex.divide();
        // 오류 발생! -> / by zero

        Calculator_exception cal_ex2 = new Calculator_exception();
        cal_ex2.setOprands(10, 5);
        cal_ex2.divide();
        // 결과는 2
    }
}
