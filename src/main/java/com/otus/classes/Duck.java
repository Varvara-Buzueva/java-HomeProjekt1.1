package com.otus.classes;

public class Duck extends Animal implements Flying{
    @Override
    public  void Say() {
        System.out.println("Кря");
    }

    @Override
    public void Fly() {
        System.out.println(" Я лечу!");
    }
}
