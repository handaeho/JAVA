// 자바에서 '상속'은 필수적인 개념.

// class O {} = class O extends Object {} ~> 이 코드는 서로 갖은 의미를 갖는다.
// 자바에서 모든 클래스는 사실 'object'를 암시적으로 상속받고 있는 것이다.
// 따라서 'Object'는 모든 클래스가 공통으로 가져야하는 기능을 제공하므로 모든 클래스의 조상이라고 할 수 있다.

// 1. toString = 객체를 문자로 표현하는 메소드
//  toString 메소드는 자바에서 특별히 취급하는 메소드다.
//  toString을 직접 호출하지 않아도 어떤 객체를 System.out.print로 호출하면
//  자동으로 toString이 호출되도록 약속되어 있다.
class Calculator_O{
    int left, right;

    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
    public String toString(){
        return "left : " + this.left + ", right : "+ this.right;
    }
    // 클래스 Calculator_O에 toString을 재정의(overiding)
    // 그리고 인스턴스를 System.out.println의 인자로 전달하니까 toString을 명시적으로 호출하지 않았음에도 동일한 효과
}

// 2. equals = 객체와 객체가 같은지 비교
class Student {
    String name;

    Student (String name) {
        this.name = name;
    }
    // 클래스 Object의 메소드 equals를 overiding
    public boolean equals (Object obj) {
        Student _obj = (Student) obj;
        // ~> (Student)obj 는 메소드 equals로 전달된 obj의 데이터 타입이 Object이기 때문에
        // 이를 Student 타입으로 타입 변환하는 코드
        return name == _obj.name;
    }
}
// 3. clone = 복제. 즉, 어떤 객체를 복제하여 똑같은 객체를 생성한다.
class Student_clone implements Cloneable {
    // 인터페이스 Cloneable의 코드의 실제 내용은 'public interface Cloneable {}'
    // ~> 비어있는 인터페이스.
    // 그럼에도 불구하고 이것을 사용한 이유는 클래스 Student가 복제 가능하다는 것을 표시하기 위한 것이다.
    // 만약 이 인터페이스를 구현하지 않고 있는 클래스에 대한 복제를 시도하면 오류가 발생할 것.
    String name;
    Student_clone (String name) {
        this.name = name;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ex18_object {
    public static void main(String[] args) {

        // 1. toString
        Calculator_O c1 = new Calculator_O();
        c1.setOprands(10, 20);
        System.out.println(c1);
        System.out.println(c1.toString());

        // 2. equals
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing");
        System.out.println(s1 == s2);
        // 이때 결과는 이름이 같지만 'false'
        // 왜? 서로 다른 객체니까(s1, s2)
        System.out.println(s1.equals(s2));
        // 이름이 같으니까 같다고 하고 싶기 때문에 클래스 Object의 메소드 equals를 overiding.

        /*
        <'equals()를 사용할때 중요 포인트>
            1. 객체 간에 동일성을 비교하고 싶을 때는 '=='를 사용하지 말고 'equals'를 이용하자.
            2. 'equals'를 직접 구현해야 한다면 'hashCode'도 함께 구현해야 함을 알고 이에 대한 분명한 학습을 한 후에 구현하자.
            3. 'equals'를 직접 구현해야 한다면 IDE는 'equals hashCode'를 자동으로 생성해주는 기능을 가지고 있다.
            4. 그 이유가 분명하지 않다면 비교 연산자 '==' 은 원시 데이터형을 비교할 때만 사용하자.
               ~> 원시 데이터 형(Primitive Data Type)
               = 자바에서 기본적으로 제공하는 데이터 타입으로 byte, short, int, long, float, double, boolean, char가 있다.
                 이러한 데이터 타입들은 new 연산자를 이용해서 생성하지 않아도 사용될 수 있다는 특징이 있다.
         */

        // 3. clone
        Student_clone s3 = new Student_clone("egoing");
        try {
            Student_clone s4 = (Student_clone) s3.clone();
            System.out.println(s3.name);
            System.out.println(s4.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
/*
<참고>
가비지 컬렉션(garbage collection)
= 인스턴스를 만드는 것은 내부적으로 메모리를 사용하는 것.
메모리를 최대한 효율적으로 사용하기 위해서 더 이상 사용하지 않는 데이터를 메모리에서 제거하는 방법.
자바에서는 이를 자동으로 제공하며 이를 '가비지 컬렉션(garbage collection)'이라고 한다.

이를테면 어떤 인스턴스를 만들었고, 그것을 변수에 담았다.
그런데 이 변수를 사용하는 곳이 없다면 더이상 이 변수와 변수에 담긴 인스턴스는 메모리에 있을 필요가 없다.
자바는 이를 감지하고 자동으로 이 데이터들을 메모리에서 삭제한다.

더 많은 정보는 'https://d2.naver.com/helloworld/1329'를 참고하자.
 */