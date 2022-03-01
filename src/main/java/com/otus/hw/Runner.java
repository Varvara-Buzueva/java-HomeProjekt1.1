package com.otus.hw;

import java.lang.*;
import java.util.*;

import com.otus.classes.Animal;
import com.otus.classes.Cat;
import com.otus.classes.Dog;
import com.otus.classes.Duck;

public class Runner {

    public static List<Animal> pets= new ArrayList<>();

    public static void main(String[] args){


        while (true){

            System.out.println("Выберете команду Add/List/Exit");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().trim().toUpperCase(Locale.ROOT);

            if(!( choose.equals(Commands.ADD.toString()) || choose.equals(Commands.LIST.toString()) || choose.equals(Commands.EXIT.toString()))) {
                System.out.println("Выберите существующую команду");
                continue;
            }

            Commands commands = Commands.valueOf(choose);

            switch (commands) {
                case ADD -> addAnimal();
                case LIST -> showList();
                case EXIT -> {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
            }
        }
    }
    public static void addAnimal() {

        System.out.println("Исполнение команды Добавить");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Выберите тип животного (Cat/Dog/Duck):"  );
            String choose = sc.next().trim().toUpperCase(Locale.ROOT);

            if(!( choose.equals(EAnimalKind.CAT.toString()) || choose.equals(EAnimalKind.DOG.toString()) || choose.equals(EAnimalKind.DUCK.toString()))) {
                System.out.println("Выберите тип существующих животных");
                continue;
            }

            EAnimalKind kind = EAnimalKind.valueOf(choose.toUpperCase(Locale.ROOT));
            Animal newAnimal = null;


            switch (kind) {
                case CAT -> {
                    newAnimal = new Cat();
                    generatePet(newAnimal, sc);
                }
                case DOG -> {
                    newAnimal = new Dog();
                    generatePet(newAnimal, sc);
                }
                case DUCK -> {
                    newAnimal = new Duck();
                    generatePet(newAnimal, sc);
                }
            }

            pets.add(newAnimal);

            pets.get(pets.size() - 1).Say();
            // В спискок добавлено животное: собака Цуцик весом 12 кг...
            System.out.println(" в список добавленно "+pets.get(pets.size() - 1).toString());
            break;
        }
    }
    public static void generatePet(Animal animal, Scanner scanner){
        System.out.println("Введите имя");
        animal.setName(scanner.next());

        System.out.println("Введите возрат");
        animal.setAge(scanner.nextInt());

        System.out.println("Введите вес");
        animal.setWeight(scanner.nextInt());

        System.out.println("Введите цвет");
        animal.setColor(scanner.next());
    }
    public static void showList(){
        System.out.println("Текущий список:");
        for (Animal pet: pets){
            System.out.println(pet.toString());
        }
    }

}
