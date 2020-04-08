package JAVA_Season_1;

public class ex02_형변환_연산자 {
    public static void main(String[] args) {
        // 형 변환

        double a = 3.0;
        // float b = 3.0; ~> 에러.
        // 표현범위: byte -> short, char -> int -> long -> float -> double
        System.out.println(a);

        int x = 1;
        float y = 3.0F;
        double z = 5.0;

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        int q = 3;
        float w = 1.0F;
        double e = q + w;
        // 두 번의 형 변환 발생. q와 w를 더하기 위해 둘 중 하나가 형 변환을 한다.
        // int와 float가 붙으면 int가 float형으로 변환됨. 따라서 q에 있는 3은 float 타입이 된다.
        // 그리고 q + w가 담길 e는 double 타입. 따라서 float 타입은 다시 double 타입으로 형 변환.

        System.out.println(e);

        // 명시적 형 변환: 자동으로 형 변환이 되지 않는 경우에는 명시적으로(수동으로) 형 변환이 필요하다.
        // float a = 100.0;
        // int b = 100.0F; ~> 오류. 자동으로 형 변환이 되지 않음.
        float i = (float)100.0;
        int j = (int)100.0F;

        System.out.println(i);

        // 연산자

        int result = 1 + 2;
        System.out.println("result = " + result);

        result -= 1;
        System.out.println(result);

        result *= 4;
        System.out.println(result);

        result /= 2;
        System.out.println(result);

        result += 7;
        System.out.println(result);

        result %= 7;
        System.out.println(result);

        // 또한 + 연산자는 '문자열을 붙일 때'도 사용할 수 있다.
        String str_1 = "This is";
        String str_2 = " JAVA";
        String result_str = str_1 + str_2;
        System.out.println(result_str);

        // 단항 연산자(++, --)
        int p = 3;
        p++;
        System.out.println(p);

        ++p; // 선 증가
        System.out.println(p);

        System.out.println(p);
        System.out.println(p++);  // 후 증가 ~> print 먼저 하고 p + 1
        System.out.println(++p);  // 선 증가 ~> p + 1 먼저 하고 print
        System.out.println(p);
    }
}
