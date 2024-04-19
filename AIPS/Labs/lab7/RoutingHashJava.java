//package AIPS.Labs.lab7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
////
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
//
//public class RoutingHashJava {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        CBHT<String, String> table = new CBHT<>(50);
//
//        for (int i = 0; i < n; i++) {
//            String starterIP = br.readLine();
//            String endIp = br.readLine();
////            String[] partsEnd = endIp.split(",");
////            for (int j = 0; j < partsEnd.length; j++) {
////                table.insert(starterIP, endIp);
////            }
//            table.insert(starterIP, endIp);
//        }
//
//        System.out.println(table);
//
//        int m = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < m; i++) {
//            String starterIP = br.readLine();
//            String endIp = br.readLine();
//            if (table.search(starterIP) != null) {
//                boolean flag = true;
//                String[] partsEnd = table.search(starterIP).element.value.split(",");
//                for (int j = 0; j < partsEnd.length; j++) {
//                    if (partsEnd[j].substring(0, 6).equals(endIp.substring(0, 6))) {
//                        flag = false;
//                        System.out.println("postoi");
//                    }
//                }
//                if (flag) {
//                    System.out.println("ne postoi");
//                }
//            } else {
//                System.out.println("ne postoi");
//            }
//        }
//
//    }
//}