// 전자 시스템의 가장 중요한 특징은 '복제'
// 현실의 사물과는 다르게 전자 시스템의 데이터를 복제하는 것은 비용이 거의 들지 않기 때문
public class ex20_복제_참조 {
    public static void renValue() {
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue , " + a);
    }

    public static void main(String[] args) {
        renValue();
        // 결과는 'runValue , 1'
        // ~> 값을 변경한 것은 b이기 때문에 a에 담긴 값은 그대로이다.
        // 변수 b는 a의 값을 복제한 것.
    }
}
