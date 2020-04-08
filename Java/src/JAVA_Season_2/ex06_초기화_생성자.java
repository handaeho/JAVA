package JAVA_Season_2;

class Calculator_ex {
    int left, right;

//    public void setOprands(int left, int right) {
//        this.left = left;
//        this.right = right;
//    } -------------------------> 이 부분을 생성자를 사용하기 위해 아래와 같이 바꾼다.

    public Calculator_ex(int left, int right) {
        this.left = left;
        this.right = right;
    }
    // ------> 바로 이곳이 '생성자'. 객체를 생성할때 호출된다.
    // 즉, 인스턴스를 만들때 생성자가 호출되어 바로 초기값을 지정해 줄 수 있다.

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

public class ex06_초기화_생성자 {
    public static void main(String[] args) {
        // Calculator_ex c1 = new Calculator_ex();
        // c1.setOprands(10, 20);  // 이 값들은 객체 내부에서 인스턴스 변수 멤버로써 값을 유지한다.
        // c1.sum();
        // c1.avg();

        // 그런데 만약 인스턴스 변수에 값을 주지 않고 sum() 또는 avg()를 실행한다면 오류가 날 것이다.
        // Calculator_ex c1 = new Calculator_ex();
        // c1.sum();
        // c1.avg();
        // ~> 왜? 변수에 값이 없으니까 ---> 즉, '초기화'가 되지 않았다.

        // 그래서 이때 '생성자'를 사용하도록 하자. 클래스를 인스턴스로 만들때 초기화 값을 전달하는 것이다.
        Calculator_ex c1 = new Calculator_ex(10, 20);   // ~> 이렇게 초기값을 바로 지정할 수 있다
        c1.sum();
        c1.avg();
    }
    // 생성자의 특징
    // 1) 값을 리턴하지 않는다.
    //   ~> 생성자는 인스턴스를 생성해주는 특수한 메소드로써 리턴값이 있다면 엉뚱한 값이 나올수 있으므로
    //      return도 사용하지 않고 리턴값을 메소드 정의(이름)에 넣지도 않는다. 그래서 그냥 앞에 public만 붙은 것.
    // 2) 생성자의 이름은 클래스의 이름과 같다.
    //    ~> 이것은 자바에서의 약속이다. 꼭 클래스 이름과 생성자 이름은 같게 만들어주자.
}
