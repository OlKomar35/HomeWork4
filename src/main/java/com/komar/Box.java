package com.komar;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private String nameBox;
    private int id;
    private static int idCount;
    private List<T> box;

    {
        id = ++idCount;
    }

    public String getNameBox() {
        return nameBox;
    }

    public Box() {
        this.box = new ArrayList<>();
        nameBox = "box " + id;
    }

    public int size() {
        return this.box.size();
    }

    public void addFruit(T fruit) {
        if (this.box.isEmpty()) {
            this.box.add(fruit);
        } else if ((this.box.get(0) instanceof Apple) && (fruit instanceof Apple)) {
            this.box.add(fruit);
        } else if ((this.box.get(0) instanceof Orange) && (fruit instanceof Orange)) {
            this.box.add(fruit);
        }
    }

    public float getWeight() {
        float boxWeight = 0;
        if (box.size() > 0) {
            boxWeight = box.size() * box.get(0).getWeightFruit();
        }
        return boxWeight;
    }

    public void infoAboutBox() {
        if (this.box.get(0) instanceof Apple)
            System.out.println("В коробке яблоки, " + (this.box.size()) + " шт");
        else
            System.out.println("В коробке апельсины, " + (this.box.size()) + " шт");
    }

    public boolean compare(Box<T> boxCompare) {
        if (boxCompare.getWeight() == getWeight())
            return true;
        else
            return false;
    }

    private T get(int i) {
        return this.box.get(i);
    }

    private T remove(int i) {
        return this.box.remove(i);
    }

    public void pourOut(Box<T> boxOut) {
        int sizeBoxOut = boxOut.size();
        if (!boxOut.getNameBox().equals(getNameBox())) {
            if (box.size() != 0) {
                if ((this.box.get(0) instanceof Apple) && ((boxOut.get(0) instanceof Apple) || boxOut.size() == 0)) {
                    for (int i = 0; i < sizeBoxOut; i++) {
                        this.box.add(boxOut.get(0));
                        boxOut.remove(0);
                    }
                    System.out.printf("Все прошло удачно в коробке %s яблок %d, а коробка %s - пустая\n",
                            getNameBox(), box.size(), boxOut.getNameBox());
                } else if ((this.box.get(0) instanceof Orange) && ((boxOut.get(0) instanceof Orange) || boxOut.size() == 0)) {
                    for (int i = 0; i < sizeBoxOut; i++) {
                        this.box.add(boxOut.get(0));
                        boxOut.remove(0);
                    }
                    System.out.printf("Все прошло удачно в коробке %s апельсинов %d, а коробка %s - пустая\n",
                            getNameBox(), box.size(), boxOut.getNameBox());
                } else {
                    System.out.println("Нельзя пересыпать в коробках разные фрукты");
                }
            } else {
                System.out.println("Коробка из которой хотите пересыпать пустая");
            }
        } else {
            System.out.println("Зачем вы пытаетесь пересыпать содержимое коробки в эту же коробку ?!");
        }
    }
}
