package JAVA_Season_2;

// Overlaoding 보충 예제

// 더 많은 값을 대상으로 연산하려면?

class Calculator_supplement {
    // int 리스트를 갖는 operands 변수
    int[] operands;

    public void setOperands(int[] operands) {
        this.operands = operands;
    }

    public void sum() {
        int total = 0;
        // operands 리스트의 값을 하나씩 value에 대응
        for (int value: this.operands) {
            // 리스트 원소의 총합 계산
            total += value;
        }
        System.out.println(total);
    }

    public void avg() {
        int total = 0;
        for (int value: this.operands) {
            total += value;
        }
        // 평균 = 리스트 원소의 총합 / 리스트 길이
        int mean = total / this.operands.length;
        System.out.println(mean);
    }
}
public class ex09_오버로딩_보충예제 {
    public static void main(String[] args) {
        // Calculator_supplement 클래스의 인스턴스 cs 생성
        Calculator_supplement cs = new Calculator_supplement();

        // [10, 20] 리스트를 cs 인스턴스의 setOperands 메소드 파라미터로 전달
        cs.setOperands(new int[] {10, 20});
        cs.sum();
        cs.avg();

        // [10, 20, 30] 리스트를 cs 인스턴스의 setOperands 메소드 파라미터로 전달
        cs.setOperands(new int[] {10, 20, 30});
        cs.sum();
        cs.avg();
    }
}
