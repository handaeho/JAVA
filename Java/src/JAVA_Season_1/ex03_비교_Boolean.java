package JAVA_Season_1;

public class ex03_비교_Boolean {
    public static void main(String[] args) {
        // 비교 연산자 '==' ~> 결과는 True or False
        System.out.println(1==2);   // False
        System.out.println(1==1);   // True

        // 또한 문자열 비교도 가능하다.
        System.out.println("one" == "two");     // False
        System.out.println("three" == "three"); // True

        // 부정 비교 연산자 '!='
        System.out.println(1 != 2); // True
        System.out.println(1 != 1); // False
        System.out.println("one" != "two"); // True
        System.out.println("three" != "three"); // False

        // 크기 비교 연산자 '>', '<', '>=', '<='
        System.out.println(1 > 2);  // False
        System.out.println(1 < 2);  // True
        System.out.println(3 >= 2); // True
        System.out.println(3 <= 4); // True

        // 문자열 비교 메소드 '.equals'
        String a = "Hello World";
        String b = new String(a);
        System.out.println(a == b); // False ~> '=='은 두 변수의 데이터 타입이 동일한지 알아내는 것이기 때문
        System.out.println(a.equals(b)); // True ~> 따라서 '.equals'를 사용하면 데이터 타입이 달라도 값은 같은지 비교 가능
        // 따라서 문자열을 비교할 때는 '.equals'를 사용하도록 하자
    }
}
