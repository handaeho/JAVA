package JAVA_Season_1;

public class ex07_배열 {
    public static void main(String[] args) {
        // 배열(array) = 연관 정보를 그룹화
        // 변수가 하나의 데이터를 저장한다면 배열은 여러개의 데이터를 묶어서 저장하는 것
        String[] classname = {"Kim", "Lee", "Park", "Han"};
        // String[] ~> classname이라는 배열에는 string 타입이 담길 것이다.

        // 배열에서 데이터 꺼내기
        System.out.println(classname[0]);   // classname 배열의 0번지 Kim
        System.out.println(classname[1]);   // classname 배열의 1번지 Lee
        System.out.println(classname[2]);   // classname 배열의 2번지 Park
        System.out.println(classname[3]);   // classname 배열의 3번지 Han

        // 배열의 크기를 정의하고 그 배열에 데이터 저장하기
        String[] classname_2 = new String[4];   // classname_2 배열의 길이는 4
        classname_2[0] = "Han";     // classname_2 배열의 0번지에 "Han" 저장
        System.out.println(classname_2.length); // 4

        classname_2[1] = "Oh";     // classname_2 배열의 1번지에 "Oh" 저장
        System.out.println(classname_2.length); // 4

        classname_2[2] = "Choi";     // classname_2 배열의 2번지에 "Choi" 저장
        System.out.println(classname_2.length); // 4

        classname_2[3] = "Baek";     // classname_2 배열의 3번지에 "Baek" 저장
        System.out.println(classname_2.length); // 4

        // 예제
        // 반 학생들을 상담하고 상담이 끝난 학생의 이름을 출력
        for (int i=0; i < classname_2.length; i++) {
            String member = classname_2[i];
            System.out.println(member + " 상담 완료");
        }

        // for - each ~> 배열 탐색 시, 좀 더 간편하게
        String[] classmember = {"한대호", "대호", "한"};
        for (String e: classmember) {
            System.out.println(e + " 상담완료");
        }
        // for (String e: classmember)
        // ~> classmember 배열의 값을 변수 e에 담아 {} 안으로 전달.
        // for 반복을 위해 기준값을 설정하고 증가 또는 감소 시키는 부분을 감춘 것.
    }
}
