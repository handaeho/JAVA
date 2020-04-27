// 그런데 거대 소프트웨어에서는 조금 다르게 동작한다.
class A_ref {
    public int id;
    A_ref(int id) {
        this.id = id;
    }
}

public class ex20_복제_참조_2 {
    public static void runValue() {
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, " + a);
    }

    public static void runReference() {
        A_ref a = new A_ref(1);
        A_ref b = a;
        b.id = 2;
        System.out.println("runReference, " + a.id);
    }

    public static void main(String[] args) {
        runValue();
        runReference();
        // 이 때 결과는
        // runValue, 1
        // runReference, 2
        // ~> 20, 21행을 보면 변수 b에 담긴 인스턴스의 id 값을 2로 변경했을 뿐인데 a.id의 값도 2가 된 것이다.
        // 이것은 변수 b와 변수 a에 담긴 인스턴스가 서로 같다는 것을 의미하다
        // 바로 이것이 '참조(reference)'이다.
    }
}
