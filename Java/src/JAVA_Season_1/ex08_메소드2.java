package JAVA_Season_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ex08_메소드2 {
    // 메소드의 리턴을 사용하는 이유는 비교하자면 메소드라는 부품의 가치를 높이는 것
    // 용도에 따른 메소드를 만들고 따로 분리해 사용함으로써 사용성을 높일 수 있다.
    public static String numbering(int init, int limit) {
        int i = init;
        String output = "";
        while (i < limit) {
            output += i;
            i++;
        }
        return output;
    }
    public static String num(int i) {
        // 또한 리턴은 메소드의 종료 역할을 하기도 한다.
        if (i == 0){
            return "zero";
        }else if (i == 1) {
            return "one";
        }else if (i == 2) {
            return "two";
        }else {
            return "None";
        }
    }
    public static String[] members() {
        // 메소드는 여러개의 파라미터를 입력 받을수 있는데, 여러개의 값을 출력하고 싶다면?
        // 리턴값을 저장할 변수에 여러개의 값을 담아 출력하면 된다.
        String[] member = {"한대호", "대호", "한"};   // 여러개의 값을 담고있는 배열
        return member;  // 그 배열을 리턴
    }
    public static void main(String[] args) {
        String result = numbering(3, 10);
        System.out.println(result);
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
            // out.txt라는 파일에 numbering 메소드의 리턴값을 저장한다.
            out.write(result);
            out.close();
        } catch (IOException e) {
        }

        String num_result = num(0);
        System.out.println(num_result);

        String[] mem = members();
    }
}
