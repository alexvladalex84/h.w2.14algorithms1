package Service;

import org.example.Exeption.*;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private  Integer[] storage;
    private int size;

    public IntegerListImpl() {
        this.storage = new Integer[3];
    }

    public IntegerListImpl(int initSize) {
        this.storage = new Integer[initSize];
    }


    @Override
    public Integer add(Integer item) {
        validateItemNull(item);
        validateSize();
        storage[size++] = item;
//        if (!contains(item)) {
//            throw new ElementNotAddExaption("Не удалоссь добавить элмент");
//        }

        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateSize();
        validateItemNull(item);
        if (index == size) {
            storage[index] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        return null;
    }

    @Override
    public Integer remove(Integer item) {
        validateItemNull(item);
        int index = indexOf(item);               //indexOf метод в котором логика по поиску
        if (index == -1) {
            throw new ElementNotFoundException(); //если елемент не найден то ошибка
        }
        if (index == size) {
            storage[size--] = null;
            return item;
        }

        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index == size) {
            storage[size--] = null;
            return item;
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }


//    @Override
//    public boolean contains(Integer item) {
//        if (indexOf(item) == -1) {
//            return false;
//        }
//        return true;
//    }


    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;                      //вернуть -1 если элемент не найден(искать с последней  ячейки)}
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItemNull(Integer item) {
        if (item == null) {
            throw new NullItemException("Принимаемый объект равен null");
        }
    }


    private void validateSize() {
        if (size == storage.length) {
//            throw new StorageIsFullException("Нет места в массиве");
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            grow();
        }
    }

    private void sort(Integer[] array) {
        quickSort(array, 0, array.length - 1);

    }

    private void quickSort(Integer [] arr,int begin ,int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private  int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }



    private void swapElements(Integer[] arr,int i1 ,int i2) {
        int temp = arr[i1];
       arr [i1 ]= arr[i2];
       arr [i2] = temp;

    }
    public static void bobbleSort1(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i ; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                }
            }
        }
    }

    private boolean binarySearch(Integer[] array, Integer item) {    //бинарный поиск
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == array[mid]) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;

    }

    private void grow() {
        storage = Arrays.copyOf(storage,size + size / 2) ;
    }

}
