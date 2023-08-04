package Service;

import org.example.Exeption.InvalidIndexException;
import org.example.Exeption.NullItemException;
import org.example.Exeption.StorageIsFullException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    StringListImpl stringList = new StringListImpl();

    @org.junit.jupiter.api.Test
    void add_ItemNullItemAdd() {
        //        входящие данные
        String string = null;

//        ожидаемый результат
        String expectedMassage = "Принимаемый объект равен null";
//        начало теста
        Exception exception = Assertions.assertThrows(NullItemException.class, () ->stringList .add(string));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

    } @org.junit.jupiter.api.Test
    void add_ItemNoPlaceInArray() {
        //        входящие данные

        addInArray();
        String string = "Hello";
//        ожидаемый результат

        String expectedMassage = "Нет места в массиве";
//        начало теста
        Exception exception = Assertions.assertThrows(StorageIsFullException.class, () ->stringList.add(string));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
        clearInArray();
    }
    @org.junit.jupiter.api.Test
    void add_ItemSuccess() {

        //      входящие данные
        String string = "hello";
//        ожидаемый результат
        String expected = string;
//        начало теста
        assertEquals(expected, stringList.add(string));


    }

    @org.junit.jupiter.api.Test
    void testAdd_IndexValidIndex() {
        //      входящие данные
        addInArray();
        int index1 = 2;

        String string = "hello";
//        ожидаемый результат

        String expectedMassage = "Номер индекса меньше 0 или больше размера массива";
//        начало теста
        Exception exception = Assertions.assertThrows(InvalidIndexException.class, () ->stringList.add(index1,string));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
        clearInArray();
    }
    @org.junit.jupiter.api.Test
    void testAdd_IndexValidateItem() {
        //        входящие данные
        addInArray();
        int index1 = 0;
        String string = null;
//        ожидаемый результат
        String expectedMassage = "Принимаемый объект равен null";
//        начало теста
        Exception exception = Assertions.assertThrows(NullItemException.class, () -> stringList.add(index1,string));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
        clearInArray();
    }

        @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void set() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
        //            входящие данные
        addInArray();
        String string = "hello";
//        ожидаемый результат
        boolean expected = true;
//        начало теста
        assertEquals(expected, stringList.contains(string));
        clearInArray();

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    private void addInArray() {
        stringList.add("hello");
        stringList.add("hello2");

    } private void clearInArray() {
        stringList.clear();

    }
}