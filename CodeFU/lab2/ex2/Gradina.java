package CodeFU.lab2.ex2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Gradina {
    public String check(String A, String B) {
        Map<Character, Integer> letterFrequency = new HashMap<>();
        int N = A.length();

        for (int i = 0; i < N; ++i) {
            letterFrequency.putIfAbsent(A.charAt(i), 0);
            letterFrequency.put(A.charAt(i), letterFrequency.get(A.charAt(i)) + 1);
        }

        for (int i = 0; i < N; ++i) {
            letterFrequency.putIfAbsent(B.charAt(i), 0);
            letterFrequency.put(B.charAt(i), letterFrequency.get(B.charAt(i)) + 1);
        }

        for (int letter : letterFrequency.values()) {
            if (letter > N)
                return "N";
        }

        return "Y";
    }

}
