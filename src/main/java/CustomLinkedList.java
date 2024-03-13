import java.util.Iterator;
public class CustomLinkedList<Element> implements Iterable<Element> {

    /* Все элементы внутри списка будут иметь тип Node
    Ссылка на первый и на последний элемент тоже типа Node
     */
    private Node<Element> first;
    private Node<Element> last;
    private int size;
    /*
      Метод добавления нового элемента в конец списка
         */
    public void add(Element element) {
        if (first == null) {
            Node<Element> node = new Node<>(element, null, null);
            first = node;
            last = node;
            size++;
        } else {
            Node<Element> node = new Node<>(element, null, last);
            last.next = node;
            last = node;
            size++;
        }

    }

    public Element get(int index) {
        return getNodeByIndex(index).item;
    }
    /*
    Метод возвращает длину списка
     */
    public int size() {
        return size;
    }

    /*
    Метод возвращает первый элемент
     */
    public Element first() {
        return first.item;
    }

    /*
    Метод возвращает последний элемент элемент
     */
    public Element last() {
        return first.item;
    }
    /* Метод добавление нового элемента в начало списка
     */
    public void addFirst(Element element) {
        Node<Element> newFirstElement = new Node<>(element, first, null);
        Node<Element> tmpFirst = first;
        tmpFirst.prev = newFirstElement;
        first = newFirstElement;
        size++;
    }
    /*
    Метод для удаления элемента по индексу
     */
    public void delete(int index) {
        Node<Element> deleteNode = getNodeByIndex(index);
        Node<Element> elementBefore = deleteNode.prev;
        Node<Element> elementAfter = deleteNode.next;
        elementBefore.next = elementAfter;
        elementAfter.prev = elementBefore;
        size--;

    }

    /*
    Метод для выискивания по индексу внутри списка
     */
    private Node<Element> getNodeByIndex(int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;

    }
    /*
    Для вывода через ForEach
     */
    @Override
    public Iterator<Element> iterator() {
        return new Iterator<Element>() {
            private Node<Element> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
                Node<Element> tmp = current;
                current = current.next;
                return tmp.item;
            }
        };
    }


    /*Мы объявляем поле Класса Node с дженерик типом само значение - item
    * Ссылка на следующий элемент
    * Ссылка на предыдущий элемент */
    public static class Node<Element> {
        public Element item;
        public Node<Element> next;
        public Node<Element> prev;

        public Node(Element item, Node<Element> next, Node<Element> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
        @Override
        public String toString() {
            return "" + item + next;
        }
            }


    @Override
    public String toString() {
        return "CustomLinkedList{" + first + " }";
    }
}
