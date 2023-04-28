package machine;

import java.util.Scanner;

public class initialSolutionAllInOneCoffeeMachine {

    public static Scanner scanner = new Scanner(System.in);
    public static Scanner mainChoice = new Scanner(System.in);
    // public static Scanner backChoice = new Scanner(System.in);
    // Current Supplies
    public static int waterAmount = 400;
    public static int milkAmount = 540;
    public static int coffeeBeansAmount = 120;
    public static int shopMoney = 550;
    public static int ownerMoney = 0;
    public static int disposableCups = 9;
    public static boolean machineOn = true;

    // Measurements
    public static int esprssWtrAmnt = 250;
    public static int esprssMlkAmnt = 0;
    public static int esprssCfBnsAmnt = 16;
    public static int esprssCost = 4;
    public static int latteWtrAmnt = 350;
    public static int latteMlkAmnt = 75;
    public static int latteCfBnsAmnt = 20;
    public static int latteCost = 7;
    public static int cappuccnWtrAmnt = 200;
    public static int cappuccnMlkAmnt = 100;
    public static int cappuccnCfBnsAmnt = 12;
    public static int cappuccnCost = 6;

    // Miscellaneous
    public static int coffeeCupCount = 0;
    public static int customersCupsOfCoffee = 0;

    public static void main(String[] args) {

        while (machineOn) {

            greetCommands();

        }

    }

    public static void greetCommands() {

        System.out.println("Write action (buy, fill, remaining, take, exit): ");
        String uChoice = mainChoice.nextLine();

        switch (uChoice) {
            case "buy":
                buyCoffeeOffers();
                break;

            case "fill":
                fillSupplies();
                break;

            case "take":
                takeAllTheMoney();
                break;

            case "remaining":
                showSuppliesInfo();
                break;

            case "exit":
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input, please try again");
                break;

        }
    }

    public static void coffeeTransaction(int coffeeWAmnt, int coffeeMAmnt, int coffeeTypeBnsAmnt, int coffeeTypeCost) {

        if (coffeeWAmnt <= waterAmount && coffeeMAmnt <= milkAmount
                && coffeeTypeBnsAmnt <= coffeeBeansAmount && customersCupsOfCoffee <= disposableCups) {
            System.out.println("I have enough resources, making you a coffee!");
            waterAmount -= coffeeWAmnt;
            milkAmount -= coffeeMAmnt;
            coffeeBeansAmount -= coffeeTypeBnsAmnt;
            shopMoney += coffeeTypeCost;
            disposableCups -= 1;

        } else if (coffeeWAmnt > waterAmount) {
            System.out.println("Sorry, not enough water!");

        } else if (coffeeMAmnt > milkAmount)

        {
            System.out.println("Sorry, not enough milk!");
        }

        else if (coffeeTypeBnsAmnt > coffeeBeansAmount) {
            System.out.println("Sorry, not enough coffee beans!");
        }

        else if (customersCupsOfCoffee > disposableCups) {
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void refillSuppliesToDefault() {
        waterAmount = 400;
        milkAmount = 540;
        coffeeBeansAmount = 120;

    }

    public static void showSuppliesInfo() {
        System.out.println("The coffee machine has:\n" + waterAmount + " ml of water\n" + milkAmount
                + " ml of milk\n" + coffeeBeansAmount + " g of coffee beans\n" + disposableCups
                + " disposable cups\n$" + shopMoney + " of money\n");
    }

    public static void takeAllTheMoney() {
        // add logic
        ownerMoney = shopMoney;
        shopMoney = 0;
        System.out.println("I gave you $" + ownerMoney + "\n");
    }

    public static void fillSupplies() {
        System.out.println("Write how many ml of water you want to add: ");
        // add logic
        String uInputToInt = scanner.next();
        int uInput = Integer.parseInt(uInputToInt);
        waterAmount += uInput;

        System.out.println("Write how many ml of milk you want to add: ");

        uInputToInt = scanner.next();
        uInput = Integer.parseInt(uInputToInt);
        milkAmount += uInput;

        System.out.println("Write how many grams of coffee beans you want to add: ");

        uInputToInt = scanner.next();
        uInput = Integer.parseInt(uInputToInt);
        coffeeBeansAmount += uInput;
        System.out.println("Write how many disposable cups you want to add: ");

        uInputToInt = scanner.next();
        uInput = Integer.parseInt(uInputToInt);
        disposableCups += uInput;

    }

    public static void buyCoffeeOffers() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");

        String uInputCoffee = scanner.next();

        while (!uInputCoffee.equals("back")) {

            // int uInput = Integer.parseInt(uInputCoffee);
            if (uInputCoffee.equals("1")) {
                coffeeTransaction(esprssWtrAmnt, esprssMlkAmnt, esprssCfBnsAmnt, esprssCost);
                break;
                
            } else if (uInputCoffee.equals("2")) {
                coffeeTransaction(latteWtrAmnt, latteMlkAmnt, latteCfBnsAmnt, latteCost);
                break;
            } else if (uInputCoffee.equals("3")) {
                coffeeTransaction(cappuccnWtrAmnt, cappuccnMlkAmnt, cappuccnCfBnsAmnt, cappuccnCost);
                break;
            } else {
                System.out.println("Invalid input");
                buyCoffeeOffers();
                break;
            }
        }

        greetCommands();
    }
}