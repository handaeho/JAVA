// 그런데 프로그램이 커지면서 누군가 그 과일을 만든 기업에 대한 상수가 필요해졌다.


// 그럼 컴파일러가 이런 실수를 사전에 찾아줄 수 있게 하려면 어떻게 해야 할까?
// 바로 'Class'를 만들고 클래스 변수로 해당 클래스의 인스턴스를 사용한다.
// 각각의 변수가' 'final'이기 때문에 불변이고, 'static'이므로 인스턴스로 만들지 않아도 된다.
class Fruit{
    public static final Fruit APPLE  = new Fruit();
    public static final Fruit PEACH  = new Fruit();
    public static final Fruit BANANA = new Fruit();
}

class Company{
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}

public class ex19_상수_enum_2 {
    // fruit
    private final static int FRUIT_APPLE = 1;
    private final static int FRUIT_PEACH = 2;
    private final static int FRUIT_BANANA = 3;

    // company
    private final int COMPANY_GOOGLE = 1;
    private final int COMPANY_APPLE = 2;
    private final int COMPANY_OLACLE = 3;
    // 그런데 과일 'APPLE'와 기업 'APPLE'이 서로 같은 이름을 가져서
    // 과일 'APPLE'의 값인 1이 기업 'APPLE'때문에 2로 바뀌고 에러가 발생한다.

    // 그래서 과일이면 'FRUIT_이름', 기업이면 'COMPANY_이름'으로 접두사를 붙였다.
    // 그런데 계속 이렇게 할 수도 없고, 일단 너무 지저분하다.

    // 바로 이 때, '인터페이스'를 사용할 수 있다.
    interface FRUIT {
        int APPLE = 1, PEACH = 2, BANANA = 3;
    }
    interface COMPANY {
        int GOOGLE = 1, APPLE = 2, OLACLE = 3;
    }
    // 훨씬 깔끔하다.
    // 인터페이스를 이렇게 사용할 수 있는 것은
    // 인터페이스에서 선언된 변수는 무조건 'public static final'의 속성을 갖기 때문이다.

    public static void main(String[] args) {
        //int type = FRUIT.APPLE;

        // 그런데 type의 값으로 누군가 COMPANY_GOOGLE을 사용했다면 어떻게 될까?
        int type = COMPANY.GOOGLE;
        // '57 kcal'가 나오게 된다. 'GOOGLE'이 '57 kcal'가 되어버린 것이다.

        // 우리 코드는 과일과 기업이라는 두 개의 상수 그룹이 존재한다.
        // 이 코드는 서로 다른 상수그룹의 비교를 시도했고 양쪽 모두 값이 정수 1이기 때문에
        // 오류를 사전에 찾아주지 못하고 있다.
        // 그럼 'Class'를 사용해 볼까?

        switch (type) {
            case FRUIT.APPLE:
                System.out.println(57 + " kcal");
                break;
            case FRUIT.PEACH:
                System.out.println(34 + " kcal");
                break;
            case FRUIT.BANANA:
                System.out.println(93 + " kcal");
                break;
        }

        // if(Fruit.APPLE == Company.APPLE){
            // System.out.println("과일 애플과 회사 애플이 같다.");
        // 클래스를 만듦으로써 결과는 여기서 에러가 발생한다.
        // 이것이 우리가 바라던 것이다. 서로 다른 카테고리의 상수에 대해서는 비교조차 금지하게 된 것이다.
        // 언제나 오류는 컴파일 시에 나타나도록 하는 것이 바람직하다.
        // 실행 중에 발생하는 오류는 찾아내기가 더욱 어렵다.

        // 그런데 위의 코드는 두 가지 문제점이 있는데
        // 하나는 switch 문에서 사용할 수 없고
        // 또 하나는 선언이 너무 복잡하다는 것이다.
    }
}
