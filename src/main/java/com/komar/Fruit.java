package com.komar;

public abstract class Fruit {
    float weight;
    public Fruit(float weight) {
        this.weight=weight;
    }

    public float getWeightFruit() {
        return weight;
    }

    @Override
    public String toString() {
        return "Фрукт - весом"+ weight + " кг";
    }
}
