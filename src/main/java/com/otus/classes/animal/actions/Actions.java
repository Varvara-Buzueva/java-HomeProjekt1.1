package com.otus.classes.animal.actions;

import com.otus.classes.animal.Animal;
import com.otus.classes.animal.birds.Duck;
import com.otus.classes.animal.data.EAnimalKind;
import com.otus.classes.animal.pets.Cat;
import com.otus.classes.animal.pets.Dog;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Actions {
    private static void generatePet(Animal animal, Scanner scanner) {
        System.out.println("Введите имя");
        animal.setName(scanner.next());

        System.out.println("Введите возрат");
        animal.setAge(scanner.nextInt());

        System.out.println("Введите вес");
        animal.setWeight(scanner.nextInt());

        System.out.println("Введите цвет");
        animal.setColor(scanner.next());
    }

    public void addAnimal(List<Animal> pets) {

        System.out.println("Исполнение команды Добавить");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите тип животного (Cat/Dog/Duck):");
            String choose = sc.next().trim().toUpperCase(Locale.ROOT);

            if (!(choose.equals(EAnimalKind.CAT.toString()) || choose.equals(EAnimalKind.DOG.toString()) || choose.equals(EAnimalKind.DUCK.toString()))) {
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
            System.out.println(" в список добавленно " + pets.get(pets.size() - 1).toString());
            break;
        }
    }

    public void showAnimals(List<Animal> pets) {
        System.out.println("Текущий список:");
        for (Animal pet : pets) {
            System.out.println(pet.toString());
        }
    }

    public void exit(){ System.out.println("До свидания!"); }
}
