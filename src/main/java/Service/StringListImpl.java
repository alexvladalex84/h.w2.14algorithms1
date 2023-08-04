package Service;

import org.example.Exeption.*;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] storage;
    private int size;

    public StringListImpl() {
        this.storage = new String[2];
    }

    public StringListImpl(int initSize) {
        this.storage = new String[initSize];
    }

    @Override

    public String add(String item) {
        validateItemNull(item);
        validateSize();
        storage[size++] = item;
        if (!contains(item)) {
            throw new ElementNotAddExaption("Не удалоссь добавить элмент");
        }
        return item;
    }


    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItemNull(item);
        validateSize();
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
    public String remove(String item) {
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
    public String remove(int index) {
        validateIndex(index);
        String item = storage[index];
        if (index == size) {
            storage[size--] = null;
            return item;
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItemNull(item);
        validateSize();
        storage[index] = item;
        return item;
    }

    @Override
    public boolean contains(String item) {   //логика в indexOf
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;//вернуть -1 если элемент не найден(искать с нулевой ячейки)}
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return 1;                      //вернуть -1 если элемент не найден(искать с последней  ячейки)}
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {

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
        size = 0;                                  //обнулить размер
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);    //копия массива по размеру size без пустых ячеяк
    }

    private void validateItemNull(String item) {
        if (item == null) {
            throw new NullItemException("Принимаемый объект равен null");
        }
    }


    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException("Нет места в массиве");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Номер индекса меньше 0 или больше размера массива");
        }
    }
}



/*Напишите реализацию этого интерфейса, выполнив все его методы. В качестве хранилища используйте массив.
В конструкторе должен задаваться размер массива внутри.
Список не должен добавлять или хранить в себе null. Т. е. в случае удаления элемента нужно смещать все элементы
на ячейку влево, а при добавлении в середину или начало — на ячейку вправо.
По желанию можно реализовать расширение массива.
Рекомендуется написать свои исключения и выбрасывать их в тех ситуациях, которые описаны в интерфейсе.
 Если в какой-то из методов в качестве параметра приходит null, выбросить исключение.*/




