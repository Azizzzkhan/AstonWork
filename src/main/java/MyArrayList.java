public class MyArrayList<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Сapacity is less than or equal to zero");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        if (list.length == size) {
            int newLength = (int) (size * 2);
            T[] listNew = (T[]) new Object[newLength];
            System.arraycopy(list, 0, listNew, 0, list.length);

            list = listNew;
        }
        list[size++] = item;
    }

    public void addToIndex(int index, T element) {

        for (int i = size; i > index; i++) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i--];
        }
    }

    public void deleteToIndex(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
    }

    public void display() {
        for (T element : list) {
            System.out.print(element + " ");
        }
    }
}

