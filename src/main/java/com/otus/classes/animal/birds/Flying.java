package com.otus.classes.animal.birds;

import com.otus.classes.animal.Animal;

public class Flying extends Animal implements IFlying {
    public void fly() {
        System.out.println("Я лечу!");
    }
}
