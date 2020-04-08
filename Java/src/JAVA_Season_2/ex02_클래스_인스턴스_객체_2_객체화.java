package JAVA_Season_2;

class Calculator {
    // 변수 left, right와 메소드 sum, avg는 서로 연관되어 있다.
    // 이를 Calculator라는 그룹으로 묶는다. ~~> 클래스 선언

    int left, right;    // 전역 변수 선언

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
        // this = 클래스를 통해 만들어진 인스턴스 자신
        // 파이썬에서 self라고 생각하자
    }
    public void sum() {
        System.out.println(this.left + this.right);
    }
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

public class ex02_클래스_인스턴스_객체_2_객체화 {
    // 객체화
    // 합계를 계산하는 sum() 메소드와 평균을 계산하는 avg() 메소드는 둘 다 일단 값을 더한다는 연관성이 있다.
    // 이때 객체 지향의 핵심은 '연관된 변수와 메소드를 하나의 그룹으로 묶는 것'이다.
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        // ~> 'new'를 사용해서 클래스를 구체화한다. 즉, '인스턴스화'한다.
        // 그리고 c1은 이 인스턴스를 담을 그릇이라고 생각하면 된다. 그리고 이 변수의 데이터 타입은 '클래스'인 것이다.

        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();

        Calculator c2 = new Calculator();

        c2.setOprands(20, 30);
        c2.sum();
        c2.avg();

        // 즉, 이렇게 하나의 클래스(Calculator)를 서로 다른 인스턴스(c1, c2)로 만들면 서로 다른 행동을 하게 할 수 있다.
        // 하나의 클래스가 서로 다른 인스턴스로 만들어지면서 '사용성이 높아진다'.
    }


}
