package JAVA_Season_1;

public class ex06_반복문 {
    public static void main(String[] args) {
        // while(조건) { 실행문장 }
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // for(초기화; 종료조건; 반복실행할 식) { 실행문장 }
        for(int a = 0; a < 10; a++) {
            System.out.println("a = "+ a);
        }

        // break ~> 반복문을 중단하기
        for(int x = 0; x < 10; x++) {
            if (x == 5) {
                break;
            }
            System.out.println("x = " + x);
        }
        // 이러면 x = 0, 1, 2, 3, 4까지만 실행

        // continue ~> 실행은 중단하지만 반복은 지속하게 하기
        for(int y = 0; y < 10; y++) {
            if (y == 5) {
                continue;
            }
            System.out.println("y = " + y);
        }
        // 이러면 y = 5만 제외되고 y = 0, 1, 2, 3, 4, 6, 7, 8, 9 실행

        // 반복문 중첩
        for(int q = 0; q < 10; q++) {
            for(int w = 0; w < 10 ; w++) {
                System.out.println(q + " " + w);
            }
        }
    }
}
