package CodeFU.stuff.testingShise;

public class AttackingQueens {


    public static int numberAttacks() {
        int counter = 0;
        for (int x1 = 0; x1 < 8; x1++) {
            for (int y1 = 0; y1 < 8; y1++) {
                for (int x2 = 0; x2 < 8; x2++) {
                    for (int y2 = 0; y2 < 8; y2++) {
                        if (x2 == x1 || y1 == y2 || (Math.abs(x1 - x2) == Math.abs(y1 - y2))) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(numberAttacks());
    }

}
