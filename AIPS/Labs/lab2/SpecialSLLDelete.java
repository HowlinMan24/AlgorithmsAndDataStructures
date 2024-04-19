package AIPS.Labs.lab2;

import org.w3c.dom.Node;

import java.util.Scanner;

//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
//}
//
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int size() {
//        int listSize = 0;
//        SLLNode<E> tmp = first;
//        while (tmp != null) {
//            listSize++;
//            tmp = tmp.succ;
//        }
//        return listSize;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += " " + tmp;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, null);
//        ins.succ = first;
//        //SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                tmp.succ = new SLLNode<E>(o, before);
//                ;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = new SLLNode<E>(o, null);
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (!tmp.element.equals(o) && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element.equals(o)) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return null;
//    }
//
//    public void merge(SLL<E> in) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = in.getFirst();
//        } else {
//            first = in.getFirst();
//        }
//    }
//
//    public void mirror() {
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            SLLNode<E> tmp = first;
//            SLLNode<E> newsucc = null;
//            SLLNode<E> next;
//
//            while (tmp != null) {
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }
//    }
//}

public class SpecialSLLDelete<E> {

    //TODO: implement method
    public static void specialDelete(SLL<Integer> list, SLL<Integer> list2) {
//        int counter = m, deleted = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (counter == i) {
//                SLLNode<E> temp = list.getFirst();
//                int counter2 = 0;
//                while (temp != null && counter2 < i - 1) {
//                    temp = temp.succ;
//                    counter2++;
//                }
//                list.delete(temp);
//                deleted++;
//                counter += m - deleted;
//            }
//        }
//        if (list.size() == counter) {
//            SLLNode<E> temp = list.getFirst();
//            while (temp.succ != null) {
//                temp = temp.succ;
//            }
//            list.delete(temp);
//        }
//        while (temp1 != null) {
//            listAppended.insertLast(temp1.element);
//            temp1 = temp1.succ;
//        }
//        while (temp2 != null) {
//            listAppended.insertLast(temp2.element);
//            temp2 = temp2.succ;
//        }
//        boolean sorted = true;
//        while (sorted) {
//
//            sorted = false;
//            SLLNode<Integer> temp = listAppended.getFirst();
//
//            while (temp.succ != null) {
//                if (temp.element > temp.succ.element) {
//                    Integer swap = temp.element;
//                    temp.element = temp.succ.element;
//                    temp.succ.element = swap;
//                    sorted = true;
//                }
//                temp = temp.succ;
//            }
//        }
        SLL<Integer> listAppended = new SLL<>();
        SLLNode<Integer> temp1 = list.getFirst();
        SLLNode<Integer> temp2 = list2.getFirst();

        while (temp1 != null && temp2 != null) {
            if (temp1.element.compareTo(temp2.element) < 0) {
                listAppended.insertLast(temp1.element);
                temp1 = temp1.succ;
            } else {
                listAppended.insertLast(temp2.element);
                temp2 = temp2.succ;
            }
        }

        while(temp1 != null) {
            listAppended.insertLast(temp1.element);
            temp1 = temp1.succ;
        }

        while(temp2 != null) {
            listAppended.insertLast(temp2.element);
            temp2 = temp2.succ;
        }


        System.out.println(listAppended);

    }

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);

        int n = 5;

        SLL<Integer> list = new SLL<>();
        SLL<Integer> list2 = new SLL<>();

//        int[] array = {1212, 3, 21, 3, 123};
//        for (int i = 0; i < n; i++) {
//            list.insertLast(array[i]);
//        }
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(5);
        list2.insertLast(9);
        list2.insertLast(10);


        specialDelete(list, list2);

//        int m = input.nextInt();

//        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

//        tmp.specialDelete(list, m);

//        System.out.println();
    }

}
