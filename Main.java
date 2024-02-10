import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    int playerHP;
    String playerName;
    String weapon;
    int choice;
    Scanner input = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    int monsterHP;
    int silverRing;
    public static void main(String[] args) {
        Main game = new Main();
        game.playerSetup();
        game.playerWeapon();
        game.townGate();
    }
    public void playerSetup(){
        playerHP = 20;
        monsterHP = 25;

        System.out.println("Please Enter Your Name ");
        Scanner input = new Scanner(System.in);
        playerName = input.nextLine();
        System.out.println(playerName + " are you ready for the adventure");
        System.out.println("-----------------------------------------------------------------------------------------");
        enterScanner.nextLine();
    }
    public void playerWeapon(){


        weapon = "";
        do {
            System.out.println("\n\n\n");
            System.out.println("Choose your Weapon");
            System.out.println("\n\n");
            System.out.println("1 : Sword \n");
            System.out.println("2 : Dagger \n");
            System.out.println("3 : Bow & Arrow \n");

            choice = input.nextInt();
        }
        while (choice != 1 ^ choice != 2 ^ choice != 3 );

        switch (choice) {
            case 1 -> weapon = "Sword";
            case 2 -> weapon = "Dagger";
            case 3 -> weapon = "Bow & Arrow";
            default -> weapon = "No weapon";
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Your Weapon is " + weapon);
        enterScanner.nextLine();
    }
    public void townGate(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("You are at the Entrance of the mystical land called Denarnia \n");
        enterScanner.nextLine();
        System.out.println("A guard is standing in front of you \n");
        enterScanner.nextLine();
        System.out.println("What Do you want to do ? \n");

        System.out.println("\n\n\n");
        do{
            System.out.println("1 : Talk with the Guard");
            System.out.println("2 : Attack the Guard");
            System.out.println("3 : Leave");

            choice = input.nextInt();
        } while (choice != 1 ^ choice != 2 ^ choice != 3);

        switch (choice){
            case 1 -> {
                if (silverRing >= 1) ending();
                else {
                    System.out.println("Guard : Hello there stranger ! \nSo your name is " + playerName + "\nSorry but we cannot let strangers enter into our town");
                    enterScanner.nextLine();
                    townGate();
                }
            }
            case 2 -> {
                playerHP -= 1;
                System.out.println("Guard : Hey don't be stupid \nThe Guard hit you so hard you gave up. \n (You received one damage");
                System.out.println("Your HP : " + playerHP);
                enterScanner.nextLine();
                townGate();
            }
            case 3 -> middleOfNowhere();
            default -> townGate();
        }


    }
    public void middleOfNowhere(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("You are at the middle of nowhere. If you south you return back to the Denarnia.\n\n");
        System.out.println("Where do you want go ?\n\n");

        System.out.println("1 : Go North");
        System.out.println("2 : Go South");
        System.out.println("3 : Go East");
        System.out.println("4 : Go West");

        choice = input.nextInt();


        switch (choice){
            case 1 -> north();
            case 2 -> townGate();
            case 3 -> east();
            case 4 -> west();
            default -> middleOfNowhere();

        }
    }
    public void north(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("There is Himalayas in the North. You train and meditate there to recover your HP.");
        enterScanner.nextLine();
        System.out.println("Your HP is recovered");
        if (playerHP < 20) playerHP += 1;

        enterScanner.nextLine();
        System.out.println("Your HP : " + playerHP);
        enterScanner.nextLine();
        System.out.println("\n\n1 : Go back to Middle of Nowhere");
        System.out.println("\n----------------------------------------------------------------------------------------\n");

        choice = input.nextInt();

        if ( choice == 1){
            middleOfNowhere();
        }else north();
    }
    public void east(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println(playerName + " You came to the greatest armoury in the eastern world.");
        enterScanner.nextLine();
        System.out.println("You found a new weapon : Sword of Destruction");
        System.out.println("You want to keep it or not.");

        do {
            System.out.println("(1/0) : To keep it or not");

            choice = input.nextInt();
        } while (!(choice == 1 | choice == 0));



        if (choice == 1){
            weapon = "Sword Of Destruction";
            System.out.println("Your Weapon is " + weapon);
        }

        System.out.println("1 : Go back to Middle of Nowhere");
        System.out.println("\n----------------------------------------------------------------------------------------\n");

        choice = input.nextInt();

        if (choice == 1) middleOfNowhere();
        else north();

    }
    public void west(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("You encounter a Goblin.\n");
        enterScanner.nextLine();
        System.out.println("1 : Fight");
        System.out.println("2 : Run");

        choice = input.nextInt();

        switch (choice){
            case 1 -> fight();
            case 2 -> middleOfNowhere();
            default -> west();
        }

    }
    public void fight(){
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("Your HP : " + playerHP);
        System.out.println("Monster HP : " + monsterHP);
        System.out.println("\n1 : Attack");
        System.out.println("2 : Run");
        System.out.println("\n----------------------------------------------------------------------------------------\n");

        choice = input.nextInt();

        switch (choice){
            case 1 -> attack();
            case 2 -> middleOfNowhere();
            default -> west();
        }
    }
    public void attack(){
        int playerDamage = 0;

        if (weapon.equals("Sword") || weapon.equals("Dagger") || weapon.equals("Bow & Arrow")) {
            playerDamage = new java.util.Random().nextInt(5);
        } else if (weapon.equals("Sword Of Destruction")) {
            playerDamage = new java.util.Random().nextInt(8);
        }

        System.out.println("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        System.out.println("Monster HP : " + monsterHP);

        if (monsterHP < 1) {
            win();
        } else {
            int monsterDamage;

            monsterDamage = new java.util.Random().nextInt(5);

            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");

            playerHP = playerHP - monsterDamage;

            System.out.println("Player HP: " + playerHP);

            if (playerHP < 1) dead();
            else fight();
        }
    }


    public void dead() {
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("You are dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n----------------------------------------------------------------------------------------\n");

    }
    public void win() {
        System.out.println("\n----------------------------------------------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtained a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n----------------------------------------------------------------------------------------\n");

        silverRing = 1;

        choice = input.nextInt();
        if (choice == 1) middleOfNowhere();
        else win();
    }
    public void ending() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}