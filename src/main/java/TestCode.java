public class TestCode {
    public static void main(String[] args) {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.sort(null);
        System.out.println(linkedList.size());
        System.out.println(linkedList);
    }
}
