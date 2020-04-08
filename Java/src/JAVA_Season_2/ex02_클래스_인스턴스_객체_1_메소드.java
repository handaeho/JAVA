package JAVA_Season_2;

public class ex02_클래스_인스턴스_객체_1_메소드 {
    public static void sum (int a, int b) {
        System.out.println(a + b);
    }
    public static void main(String[] args) {
        // 메소드
        // 만약 메소드화를 하지 않았다면
        System.out.println(10 + 20);
        System.out.println(30 + 40);
        // ~> 몇만줄의 복잡한 코드라고 가정한다면 이 몇만줄의 코드는 단순히 덧셈을 위해 존재하는 것. => 비효율적

        // 이 동작을 'sum()'이라는 메소드로 구현하면
        sum(10, 20);
        sum(30, 40);
        // ~> 단순하게 덧셈을 하는 메소드를 호출하고 원하는 값을 파라미터로 전달만 하면 된다. => 매우 효율적
    }
}
