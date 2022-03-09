package com.otus.classes.animal.pets;

import com.otus.classes.animal.Animal;

public class Cat extends Animal {

    @Override
    protected void say() {
        System.out.println("Мяу");
    }
}