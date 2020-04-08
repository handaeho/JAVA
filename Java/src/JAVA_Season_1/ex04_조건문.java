package JAVA_Season_1;

public class ex04_조건문 {
    public static void main(String[] args) {
        // if(조건절) { 실행문장(then 절) }
        // else { if 조건이 아니라면 실행할 문장 }

        if(true){
            System.out.println("result = true");
        }

        int a = 1;
        if(a<3) {
            System.out.println("O");
        } else {
            System.out.println("X");
        }

        // else if(if 조건이 아닐때 넘어와 다시 조건 비교) { 실행문장 }
        if(false) {
            System.out.println(1);
        } else if (false) {
            System.out.println(2);
        } else if (true) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }

        String id = "daeho";
        if (id.equals("daeho")) {
            System.out.println("OK");
        } else if (id.equals("Han")) {
            System.out.println("OK Name?");
        } else {
            System.out.println("NO");
        }

        // switch ~ case
        // switch의 조건: byte, short, char, enum, Strin, Character, Byte, Short, integer
        System.out.println("switch 1");
        switch (1) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
        }
        System.out.println("switch 2");
        switch (2) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
        }
        System.out.println("switch 3");
        switch (3) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
        }
        // 즉, switch (1)이면 case 1에 해당하는 로직 이후의 모든 case가 실행된다.
        // break를 만나면 switch문이 즉시 종료된다.
        System.out.println("switch 1");
        switch (1) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }
        System.out.println("switch 2");
        switch (2) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }
        System.out.println("switch 3");
        switch (3) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }

        // switch에 주어진 케이스가 없을 경우 default문을 실행 시킬수도 있다
        System.out.println("switch 1");
        switch (1) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }
        System.out.println("switch 2");
        switch (2) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }
        System.out.println("switch 3");
        switch (3) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
        }
        System.out.println("switch 4");
        switch (4) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("Default");
        }
    }
}
