package CodeFU.lab1.ex1;

public class IpAddresses {

    public static int countValidIPAddress(String S, int K) {
        return generateIPAddress(S, K, 0);
    }

    public static int generateIPAddress(String s, int k, int startIndex) {
        if (k == 0 && startIndex == s.length()) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 3 && startIndex + i <= s.length(); i++) {
            String part = s.substring(startIndex, startIndex + i);
            if (isValidPart(part)) {
                count += generateIPAddress(s, k - 1, startIndex + i);
            }
        }
        return count;
    }

    public static boolean isValidPart(String part) {
        if (part.length() > 1 && part.startsWith("0")) return false; // Leading zeros not allowed
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }

    public static int minTransformations(String S, int k) {

        /**
         * 1) S: "1234567", K: 3 -> 1 (valid IP addresses: "123.45.67")
         * 2) S: "100111", K: 3 -> 3 (valid IP addresses: "100.1.11", "100.11.1", "10.0.111")
         * 3) S: "345678", K: 2 -> 0 (it is not possible to form a valid IP Address with two numbers)
         */
        return countValidIPAddress(S, k);
    }

    public static void main(String[] args) {
        System.out.println(minTransformations("345678", 3));
    }
}
