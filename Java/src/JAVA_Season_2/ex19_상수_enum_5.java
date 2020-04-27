// 또한 'enum'은 사실상 클래스이므로 '메소드'를 가질수도 있다
enum Fruit_3 {
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    private String color;
    Fruit_3 (String color) {
        System.out.println("Call Constructor " + this);
        this.color = color;
    }
    String getColor() {
        return this.color;
    }
}

enum Company_3 {
    GOOGLE, APPLE, ORACLE;
}

public class ex19_상수_enum_5 {
    public static void main(String[] args) {
        Fruit_3 type = Fruit_3.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal, "+Fruit_3.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34+" kcal"+Fruit_3.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(93+" kcal"+Fruit_3.BANANA.getColor());
                break;
        }
        // 'enum'의 메소드를 호출한 결과는
        // Call Constructor APPLE
        // Call Constructor PEACH
        // Call Constructor BANANA
        // 57 kcal, red

        // 또한 'enum'은 멤버 전체를 열거할 수도 있다.
        for (Fruit_3 f : Fruit_3.values()) {
            System.out.println(f + " / " + f.getColor());
        }
        // 결과는
        // APPLE / red
        // PEACH / pink
        // BANANA / yellow
    }
    // 열거형 'enum'의 특성을 정리해보자면,
    // 1. 열거형 'enum'은 연관된 값들을 저장한다.
    // 2. 그 값이 변경되지 않도록 보장한다.
    // 3. 열거형 'enum' 자체가 클래스이기 때문에 'enum' 내부에 '생성자', '필드(변수)', '메소드'를 가질수 있다.
}
