package JAVA_Season_1;

public class ex05_논리연산자 {
    public static void main(String[] args) {
        // 논리 연산자 '&&', '||'
        // '&&' = and ~> 좌항과 우항이 모두 True일 때만 True
        if (true && true) {
            System.out.println(1);
        }

        if (true && false) {
            System.out.println(2);
        }

        if (false && true) {
            System.out.println(3);
        }

        if (false && false) {
            System.out.println(4);
        }

        // '||' = or ~> 좌항 또는 우항이 하나라도 True면 True
        if (true || true) {
            System.out.println(1);
        }

        if (true || false) {
            System.out.println(2);
        }

        if (false || true) {
            System.out.println(3);
        }

        if (false || false) {
            System.out.println(4);
        }

        // '!' = not ~> Boolean 값을 반대로 바꿈
        if (!true) {
            System.out.println("Not true");
        }

        if (!false) {
            System.out.println("Not false");
        }
    }
}
