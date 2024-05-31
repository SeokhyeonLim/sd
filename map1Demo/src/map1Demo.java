import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class map1Demo {
    public static <List> void main(String[] args) {
        List names = Arrays.asList("Alice", "Bob", "Charlie");

        // 스트림을 사용하여 문자열의 길이를 매핑하는 예제
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println(nameLengths);
    }
}
