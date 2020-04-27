// 'enum'은 '열거형(enumerated type)'이라고 부른다.
// 열거형은 '서로 연관된 상수들의 집합'이라고 할 수 있다.
// 여기서는 'Fruit'와 'Company'가 말하자면 '열거'인 셈이다.
enum Fruit_enum {
    APPLE, PEACH, BANANA;
}

enum Company_enum {
    GOOGLE, APPLE, ORACLE;
}
// 'enum'은 'class', 'interface'와 동급의 형식을 가지는 단위다.
// 하지만 'enum'은 사실상 'class'이다.
// 편의를 위해서 'enum'만을 위한 문법적 형식을 가지고 있기 때문에 구분하기 위해서
// 'enum'이라는 키워드를 사용하는 것이다.
// (참고로 역시 'enum'은 클래스이기 때문에 앞서 만든 클래스와 이름이 중복 될 수 없다)

// 이 코드는 사실상 아래와 같다.
/*
class Fruit{
    public static final Fruit APPLE  = new Fruit();
    public static final Fruit PEACH  = new Fruit();
    public static final Fruit BANANA = new Fruit();
    private Fruit() {}
}
 */
// ~> 생성자의 접근 제어자가 'private'이다.
// 이것은 클래스 안에서만 사용 가능하므로 클래스 'Fruit'를 인스턴스로 만들수 없다는 것을 의미한다.
// 즉, 다른 용도로 사용하는 것을 금지하는 것이다.

public class ex19_상수_enum_3 {
    public static void main(String[] args) {
        /*
        if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }
        */
        // ~> 'enum'을 사용하면 이때 에러가 발생한다.
        // 'enum'이 서로 다른 상수 그룹에 대한 비교를 컴파일 시점에서 차단할 수 있다는 것을 의미한다.
        // 상수 그룹 별로 클래스를 만든 것의 효과를 'enum'도 갖는다는 것을 알 수 있다.
        Fruit_enum type = Fruit_enum.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal");
                break;
            case PEACH:
                System.out.println(34+" kcal");
                break;
            case BANANA:
                System.out.println(93+" kcal");
                break;
        }
        // enum을 사용하는 이유를 정리하면 아래와 같다.
        // 1. 코드가 단순해진다.
        // 2. 인스턴스 생성과 상속을 방지한다.
        // 3. 키워드 'enum'을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.
    }
}

