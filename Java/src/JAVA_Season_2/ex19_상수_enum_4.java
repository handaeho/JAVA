// 앞서 본 것 처럼, 'enum'은 사실 클래스이다.
// 그러므로 생성자를 가질수 있다.
enum Fruit_2 {
    // 생성자의 파라미터를 통해서 필드(APPLE, PEACH, BANANA)의 인스턴스 변수 값을 부여해 보자.
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    // ~> 'Fruit_2'의 상수를 선언하면서 동시에 생성자를 호출하고 있다.

    public String color;
    // 생성자의 파라미터로 전달된 값은 'this.color'를 통해서 인스턴스 변수의 값으로 할당된다.
    Fruit_2(String color) {
        System.out.println("Call Constructor " + this);
        this.color = color;
    }
}
enum Company_2 {
    GOOGLE, APPLE, ORACLE;
}

public class ex19_상수_enum_4 {
    public static void main(String[] args) {
        /*
        if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }
        */

        Fruit_2 type = Fruit_2.APPLE;
        switch (type) {
            case APPLE:
                System.out.println(57 + " kcal");
                System.out.println(57 + " kcal, " + Fruit_2.APPLE.color);
                // ~> 따라서 이렇게 호출하면 'APPLE'에 할당된 'Fruit_2' 인스턴스의 'color' 필드를 반환하게 된다.
                break;
            case PEACH:
                System.out.println(34 + " kcal");
                System.out.println(34 + " kcal, " + Fruit_2.PEACH.color);
                break;
            case BANANA:
                System.out.println(93 + "kcal");
                System.out.println(93 + "kcal, " + Fruit_2.BANANA.color);
                break;
        }
        // 결과는
        // Call Constructor APPLE
        // Call Constructor PEACH
        // Call Constructor BANANA
        // 57 kcal
        // ~> 'Call Constructor'가 출력된 것은 생성자 'Fruit_2()'가 호출되었음을 의미한다.
        // 이것이 3번 호출되었다는 것은 필드의 숫자만큼 호출되었다는 뜻이다.
        // 즉 'enum'은 생성자를 가질 수 있다.

        // 그러나 위의 'Fruit_2()'에 접근 제어자 'public'을 붙이게 되면 에러가 발생한다.
        // 왜? 'enum'의 생성자는 접근 제어자 'private'만을 허용한다.
        // 덕분에 'Fruit_2()'를 직접 생성할 수 없다.

        // 그렇다면 이 생성자의 파라미터를 통해서 필드(APPLE, PEACH, BANANA)의 인스턴스 변수 값을 부여 할 수 있다는 말일까?
        // 정답은 '그럴 수 있다'.

        // 생성자의 파라미터에 필드(APPLE, PEACH, BANANA)에 인스턴스 변수값을 부여한 결과는
        // Call Constructor APPLE
        // Call Constructor PEACH
        // Call Constructor BANANA
        // 57 kcal
        // 57 kcal, red
    }
}
