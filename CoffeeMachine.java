package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static Scanner scanner = new Scanner(System.in);

    public static boolean isRunning = true;

    public static int moneyInMachine = 550;
    public static int waterInMachine = 400;
    public static int milkInMachine = 540;
    public static int beansInMachine = 120;
    public static int cupsInMachine = 9;

    public static State currentState = State.CHOOSING_AN_ACTION;

    public static void main(String[] args) {
        while (isRunning) {
            programRuns(currentState);
        }
    }

    enum State {
        CHOOSING_AN_ACTION, CHOOSING_A_COFFEE, FILLING_MACHINE, TAKING_MONEY
    }

    public static void programRuns(State state) {
        switch (state) {
            case CHOOSING_AN_ACTION:
                System.out.println("Write action (buy, fill, remaining, exit):");
                String action = scanner.nextLine();
                switch (action) {
                    case "buy":
                        currentState = State.CHOOSING_A_COFFEE;
                        break;
                    case "fill":
                        currentState = State.FILLING_MACHINE;
                        break;
                    case "take":
                        currentState = State.TAKING_MONEY;
                        break;
                    case "remaining":
                        printInventory();
                        break;
                    case "exit":
                        isRunning = false;
                        break;
                }
                break;
            case CHOOSING_A_COFFEE:
                buy();
                currentState = State.CHOOSING_AN_ACTION;
                break;
            case FILLING_MACHINE:
                fill();
                currentState = State.CHOOSING_AN_ACTION;
                break;
            case TAKING_MONEY:
                take();
                currentState = State.CHOOSING_AN_ACTION;
                break;
        }
    }

    public static void buy() {
        boolean enoughCups = cupsInMachine >= 1;

        int waterForEspresso = 250;
        int beansForEspresso = 16;
        int costOfEspresso = 4;
        boolean enoughForEspresso = waterInMachine >= waterForEspresso && beansInMachine >= beansForEspresso && enoughCups;

        int waterForLatte = 350;
        int milkForLatte = 75;
        int beansForLatte = 20;
        int costOfLatte = 7;
        boolean enoughForLatte = waterInMachine >= waterForLatte && milkInMachine >= milkForLatte && beansInMachine >= beansForLatte && enoughCups;

        int waterForCappuccino = 200;
        int milkForCappuccino = 100;
        int beansForCappuccino = 12;
        int costOfCappuccino = 6;
        boolean enoughForCappuccino = waterInMachine >= waterForCappuccino && milkInMachine >= milkForCappuccino && beansInMachine >= beansForCappuccino && enoughCups;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        String coffeeType = scanner.nextLine();

        switch (coffeeType) {
            case "1":
                if (enoughForEspresso) {
                    waterInMachine -= waterForEspresso;
                    beansInMachine -= beansForEspresso;
                    moneyInMachine += costOfEspresso;
                    cupsInMachine -= 1;
                    printEnoughResources();
                } else if (waterForEspresso > waterInMachine) {
                    printNotEnoughWater();
                } else if (beansForEspresso > beansInMachine) {
                    printNotEnoughBeans();
                } else if (cupsInMachine < 1) {
                    printNotEnoughCups();
                }
                break;
            case "2":
                if (enoughForLatte) {
                    waterInMachine -= waterForLatte;
                    milkInMachine -= milkForLatte;
                    beansInMachine -= beansForLatte;
                    moneyInMachine += costOfLatte;
                    cupsInMachine -= 1;
                    printEnoughResources();
                } else if (waterForLatte > waterInMachine) {
                    printNotEnoughWater();
                } else if (milkForLatte > milkInMachine) {
                    printNotEnoughMilk();
                } else if (beansForLatte > beansInMachine) {
                    printNotEnoughBeans();
                } else if (cupsInMachine < 1) {
                    printNotEnoughCups();
                }
                break;
            case "3":
                if (enoughForCappuccino) {
                    waterInMachine -= waterForCappuccino;
                    milkInMachine -= milkForCappuccino;
                    beansInMachine -= beansForCappuccino;
                    moneyInMachine += costOfCappuccino;
                    cupsInMachine -= 1;
                    printEnoughResources();
                } else if (waterForCappuccino > waterInMachine) {
                    printNotEnoughWater();
                } else if (milkForCappuccino > milkInMachine) {
                    printNotEnoughMilk();
                } else if (beansForCappuccino > beansInMachine) {
                    printNotEnoughBeans();
                } else if (cupsInMachine < 1) {
                    printNotEnoughCups();
                }
                break;
            case "back":
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        waterInMachine += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milkInMachine += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        beansInMachine += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupsInMachine += scanner.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $" + moneyInMachine);
        moneyInMachine = 0;
    }

    public static void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInMachine + " of water");
        System.out.println(milkInMachine + " of milk");
        System.out.println(beansInMachine + " of coffee beans");
        System.out.println(cupsInMachine + " of disposable cups");
        System.out.println(moneyInMachine + " of money");
        System.out.println("");
    }

    public static void printEnoughResources() {
        System.out.println("I have enough resources, making you a coffee!");
    }

    public static void printNotEnoughWater() {
        System.out.println("Sorry, not enough water!");
    }

    public static void printNotEnoughMilk() {
        System.out.println("Sorry, not enough milk!");
    }

    public static void printNotEnoughBeans() {
        System.out.println("Sorry, not enough coffee beans!");
    }

    public static void printNotEnoughCups() {
        System.out.println("Sorry, not enough disposable cups!");
    }
}
