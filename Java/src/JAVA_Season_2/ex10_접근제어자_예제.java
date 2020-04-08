package JAVA_Season_2;

// 앞에서 보았던 Calculator 기능을 접근제어자를 사용해 업그레이드 해보자
class Calculator_access_modifier {
    // class 변수인 left, right는 외부에서 호출될 필요가 없다.
    // 따라서 'private'로 설정해 이 클래스 밖에서는 접근 하지 못하게 한다.
    private int left, right;

    // 이 메소드는 두 값을 외부에서 받아와야하므로 'public'으로 설정해 외부 클래스에서 이 메소드에 접근할 수 있게 한다.
    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    // 이 메소드는 덧셈 연산을 위한 메소드로 외부에서 접근할 필요가 없다.
    // 따라서 'private'로 설정해 이 클래스 밖에서는 접근 하지 못하게 한다.
    private int _sum() {
        return this.left + this.right;
    }

    // 이 메소드는 덧셈 연산의 결과를 출력하기 위한 메소드이므로
    // 'public'으로 설정해 외부 클래스에서 이 메소드에 접근할 수 있게 한다.
    public void sum_1() {
        System.out.println("+++++ " + _sum() + " +++++");
    }

    // 이 메소드는 덧셈 연산의 결과를 출력하기 위한 메소드이므로
    // 'public'으로 설정해 외부 클래스에서 이 메소드에 접근할 수 있게 한다.
    public void sum_2() {
        System.out.println("----- " + _sum() + " -----");
    }

}
public class ex10_접근제어자_예제 {
    public static void main(String[] args) {
        // Calculator_access_modifier 클래스의 인스턴스 cam 생성
        Calculator_access_modifier cam = new Calculator_access_modifier();

        cam.setOperands(10, 20);
        cam.sum_1();
        cam.sum_2();
        // 이곳은 Calculator_access_modifier 클래스가 아닌 외부 클래스이므로
        // 'public'으로 설정된 3개의 메소드만 접근 가능하다.
    }
}
