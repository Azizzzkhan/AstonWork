import java.util.Comparator;

public interface List<E> extends Iterable<E>  {
    boolean add(E obj);
    boolean add(E obj,int index);
    void sort(Comparator<E> comparator);
    boolean removeAll();

    E get(int index);
    int size();
    boolean remove(int index);
}
