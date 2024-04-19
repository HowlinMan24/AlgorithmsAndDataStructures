package CodeFU.lab2.ex1;

import java.util.*;

class Presentation {
    public int startTime;
    public int endTime;

    public Presentation(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Presentaion -> " + startTime + " -> " + endTime + "\n";
    }
}

public class Prezentacii {


    public static void maxPrezentacii(int N, int[] sf) {
//        Arrays.sort(sf);
//        System.out.println(Arrays.toString(sf));
        int counter = 0;
        List<Presentation> presentationList = new ArrayList<>();
        for (int i = 0; i < sf.length; i += 2)
            presentationList.add(new Presentation(sf[i], sf[i + 1]));
        presentationList.sort(Comparator.comparing(Presentation::getEndTime).thenComparing(Presentation::getStartTime));

//        presentationList.forEach(System.out::println);
        int currentEndTime = 0;
        for (Presentation presentation : presentationList)
            if (presentation.startTime >= currentEndTime) {
                currentEndTime = presentation.endTime;
                counter++;
            }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        maxPrezentacii(5, new int[]{1, 5, 3, 6, 7, 9, 8, 10, 11, 13});
        maxPrezentacii(11, new int[]{1, 4, 3, 5, 0, 6, 5, 7, 3, 8, 5, 9, 6, 10, 8, 11, 8, 12, 2, 13, 12, 14});
    }

}
