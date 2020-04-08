package JAVA_Season_1;

public class ex08_메소드 {
    public static void numbering() {
        // 메소드 정의 = 메소드 만들기
        int i = 0;
        while (i <  10) {
            System.out.println(i);
            i++;
        }
    }
    public static void numbering_2(int limit) {
        int i = 0;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }
    public static void numbering_3(int init, int limit) {
        int i = init;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }
    public static String numbering_4(int init, int limit) {
        // String 타입으로 리턴할 것이므로 메소드 이름에 명시해야만 한다.
        int i = init;
        String output = ""; // 결과를 저장할 string 타입 변수
        while (i < limit) {
            output += i;
            i++;
        }
        return output;
    }
    public static void main(String[] args) {
        // 메소드 호출 = 메소드 실행하기
        numbering();

        // main 메소드는 규칙. 반드시 이 main 메소드가 이끄는 {} 안에 실행하고자 하는 로직을 위치시켜야 한다.
        // 즉, 우리는 main 메소드를 만들고, JAVA는 이 main 메소드를 실행하는 존재.

        // 1) 메소드는 '재활용성'이 높다. 만약 메소드를 만들기 않고 위의 while문을 5번 실행시키고자 한다면
        // main 메소드 안에 while을 5번 써야하지만 우리는 이미 'numbering'이라는 메소드를 만들었으므로
        // 이 메소드를 5번만 쓰면 된다.
        numbering();
        numbering();
        numbering();
        numbering();
        numbering();

        // 2) 메소드는 입력/출력에서도 강점이 있다.
        // 파라미터(매개변수) & 인자
        // numbering_2 메소드에 limit이라는 파라미터를 전달하여 거기까지만 반복문이 실행되게 할 수 있다.
        numbering_2(5);

        // 그리고 메소드는 다수의 파라미터를 가질 수도 있다.
        numbering_3(3, 10);

        // return ~> 메소드의 결과를 리턴한다. 그리고 동시에 메소드를 종료한다.
        // 중요한 점은 return될 데이터의 타입을 반드시 메소드의 이름 옆에 명시해야 한다.
        // 이는 매우 귀찮지만 메소드의 리턴값은 반드시 명시된 타입을 따르겠다는 장점이 있다.
        String result = numbering_4(5, 10);  // numbering_4의 리턴값을 저장할 string 타입 변수
        System.out.println(result);
    }
}
