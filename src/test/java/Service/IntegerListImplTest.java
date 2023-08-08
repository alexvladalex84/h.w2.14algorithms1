package Service;

import org.example.Exeption.NullItemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    IntegerList integerList = new IntegerListImpl();
    @Test
    void testAdd_success() {
        //      входящие данные
        addInArray();               //тут же проверка на расширение массива
        Integer integer = 55;
//        ожидаемый результат
      Integer expected = integer;
//        начало теста
        assertEquals(expected, integerList.add(integer));
        clear();
    }

    @Test
    void add_IndexValidateItem() {
        //        входящие данные
        Integer integer = null;

//        ожидаемый результат
        String expectedMassage = "Принимаемый объект равен null";
//        начало теста
        Exception exception = Assertions.assertThrows(NullItemException.class, () ->integerList .add(integer));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains_success() {
//            входящие данные
        addInArray();
        integerList.add(125);
        Integer integer = 125;
//        ожидаемый результат
        boolean expected = true;
//        начало теста
        assertEquals(expected, integerList.contains(integer));
        clearInArray();
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
    private void addInArray() {
        integerList.add(85);
        integerList.add(100);
        integerList.add(126);
        integerList.add(20);
        integerList.add(50);
        integerList.add(95);
        integerList.add(60);
        integerList.add(120);
        integerList.add(119);
        integerList.add(128);
//        integerList.add(101);
//        integerList.add(103);
        integerList.add(140);

    } private void clearInArray() {
        integerList.clear();

    }
}