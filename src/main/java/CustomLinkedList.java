import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class CustomLinkedList<Element> implements Iterable<Element>, List<Element> {

    /* Все элементы внутри списка будут иметь тип Node
    Ссылка на первый и на последний элемент тоже типа Node
     */
    private Node<Element> first;
    private Node<Element> last;
    private int size;

    /*
      Метод добавления нового элемента
         */
    @Override
    public boolean add(Element element) {
        Node<Element> node;
        if (first == null) {
            node = new Node<>(element, null, null);
            first = node;
        } else {
            node = new Node<>(element, null, last);
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }

    /*
    Метод добавления элемента по индексу
     */
    @Override
    public boolean add(Element obj, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(obj);
        }
        Node<Element> nodeNext = getNode(index);
        Node<Element> nodePrevious = nodeNext.prev;
        Node<Element> nodeNew = new Node<>(obj, nodeNext, nodePrevious);
        nodeNext.prev = nodeNew;
        if (nodePrevious != null) {
            nodePrevious.next = nodeNew;
        } else {
            first = nodeNew;
        }
        size++;
        return true;
    }

    /*
    Метод сортировки списка
     */
    @Override
    public void sort(Comparator comparator) {
        Node node = first;
        Object[] data = new Object[size];
        int counter = 0;
        while (size != counter) {
            data[counter] = node.item;
            node = node.next;
            counter++;
        }
        Arrays.sort(data, 0, data.length, comparator);
        removeAll();
        for (int i = 0; i < data.length; i++) {
            add((Element) data[i]);

        }

    }

    /*
    Метод для выискивания по индексу внутри списка
     */
    public Node<Element> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<Element> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /*
    Метод чистки списка
     */
    public boolean removeAll() {
        first = null;
        last = null;
        size = 0;
        return true;
    }

    /*
    Вернуть элемент
     */
    public Element get(int index) {
        return getNode(index).item;

    }

    /*
    Метод возвращает длину списка
     */
    public int size() {
        return size;
    }


    /* Метод для удаления элемента по индексу
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            Node<Element> newHead = first.next;
            newHead.prev = null;
            first = newHead;
            size--;
            return true;
        }
        if (index == size - 1) {
            Node<Element> prevNew = last.prev;
            prevNew.next = null;
            last = prevNew;
            size--;
            return true;
        } else {
            Node<Element> currentNode = first;
            int counter = 0;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
            Node<Element> prevCurrentNode = currentNode.prev;
            Node<Element> nextCurrentNode = currentNode.next;
            prevCurrentNode.next = nextCurrentNode;
            nextCurrentNode.prev = prevCurrentNode;
            size--;

            return true;
        }
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

            return " " + item;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("CustomLinkedList = ");
        var cur = first;
        while (cur != null) {
            result
                    .append(cur)
                    .append(" ");
            cur = cur.next;
        }
        return result.toString();
    }
}
