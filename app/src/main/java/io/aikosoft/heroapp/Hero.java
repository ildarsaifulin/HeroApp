package io.aikosoft.heroapp;

import java.io.Serializable;

public class Hero implements Serializable {
    final String name;
    final int age;
    final String powerType;
    final int image;

    public Hero(String name, int age, String powerType, int image) {
        this.name = name;
        this.age = age;
        this.powerType = powerType;
        this.image = image;
    }
}
