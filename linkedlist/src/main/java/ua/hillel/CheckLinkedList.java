package ua.hillel;

public class CheckLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);

        System.out.println(linkedList.get(5));
        linkedList.set(5, 16);
        System.out.println(linkedList.get(5));
    }
}
