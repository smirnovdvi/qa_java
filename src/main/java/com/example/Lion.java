package com.example;

import java.util.List;

public class Lion {

    private final Predator predator;
    private boolean hasMane;

    public Lion(Predator predator, String sex) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        // Здесь используем метод getKittens из предатора
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.getFood("Хищник");
    }
}
