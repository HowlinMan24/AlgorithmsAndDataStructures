//package AIPS.Labs.lab7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
////class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {
////
////    K key;
////    E value;
////
////    public MapEntry(K key, E val) {
////        this.key = key;
////        this.value = val;
////    }
////
////    public int compareTo(K that) {
////        @SuppressWarnings("unchecked")
////        MapEntry<K, E> other = (MapEntry<K, E>) that;
////        return this.key.compareTo(other.key);
////    }
////
////    public String toString() {
////        return "<" + key + "," + value + ">";
////    }
////}
////
////class SLLNode<E> {
////    protected E element;
////    protected SLLNode<E> succ;
////
////    public SLLNode(E elem, SLLNode<E> succ) {
////        this.element = elem;
////        this.succ = succ;
////    }
////
////
////    @Override
////    public String toString() {
////        return element.toString();
////    }
////}
////
////
////class CBHT<K extends Comparable<K>, E> {
////    private SLLNode<MapEntry<K, E>>[] buckets;
////
////    @SuppressWarnings("unchecked")
////    public CBHT(int m) {
////        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
////    }
////
////    private int hash(K key) {
////        return Math.abs(key.hashCode()) % buckets.length;
////    }
////
////    public SLLNode<MapEntry<K, E>> search(K targetKey) {
////        int b = hash(targetKey);
////        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
////            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
////                return curr;
////        }
////        return null;
////    }
////
////    public void insert(K key, E val) {
////        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
////        int b = hash(key);
////        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
////            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
////                curr.element = newEntry;
////                return;
////            }
////        }
////        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
////    }
////
////    public void delete(K key) {
////        int b = hash(key);
////        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
////            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
////                if (pred == null)
////                    buckets[b] = curr.succ;
////                else
////                    pred.succ = curr.succ;
////                return;
////            }
////        }
////    }
////
////    public boolean findElement(K key, E value) {
////        int b = hash(key);
////        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
////            if (value.equals(curr.element.key)) {
////                return true;
////            }
////        }
////        return false;
////    }
////
////    public String toString() {
////        String temp = "";
////        for (int i = 0; i < buckets.length; i++) {
////            temp += i + ":";
////            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
////                temp += curr.element.toString() + " ";
////            }
////            temp += "\n";
////        }
////        return temp;
////    }
////}
//
//public class Lozinki {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        CBHT<String, String> table = new CBHT<>(26);
//
//        for (int i = 1; i <= N; i++) {
//            String imelozinka = br.readLine();
//            String[] pom = imelozinka.split(" ");
//            table.insert(pom[0], pom[1]);
//        }
//
////        System.out.println(table);
//
//        while (true) {
//            String namePassword = br.readLine();
//            if (namePassword.equals("KRAJ"))
//                break;
//            String[] parts = namePassword.split("\\s+");
//            if (table.search(parts[0]) != null) {
//                if (table.search(parts[0]).element.value.equals(parts[1])) {
//                    table.insert(parts[0], parts[1]);
//                    System.out.println("Najaven");
//                } else
//                    System.out.println("Nenajaven");
//            } else {
//                System.out.println("Nenajaven");
//            }
//
//        }
//
////        System.out.println(table);
//
//
//    }
//}
//
