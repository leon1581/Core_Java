package inheritance.reflection.objectAnalyzer;

import java.util.*;

public class ObjectAnalyzerTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
            System.out.println(new ObjectAnalyzer().toString(squares));
        }
    }
}
