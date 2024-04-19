package AIPS.Labs.lab1;

import java.util.Arrays;
import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    @Override
    public String toString() {
        return String.format("%d   ", calculateRevenues());
    }


    public int calculateRevenues() {
        int sum = 0;
        for (int i = 0; i < revenues.length; i++) {
            sum += revenues[i];
        }
        return sum;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public int sumSales(SalesPerson sp) {
        int sum = 0;
        for (int i = 0; i < quarters.length; i++) {
            sum += sp.quarters[i].calculateRevenues();
        }
        return sum;
    }

    public int sumSalesThis() {
        int sum = 0;
        for (int i = 0; i < quarters.length; i++) {
            sum += quarters[i].calculateRevenues();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append(name).append("   ");
        for (int i = 0; i < quarters.length; i++) {
            st.append(quarters[i]);
        }
        st.append(sumSalesThis());
        return st.toString();
    }


    public String getName() {
        return "\n" + name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }
}


public class Main {

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        int maxSum = arr[0].sumSalesThis();
        int maxI = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxSum < arr[i].sumSalesThis()) {
                maxSum = arr[i].sumSalesThis();
                maxI = i;
            }
        }
        return arr[maxI];
    }

    public static void table(SalesPerson[] arr) {
        System.out.println("SP   1   2   3   4   Total");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson[] arr = new SalesPerson[n];
        for (int i = 0; i < n; i++) {
            String name = input.next();
            QuarterlySales[] sales = new QuarterlySales[4];
            for (int x = 0; x < 4; x++) {
                int numrevenue = input.nextInt();
                int[] listRevenues = new int[numrevenue];
                for (int j = 0; j < numrevenue; j++) {
                    int revenue = input.nextInt();
                    listRevenues[j] = revenue;
                }
                sales[x] = new QuarterlySales(numrevenue, listRevenues, x);
            }
            arr[i] = new SalesPerson(name, sales);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
