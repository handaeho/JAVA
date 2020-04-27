// 상수: 변하지 않는 값
// int x = 1; ~~~> x: 변수 / 1: 상수

public class ex19_상수_enum {
    // 2)
    // 이때는 이름이 필요할 것.
    // 변수도 역시 상수가 될 수 있다.
    // 변수를 지정하고 'final'로 처리하면 한번 설정된 변수의 값은 바뀌지 않는다.
    // 또한 바뀌지 않는 값이라면 인스턴스 변수가 아닌 '클래스 변수(static)'로 지정하는것이 옳다.
    private final static int APPLE = 1;
    private final static int PEACH = 2;
    private final static int BANANA = 3;

    public static void main(String[] args) {
        // 1. 사과 2. 복숭아 3. 바나나

        // 1)
        // 이때, 숫자 1에 해당하는 과일은 언제나 사과.
        // 따라서 변하지 않는 '상수값'에는 그에 해당하는 과일의 의미를 고정.
        // 그런데 '1. 사과 2. 복숭아 3. 바나나'에 해당하는 주석이 없다면 숫자가 무엇을 의하는지 알기 힘들다.
        int type = 1;
        switch (type) {
            case 1:
                System.out.println(57);
                break;
            case 2:
                System.out.println(34);
                break;
            case 3:
                System.out.println(93);
                break;
        }

        // 2)
        int type2 = APPLE;
        switch(type2){
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

    }

}
