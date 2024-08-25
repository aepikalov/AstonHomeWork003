import Collection.MyArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(3);
        list.add(10);
        list.add(12);
        list.add(0);
        list.add(5);
        System.out.println("Изначальный список: " + list);
        System.out.println("Удаление элементов: " + list.get(2) + ", " + list.get(3));
        list.remove(2);
        list.remove(2);
        System.out.println("Измененный список: " + list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(4);
        list1.add(6);
        list1.add(11);
        list1.add(8);
        System.out.println("Вторая коллекция: " + list1);
        list.addAll(list1);
        System.out.println("Добавтение второй коллекции к первой: " + list);
        MyArrayList<Integer> list2 = new MyArrayList<>(list1);
        System.out.println("Создание третьей коллекции из второй: " + list2);
        System.out.println("Сортировка второй коллекции " + Arrays.toString(MyArrayList.bubbleSort(list1)));

    }
}