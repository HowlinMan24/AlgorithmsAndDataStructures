package CodeFU.DNA;

public class TestClass {

    public static void main(String[] args) {

        int[] array = {-2, 12, -4, 10, -3, 5};
        int[] sumArray = new int[array.length];

        for (int i = 1; i < array.length; i++) {
            sumArray[i] = Math.max(sumArray[i - 1] + array[i], array[i]);
        }

        int max = 0;

        for (int i = 0; i < sumArray.length; i++)
            max = Math.max(sumArray[i], max);

        System.out.println(max);

    }

}
