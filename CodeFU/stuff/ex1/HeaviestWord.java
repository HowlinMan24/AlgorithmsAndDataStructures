package CodeFU.stuff.ex1;

import java.util.ArrayList;
import java.util.List;

public class HeaviestWord {
    public static void heaviest(String[] words) {
        List<String> listOfVowels = new ArrayList<>();
        listOfVowels.add("a");
        listOfVowels.add("e");
        listOfVowels.add("i");
        listOfVowels.add("o");
        listOfVowels.add("u");
        listOfVowels.add("y");

        int maxCounter = -1;
        String maxString = "";
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (listOfVowels.contains(String.valueOf(words[i].charAt(j)))) {
                    counter++;
                }
            }
            if (counter >= maxCounter) {
                if (counter == maxCounter && maxString.compareTo(words[i]) > -1) {
                    maxString = words[i];
                    maxCounter = counter;
                } else {
                    maxString = words[i];
                    maxCounter = counter;
                }
            }
        }
//        return maxString;
//        System.out.println(maxString);
    }

    public static void main(String[] args) {
        heaviest(new String[]{"akjqwhe", "asdasd", "qwe", "asde", "asdasd", "qweqwe", "qqqqqqq", "alksjd", "aeoi"});
    }

}
