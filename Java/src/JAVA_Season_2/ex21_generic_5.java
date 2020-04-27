// extends
// ~> 제네릭으로 올 수 있는 데이터 타입을 특정 클래스의 자식으로 제한할 수 있다.

// extends
abstract class Info {
    public abstract int getLevel();
}

class EmployeeInfo_4 extends Info {
    public int rank;
    EmployeeInfo_4 (int rank) {this.rank = rank;}
    public int getLevel() {
        return this.rank;
    }
}

class Person_4 <T extends Info> {
    public T info;
    Person_4 (T info) {this.info = info;}
}

// implements
interface Info_inter {
    int getLevel();
}

class EmployeeInfo_inter implements Info_inter {
    public int rank;
    EmployeeInfo_inter (int rank) {this.rank = rank;}
    public int getLevel() {
        return this.rank;
    }
}

class Person_inter <T extends Info_inter> {
    public T info;
    Person_inter (T info) {this.info = info;}
}

public class ex21_generic_5 {
    public static void main(String[] args) {
        Person_4 p1 = new Person_4(new EmployeeInfo_4(1));
        //Person_4<String> p2 = new Person_4<String>("부장");
        // ~> 에러
        // 'class Person_4 <T extends Info>'에 의해, 'Person'의 T는 Info 클래스나 그 자식 외에는 올 수 없다.

        // 또한 'extends'는 '상속(extends)'뿐 아니라 '구현(implements)'의 관계에서도 사용할 수 있다.
        Person_inter p2 = new Person_inter(new EmployeeInfo_inter(1));
        // Person_inter<String> p3 = new Person_inter<String>("부장");
        // ~> 위와 같은 이유로 에러
        // 'Person'의 T는 Info 클래스나 그 자식 외에는 올 수 없다.(String X)
    }
}
