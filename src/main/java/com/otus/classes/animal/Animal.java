package com.otus.classes.animal;

import java.util.ArrayList;

public abstract class Animal implements IAnimal {

    private String name ;
    private int age;
    private int weight;
    private String color;
    private ArrayList<Integer> NumberToDigits(int number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        ArrayList<Integer> cia = new ArrayList<>();
        for (char value : charArray) {
            int c = Character.getNumericValue(value);
            cia.add(c);
        }
        return cia;
    }

    private int getDecades(){
        ArrayList<Integer> digits = NumberToDigits(age);
        return (digits.size() < 2) ? 0 : digits.get(digits.size() - 2);
    }

    private int getYears(){
        ArrayList<Integer> digits = NumberToDigits(age);
        return digits.get(digits.size() - 1);
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void Drink() { System.out.println("Я пью"); }
    public void Eat(){ System.out.println("Я ем"); }
    public void Go () { System.out.println("Я иду"); }
    public void Say () { System.out.println("Я говорю"); }

    @Override
    public String toString() {
        String age_postfix = "";
        int decade = getDecades();
        int year = getYears();
        if (decade == 1){ age_postfix = "лет";}
        else {
            age_postfix = switch (year) {
                case 1 -> "год";
                case 2, 3, 4 -> "года";
                case 5, 6, 7, 8, 9 -> "лет";
                default -> age_postfix;
            };
        }

        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name, age, age_postfix, weight, color);
    }
}
