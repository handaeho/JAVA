package JAVA_Season_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex09_입력_출력 {
    // 다양한 입력을 받아 동작하는 메소드를 생성해보자.
    public static void main(String[] args) {
        // main 메소드의 'String[] arg'는 '입력 값의 파라미터'이다.
        // 파라미터 명은 'arg', 타입은 문자열을 담고있는 배열

        for(String e: args){
            System.out.println(e);
        }
        // for - each 구문으로 args가 전달받은 문자열 배열을 하나씩 꺼내 e에 전달

        // Scanner() ~> 콘솔창에서 입력받기
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();   // 여기가 실행되면 콘솔창에 입력이 있을때까지 대기
        System.out.println(i + 100);
        sc.close(); // close() 필요

        // 이번에는 콘솔창에서 연속적으로 값 입력 받기
        Scanner sc_2 = new Scanner(System.in);
        while (sc_2.hasNextInt()) {
            System.out.println(sc_2.nextInt() * 100);
        }
        // .hasNextInt() ~> 입력값이 생기기 전까지 실행을 대기함.
        // 입력받은 값이 int형이 아닐 경우, false를 리턴하고 int형이라면 true를 리턴한다.
        // 따라서 입력값을 계속 넣는다면 while문이 반복 실행되므로 여러번 입력할 수 있다.
        sc_2.close();

        // 이번에는 ex08_메소드2에서 만든 'out.txt' 파일을 입력으로 받아 화면에 출력해보자
        try {
            File file = new File("out.txt");
            Scanner sc_out = new Scanner(file);
            while (sc_out.hasNextInt()) {
                System.out.println(sc_out.nextInt() * 100);
            }
            sc_out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
