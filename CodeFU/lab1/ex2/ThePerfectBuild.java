package CodeFU.lab1.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Item {
    int price;
    int strength;
    int agility;
    int inteligence;

    public Item(int price, int strength, int agility, int inteligence) {
        this.price = price;
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    public int getPrice() {
        return price;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getInteligence() {
        return inteligence;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Price -> ").append(price).append("\n");
        st.append("Strength -> ").append(strength).append("\n");
        st.append("Agility -> ").append(agility).append("\n");
        st.append("Intelligence -> ").append(inteligence).append("\n");
        return st.toString();
    }
}

public class ThePerfectBuild {
    public static int getStrongness(String heroType, int gold, int n, String items) {
        String[] parts = items.split(",");
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            String[] itemStuff = parts[i].split(";");
            itemList.add(new Item(Integer.parseInt(itemStuff[0]), Integer.parseInt(itemStuff[1]), Integer.parseInt(itemStuff[2]), Integer.parseInt(itemStuff[3])));
        }
        itemList.sort(Comparator.comparing(Item::getPrice).reversed());
        System.out.println(itemList);
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Arrays.stream(line).forEach(String::trim);
        String line = br.readLine();
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                counter++;
            }
            if (counter == 3) {
                String part = line.substring(i+1);
                String[] parts = line.split(",");
                System.out.println(getStrongness(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), part.replace("\"","")));
                break;
            }
        }

    }

}

