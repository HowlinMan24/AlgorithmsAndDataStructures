package CodeFU.lab2.ex3;

public class Opseg {
    public static void min(int[] arr) {
        int counter = 0;
        int current = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (current + 1 != arr[i + 1]) {
                counter++;
                current = arr[i + 1];
            } else {
                current++;
            }
        }
        System.out.println(counter+1);
    }


    public static void main(String[] args) {
        min(new int[]{1, 6, 10, 20, 32, 49});
        // 6
        min(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47});
        //14
        min(new int[]{10, 11, 12, 13, 14, 15, 20, 21, 22, 23, 25, 27, 28, 29, 30, 31, 32, 33});
        //4
    }

}

