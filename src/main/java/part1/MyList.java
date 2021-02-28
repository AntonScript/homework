package part1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class MyList<T> implements SimpleList<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size = 0;

    public MyList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T item) {
        if(size >= array.length)
            array = Arrays.copyOf(array,array.length * 2);
        array[size] = item;
        size++;

    }

    @Override
    public void insert(int index, T item) throws Exception {
        rangeCheck(index);
        array[index] = item;
    }

    @Override
    public void remove(int index) throws Exception {
        rangeCheck(index);
        for (int i = index; i < size-1; i++) {
            array[index] = array[index+1];
        }
        size--;
    }

    @Override
    public Optional<T> get(int index) {
        return Optional.of((T) array[index]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addAll(SimpleList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T myItem = (T) list.get(i).get();
            add(myItem);
        }
    }

    @Override
    public int first(T item) {
        for (int i = 0; i < size; i++) {
            T myItem = (T) array[i];
            if(myItem.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int last(T item) {
        for (int i = size - 1; i >= 0; i--) {
            T myItem = (T) array[i];
            if(myItem.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T item) {
        return first(item) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
    }


}
