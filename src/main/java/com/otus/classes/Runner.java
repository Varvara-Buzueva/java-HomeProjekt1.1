package com.otus.classes;

import java.lang.*;
import java.util.*;

import com.otus.classes.animal.Animal;
import com.otus.classes.animal.actions.Actions;
import com.otus.classes.animal.data.Commands;


public class Runner {

    private static final List<Animal> pets = new ArrayList<>();
    private static final Actions actions = new Actions();
    private static boolean isRun  = true;

    public static void main(String[] args) {


        while (isRun) {

            System.out.println("Выберете команду Add/List/Exit");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().trim().toUpperCase(Locale.ROOT);


            boolean isCorrectCommand = Arrays.stream(Commands.values()).map(Commands::name).toList().contains(choose);
            if (!isCorrectCommand) {
                System.out.println("Выберите существующую команду");
                continue;
            }


            Commands commands = Commands.valueOf(choose);

            switch (commands) {
                case ADD -> actions.addAnimal(pets);
                case LIST -> actions.showAnimals(pets);
                case EXIT -> {actions.exit(); isRun = false;}
            }
        }
        System.exit(0);
    }

}