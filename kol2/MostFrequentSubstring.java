package kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    private SLLNode<MapEntry<K, E>>[] buckets;

    public SLLNode<MapEntry<K, E>>[] getBuckets() {
        return buckets;
    }

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {        // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}

public class MostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> tabela = new CBHT<String, Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        /*
         *
         * Vashiot kod tuka....
         *
         */


        CBHT<String, Integer> mapWords = new CBHT<>(500);
        String maxString = "";
        int maxFrequency = 0;
        boolean flag = true;

        for (int i = 0; i < word.length(); i++) {
            StringBuilder st = new StringBuilder();
            for (int j = i; j < word.length(); j++) {
                st.append(word.charAt(j));
                if (flag) {
                    maxString = st.toString();
                    maxFrequency = 1;
                    flag = false;
                }

                if (mapWords.search(st.toString()) == null)
                    mapWords.insert(st.toString(), 1);
                else
                    mapWords.search(st.toString()).element.value++;

                String check = st.toString();

                int frequency = mapWords.search(check).element.value;
                if (frequency >= maxFrequency) {
                    if (frequency == maxFrequency) {
                        if ((check.length() > maxString.length())) {
                            maxString = st.toString();
                            maxFrequency = mapWords.search(st.toString()).element.value;
                        } else if (st.toString().compareTo(maxString) < 0 && (check.length() == maxString.length())) {
                            maxString = st.toString();
                            maxFrequency = mapWords.search(st.toString()).element.value;
                        }
                    } else {
                        maxString = st.toString();
                        maxFrequency = mapWords.search(st.toString()).element.value;
                    }
                }
            }
        }
        System.out.println(maxString);
    }
}

