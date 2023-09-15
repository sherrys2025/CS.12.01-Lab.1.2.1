public class DynamicArray<I extends Object> {

    I[] dynamicArray;
    int maximumCapacity;
    int size;
    public DynamicArray(Class<I> object) {
        maximumCapacity = 5;
        dynamicArray = (I[]) new Object[maximumCapacity];
        size = 0;
    }

    private void extend(){
        maximumCapacity *= 2;
        I[] temp = (I[]) new Object[maximumCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = dynamicArray[i];
        }
        dynamicArray = temp;
    }

    public int size() {
        return size;
    }

    public void add(I i) {
        size++;
        if (size >= maximumCapacity) {
            extend();
        }
        dynamicArray[size - 1] = i;
    }

    public void add(int i, I j) {
        if (i > size || i < 0) {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }
        size++;
        if (size >= maximumCapacity) {
            extend();
        }
        for (int index = size-1; index > i; index--) {
            dynamicArray[index] = dynamicArray[index-1];
        }
        dynamicArray[i] = j;
    }

    public I remove(int i) {
        if (i >= size || i < 0) {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }

        I toRemove = dynamicArray[i];
        for(int j = i; j < size ; j++) {
            dynamicArray[j] = dynamicArray[j+1];
        }
        size--;
        return toRemove;
    }

    public I remove(I i) {
        int index = -1;
        for (int j = 0; j < size; j++) {
            if(dynamicArray[j].equals(i)) {
                index = j;
                break;
            }
        }

        if (index == -1) {
            return i;
        }

        for(int j = index; j < size ; j++) {
            dynamicArray[j] = dynamicArray[j+1];
        }
        size--;
        return i;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public I get(int i) {
        if (i >= size || i < 0) {
            return null;
        }
        return dynamicArray[i];
    }

    public void set(int i, I j) {
        if (i >= size || i < 0) {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }
        dynamicArray[i] = j;
    }

    public I removeAll(I element) {
        for (int i = size-1; i >= 0; i--) {
            if (dynamicArray[i].equals(element)) {
                remove(i);
            }
        }
        return element;
    }
    
    public boolean contains(I element) {
        for (int i = 0; i < size; i++) {
            if (dynamicArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }


    public void clear() {
        size = 0;
    }
}


