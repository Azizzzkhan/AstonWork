import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class CustomArrayList<T> implements List<T> {

    private Object[] arrays;
    private static final int CAPACITY = 10;
    private int size = 0;

    public CustomArrayList() {
        this.arrays = new Object[CAPACITY];
    }

    public CustomArrayList(int size) {
        this.arrays = new Object[size];
    }

    /*
    Метод добавления элемента
     */
    @Override
    public boolean add(T obj) {
        if (size == arrays.length) {
            arrays = Arrays.copyOf(arrays, arrays.length * 2);
        }
        arrays[size] = obj;
        size++;
        return true;
    }

    /*
    Метод добавление элемента по индексу
     */
    @Override
    public boolean add(T obj, int index) {
        if (size == arrays.length - 1) {
            arrays = Arrays.copyOf(arrays, arrays.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arrays, index, arrays, index + 1, size - index);
        arrays[index] = obj;
        size++;
        return true;
    }

    /*
    Метод удаления всех элементов из спика
     */
    @Override
    public boolean removeAll() {
        Arrays.fill(arrays, null);
        size = 0;
        return true;
    }

    /*
    Метод сортировки списка
     */
    @Override
    public void sort(Comparator comparator) {
        Arrays.sort(arrays, 0, size);

    }

    /*
    Возвращает элемент
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arrays[index];
    }

    @Override
    public int size() {
        return size;
    }

    /*
    Метод удаления элемента по индексу
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= arrays.length) {
            return false;
        } else {
            size--;
            for (int i = index; i < arrays.length - 1; i++) {
                arrays[i] = arrays[i + 1];
            }
            return true;
        }


    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return "MyArrayList" + Arrays.toString(arrays);
    }
}
