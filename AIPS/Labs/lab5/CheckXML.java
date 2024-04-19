package AIPS.Labs.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;


public class CheckXML {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        // TODO sete it to be valid i.e 1
        int valid = 1;

        // Vasiot kod tuka

        Stack<String> stackXML = new Stack<>();

        for (int i = 0; i < redovi.length; i++) {
            if (redovi[i].charAt(0) == '[' && redovi[i].charAt(1) != '/') {
                stackXML.push(redovi[i]);
            } else {
                if (redovi[i].charAt(0) != '[')
                    continue;
                if (!stackXML.isEmpty()) {
                    // TODO skip the '/' just to compare the names with substring
                    String tagStack = stackXML.pop().substring(1);
                    // TODO skip the '/' just to compare the names with substring
                    // TODO and check if the tags are the same i.e if they are not the length will be different so it will give value 0
                    String tagCurrent = redovi[i].substring(2);
                    // TODO if they are not the same break the cycle
                    if (!tagStack.equals(tagCurrent)) {
                        valid = 0;
                        break;
                    }
                }
            }
        }

        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        System.out.println(valid);

        br.close();
    }
}