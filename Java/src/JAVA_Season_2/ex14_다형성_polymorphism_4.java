// 이렇게 복잡하고 난해한 다형성을 조금 더 쉽게 이해하려면?
// 철수와 유리는 서로 부부이다.
// 철수는 집에서는 아빠이고, 직장에서는 개발자이다. 또한 종교단체를 나가서 주말에는 신도가 된다.
// 유리는 집에서는 엄마이고, 직장에서는 개발자이다. 종교단체는 나가지 않는다.
// 철수와 유리는 같은 회사를 다니기 때문에, 회사 입장에서는 둘 다 개발자라는 것이 중요할 뿐,
// 아빠인지, 엄마인지, 종교를 믿는지는 중요하지 않다.
// 따라서 회사는 그냥 철수와 유리에게 개발 업무만 맡기면 되고, 두 사람이 실력차가 있다면 결과는 다를 것이다.

interface father {}
interface mother {}
interface programmer {
    public void coding();
}
interface believer {}

class Cheolsu implements father, programmer, believer {
    // 철수는 아빠, 개발자, 신도
    public void coding() {
        System.out.println("High Level programmer");
    }
}

class Yuri implements mother, programmer {
    // 유리는 엄마, 개발자
    public void coding() {
        System.out.println("Mid Level programmer");
    }
}

public class ex14_다형성_polymorphism_4 {
    public static void main(String[] args) {
        // 회사 입장에서는 둘 다 개발자 직원일 뿐 다른 요소는 중요하지 않고
        programmer emp1 = new Cheolsu();
        programmer emp2 = new Yuri();

        // 코딩만 잘하면 된다.
        emp1.coding();
        emp2.coding();

        // 이렇게 그 객체(철수, 유리)가 어떤 성향(father, mother, programmer, believer)을 가지던 간에,
        // 사용자 입장(회사)에서는 자신이 원하는 인터페이스(programmer)를 가지고 있다면,
        // 필요한 기능(coding)을 반드시 가지고 있을 것이기 때문에 그 메소드만을 호출해서 사용하면 된다.
        // 이것이 다형성의 사용 예시이자 장점인 것이다.
    }
}
