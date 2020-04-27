// 배열(array) = 연관된 데이터를 관리하기 위한 수단
// 그러나, 배열은 '한번 정해진 배열의 크기를 변경할 수 없다'는 단점이 있다.
// 그래서 'Collections Framework'를 사용한다.
import java.util.ArrayList;

public class ex22_collections_framework {
    public static void main(String[] args) {
        String[] arrayObj = new String[2];  // 크기가 2인 배열 생성
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        //arrayObj[2] = "three"; ~> 크기를 넘었기 때문에 에러

        for (int i=0; i<arrayObj.length; i++) {
            System.out.println(arrayObj[i]);
        }

        ArrayList al = new ArrayList(); // 크기를 미리 정하지 않는 ArrayList 생성
        al.add("one");
        al.add("two");
        al.add("three");

        for (int i=0; i<al.size(); i++) {
            System.out.println(al.get(i));
        }
        // 배열과 ArrayList의 차이점
        // 1. 배열의 경우 값의 개수를 구할 때 '.length'를 사용했지만 ArrayList는 메소드 'size'를 사용한다.
        // 2. 특정한 값을 가져올 때 배열은 '[인덱스 번호]'를 사용했지만 컬렉션은 '.get(인덱스 번호)'를 사용한다.

        // 그러나 위의 for 반복문을 아래와 같이 바꾸면 컴파일 에러가 발생한다.
        /*
        for(int i=0; i<al.size(); i++){
            String val = al.get(i);
            System.out.println(val);
        }
         */
        // ~> ArrayList의 메소드 add의 입장에서는 인자로 어떤 형태의 값이 올지 알 수 없다.
        // 그렇기 때문에 모든 데이터 타입의 조상인 Object 형식으로 데이터를 받고 있다.
        // 따라서 ArrayList 내에서 add를 통해서 입력된 값은 Object의 데이터 타입을 가지고 있고,
        // get을 이용해서 이를 꺼내도 Object의 데이터 타입을 가지고 있게 된다.
        // 그래서 위의 코드는 아래와 같이 바꿔야 한다.
        for(int i=0; i<al.size(); i++){
            String val = (String)al.get(i);
            System.out.println(val);
        }
        // ~> get의 리턴값을 문자열로 타입 변환하고 있다. 원래의 데이터 타입이 된 것이다.

        // 그리고 이때 제네릭을 사용해야 더 좋다.
        ArrayList<String> al2 = new ArrayList<String>();
        // ~> ArrayList에 들어오는 데이터는 String 타입으로 받겠다는 뜻
        al2.add("one");
        al2.add("two");
        al2.add("three");

        for(int i=0; i<al.size(); i++){
            String val2 = al2.get(i);
            System.out.println(val2);
        }
        // 제네릭을 사용하면 ArrayList 내에서 사용할 데이터 타입을 인스턴스를 생성할 때 지정할 수 있기 때문에,
        // 데이터를 꺼낼 때(String val = al.get(i);) 타입 변환을 하지 않아도 된다.
    }
}
