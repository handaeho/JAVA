package JAVA_Season_2;

// 접근 제어자 = 클래스의 멤버(변수 & 메소드)들의 접근 권한을 제어한다.
// private -> default -> protected -> public
// 이를 통해, 접근할 필요가 없거나 접근해서는 안되는 멤버를 보호할 수 있고, 프로그래머의 실수를 예방할 수 있다

// 1) private
//    ~> 'private'가 붙은 변수나 메소드는 '해당 클래스 안에서만 접근'이 가능
// 2) default
//    ~> 접근제어자를 변도로 명시하지 않았을 때 'default'로 자동 설정. '해당 패키지 안에서만 접근'이 가능
// 3) protected
//    ~> 'protected'가 붙은 변수나 메소드는 '같은 패키지 안의 클래스 또는 그 클래스를 상속받은 외부 패키지의 클래스에서 접근' 가능
// 4) public
//    ~> 'public'이 붙은 변수나 메소드는 '어떤 클래스라도 접근' 가능

class A {
    public String y() {
        return "public y()";
    }

    private String z() {
        return "private z()";
    }

    public String x() {
        return z();
    }
    // 메소드 z는 private로 설정되어서 클래스 A 안에서만 접근이 가능하다
}

public class ex10_접근제어자 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.y());  // 'public'이므로 어떤 클래스에서든 접근 가능

        // System.out.println(a.z()); ~~~> 메소드 z는 클래스 A에서만 접근이 가능한 'private'이므로 여기서 접근 불가

        System.out.println(a.x());  // 'public'이므로 어떤 클래스에서든 접근 가능
    }

    // 클래스 멤버(변수&메소드) 뿐만 아닌, 클래스에도 접근제어자를 적용할 수 있다
    // 클래스 접근 제어자는 'public', 'default' 2개

    // public -> default
    // 1. public
    //    ~> 접근제어자가 'public'으로 설정된 클래스는 '다른 패키지의 클래스에서도 접근이 가능'하다
    // 2. default
    //    ~> 접근제어자가 'default'로 설정된 클래스는 '같은 패키지 안에서만 접근 가능'하다
    //       그리고 만약 별다른 명시가 없고 그냥 class라고 만들면 default가 되는 것이다

    // <중요한 제약사항>
    // 'public' 클래스의 클래스 이름과 '소스코드의 파일명'이 '같아야' 한다.
    // ~> 즉, 하나의 소스코드에는 하나의 public 클래스가 존재할 수 있다는 뜻
}
