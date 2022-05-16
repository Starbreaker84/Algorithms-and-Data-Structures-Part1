import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        this.clazz = clz;
        this.count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (array != null) {
            this.array = Arrays.copyOf(array, new_capacity);
        }
        if (array == null) {
            this.array = (T[]) Array.newInstance(this.clazz, new_capacity);
        }
        this.capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm) {
        if (this.count == this.capacity) {
            makeArray(this.capacity * 2);
        }
        this.array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        if (this.count >= this.capacity) {
            makeArray(this.capacity * 2);
        }
        for (int i = count; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = itm;
        this.count++;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.count; i++) {
             this.array[i] = this.array[i + 1];
        }
        this.count--;
        int odd = this.capacity % 2;
        int limit = this.capacity / 2 - 1;
        if (odd != 0) limit = this.capacity / 2;
        if (this.count == limit && (int) (this.capacity / 1.5) <= 16){
            makeArray(16);
        }
        if (this.count == limit && (int) (this.capacity / 1.5) > 16){
            makeArray((int) (this.capacity / 1.5));
        }
    }
}
