// 전자 시스템에서 가장 중요한 특징은 '복제'
// 그러나 '복제'만으로 모든 것을 설명할 수 는 없다.]

// 복제 VS 참조
// 복제 ~> 그대로 파일을 복사 / 참조 ~> 심볼릭 링크, 바로가기를 만드는 것
// 원본 파일에 대해 심볼릭 링크를 만들면, 원본 수정시 심볼릭 링크에도 그 사항이 반영되는 것과 같다.

// 심볼릭 링크를 톤해 만든 파일은 원본 파일에 대한 '주소값'이 담겨 있다.
// 누군가 심볼릭 링크를 통해 파일에 접근하면 원본 파일의 주소를 '참조'해서 원본의 위치를 알아내고 그에 대해 작업을 한다.
// 다시 말해, 원본을 '복제'한 것이 아니라,  원본을 '참조'하고 있는 것이다.
// 덕분에 저장 장치의 용량을 절약할 수 있고,
// 원본 파일을 사용하고 있는 모든 복제본이 동일한 내용을 유지할 수 있게 된다.
// '참조'는 전자화된 세계의 극치라고 할 수 있다.

// '라이브러리'라는 개념도 일종의 '참조'라고 할 수 있다.
// 공용 라이브러리를 사용하게 되면 하나의 라이브러리를 여러 애플리케이션에서 공유해서 사용하게 된다.
// 라이브러리의 내용이 변경되면 이를 참조하고 있는 애플리케이션에도 내용이 반영되게 된다.
// 또 우리가 변수를 사용하는 이유도 말하자면 참조를 위해서라고 할 수 있을 것이다.

// 아래 코드의 차이점을 보자.
/*
int a = 1;

A a = new A(1);
 */
// ~> 전자는 데이터 타입이 'int'이고, 후자는 'A'이다.
// 'int'는 기본 데이터 타입(원시 데이터 타입, Primitive Data Types)이다.
// 자바에서는 기본 데이터 타입을 제외한 모든 데이터 타입은 참조 데이터 타입(참조 자료 타입)이라고 부른다.
// 즉, "기본 데이터 타입은 위와 같이 복제 되지만 참조 데이터 타입은 참조된다".
// 'new'를 사용해서 객체를 만드는 모든 데이터 타입이 참조 데이터 타입입이고 생각해도 된다. (단 'String'은 제외)

// 정리하면 변수에 담겨있는 데이터가 기본 타입이면 그 안에는 실제 데이터가 들어있고,
// 기본 타입이 아니면 변수 안에는 데이터에 대한 참조 방법이 들어있다고 할 수 있다.

// 그럼 일종의 변수할당이라고 할 수 있는 메소드의 매개변수는 어떻게 동작하는가?
public class ex20_복제_참조_3 {
    static void _value (int b) {
        b = 2;
        // '_value'의 파라미터로 기본 데이터 타입 'int'를 전달했다.
    }

    public static void runValue() {
        int a = 1;
        _value(a);
        System.out.println("runValue, " + a);
        // 메소드 '_value'의 인자로 a를 전달했다.
        // a는 파라미터 b가 되어서 '_value' 안으로 전달되고 있다.
        // '_value' 안에서 b의 값을 변경했다. '_value'가 실행된 후에 'runValue'에서 a값을 출력해본 결과 값이 변경되지 않았다.
        // 즉, 호출된 메소드의 작업이 호출한 메소드에 영향을 미치지 않고 있다.
        // ---> runValue, 1
    }

    static void _reference1(A_ref b) {
        b = new A_ref(2);
        // '_reference1'의 파라미터로 참조 데이터 타입 'A_ref'를 전달했다.
        // 그리고 메소드 '_reference1' 안에서 b의 값을 다른 객체 'new A_ref(2)'로 변경하고 있다.
    }

    public static void runReference1(){
        A_ref a = new A_ref(1);
        _reference1(a);
        System.out.println("runReference1, "+a.id);
        // 이것은 지역변수인 b의 데이터를 교체한 것일 뿐이기 때문에 'runReference1'의 결과에는 영향을 미치지 않는다.
        // ---> runReference1, 1
    }

    static void _reference2(A_ref b){
        b.id = 2;
        // b의 값을 다른 객체로 교체한 것이 아니라 파라미터 b의 인스턴스 변수 id 값을 2로 변경하고 있다.
    }

    public static void runReference2(){
        A_ref a = new A_ref(1);
        _reference2(a);
        System.out.println("runReference2, "+a.id);
        // 그런데 여기서는 호출된 메소드의 작업이 호출한 메소드의 변수에 영향을 미친다.
        // ---> runReference2, 2
        // '_reference2'의 변수 b는 'runReference2'의 변수 a와 참조 관계로 연결되어 있는 것이기 때문에
        // a와 b는 모두 같은 객체를 참조하고 있는 변수다.
    }

    public static void main(String[] args) {
        runValue(); // runValue, 1
        runReference1(); // runReference1, 1
        runReference2(); // runReference2, 2
    }
}
