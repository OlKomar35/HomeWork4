package com.komar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Box<Fruit> box1 = new Box<>();
        Box<Fruit> box2 = new Box<>();
        Box<Fruit> box3 = new Box<>();
        Box<Fruit> box4 = new Box<>();

        Random random = new Random();
        Apple apple = new Apple();
        Orange orange = new Orange();
        List<Fruit> list = Arrays.asList(apple, orange);

        for (int i = 0; i < 10; i++) {
            box1.addFruit(list.get(random.nextInt(list.size())));
            box2.addFruit(list.get(random.nextInt(list.size())));
            box3.addFruit(list.get(random.nextInt(list.size())));
            box4.addFruit(list.get(random.nextInt(list.size())));
        }

        System.out.print('\n' + box1.getNameBox() + ": ");
        System.out.print("Вес " + box1.getWeight() + ". ");
        box1.infoAboutBox();
        System.out.print(box2.getNameBox() + ": ");
        System.out.print("Вес " + box2.getWeight() + ". ");
        box2.infoAboutBox();
        System.out.print(box3.getNameBox() + ": ");
        System.out.print("Вес " + box3.getWeight() + ". ");
        box3.infoAboutBox();
        System.out.print(box4.getNameBox() + ": ");
        System.out.print("Вес " + box4.getWeight() + ". ");
        box4.infoAboutBox();

        System.out.println();
        printCompareBoxes(box1, box2);
        printCompareBoxes(box1, box3);
        printCompareBoxes(box1, box4);
        printCompareBoxes(box2, box3);
        printCompareBoxes(box2, box4);
        printCompareBoxes(box3, box4);

        System.out.println();
        box1.pourOut(box3);
        box1.pourOut(box2);
        box2.pourOut(box4);
        box3.pourOut(box1);
        box1.pourOut(box1);

    }

    private static void printCompareBoxes(Box<Fruit> box1, Box<Fruit> box2) {
        if (box1.compare(box2)) {
            System.out.printf("Вес коробок %s и %s совпадает \n", box1.getNameBox(), box2.getNameBox());
        } else {
            System.out.printf("Вес коробок %s и %s не совпадает \n", box1.getNameBox(), box2.getNameBox());
        }
    }


}
