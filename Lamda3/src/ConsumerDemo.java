import java.util.function.*;

public class ConsumerDemo {
    public static void main(String[] args) {
        // Consumer 인터페이스를 사용하여 문자열을 소문자로 변환하여 출력하는 c1 객체 생성
        Consumer<String> c1 = x -> System.out.println(x.toLowerCase());
        // c1 객체에 "Java Functional Interface"를 전달하여  accept 메서드 호출
        c1.accept("Java Functional Interface");

        // BiConsumer 인터페이스를 사용하여 두 문자열을 연결하여 출력하는 c2 객체 생성
        BiConsumer<String, String> c2 = (x, y) -> System.out.println(x + " : " + y);
        // c2 객체에 "Java"와 "Lambda"를 전달하여 accept 메서드 호출
        c2.accept("Java", "Lambda");

        // ObjIntConsumer 인터페이스를 사용하여 문자열과 정수를 받아서 처리하는 c3 객체 생성
        ObjIntConsumer<String> c3 = (s, x) -> {
            int a = Integer.parseInt(s) + x; // 문자열을 정수로 변환하여 정수와 더함
            System.out.println(a);
        };
        // c3 객체에 "100"과 50을 전달하여 accept 메서드 호출
        c3.accept("100", 50);

        // IntConsumer 인터페이스를 사용하여 정수를 받아서 출력하는 c4 객체 생성
        IntConsumer c4 = x -> System.out.printf("%d * %d = %d\n", x, x, x * x);
        // c4 객체를 사용하여 정수를 출력한 후, 그 정수에 10을 더한 결과를 출력하는 c5 객체 생성
        IntConsumer c5 = c4.andThen(x -> System.out.printf("%d + 10 = %d", x, x + 10));
        // c5 객체에 10을 전달하여 accept 메서드 호출
        c5.accept(10);
    }
}
