import java.util.Scanner;
public class Room {
    private String roomName;
    private int dragonsLeft;
    private boolean searchedRoom;
    public boolean isCleared;
    public Scanner scan;


    public Room(String roomName, int dragonsLeft) {
        this.roomName = roomName;
        this.dragonsLeft = dragonsLeft;
        searchedRoom = false;
        scan = new Scanner(System.in);

    }

    public String getName() {
        return roomName;
    }

    public int getDragonsLeft() {
        return dragonsLeft;
    }

    public void setDragonsLeft(int dragonsLeft1) {
        dragonsLeft = dragonsLeft1;
    }

    public void setIsCleared(boolean cleared) {
        isCleared = cleared;
    }
    public boolean getIsCleared() {
        return isCleared;
    }

    public void searchRoom(Player player) { // determines if health pot was found
        double num = Math.random();
        if (num <= 0.5 && !player.getHealthPotStatus()) {
            System.out.println("You've found a health pot!");
            player.setHealthPotStatus(true);
            System.out.println("What would you like to do with it?");
            System.out.println("1. Use\n2. Store for later");
            if (scan.nextInt() == 1) {
                player.useHealthPot();
                System.out.println("You've used your health pot and gain 50 health.");
            } else {
                System.out.println("You've stored the health pot for later use.");
                player.setHealthPotStatus(true);
            }
        } else {
            System.out.println("No health pot here.");
            player.setHealthPotStatus(false);
        }
        searchedRoom = true; // room was searched
    }

    public void enterRoom(Player player, Dragon dragon) {
        if (dragonsLeft > 0 && dragon.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("You enter " + roomName + ".");
        }
        if (!isCleared) {
            while (dragonsLeft > 0 && dragon.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("Dragons remaining in " + roomName + ": " + dragonsLeft);
                System.out.println("Gold: " + player.getGold());
                System.out.println("Player health: " + player.getHealth());
                System.out.println("Dragon health: " + dragon.getHealth());
                System.out.println("Dragon Level: " + dragon.getDragonLVL());
                if (player.getHealthPotStatus()) {
                    System.out.println("Heatlh Pots: 1");
                }
                System.out.println();
                System.out.println("What do you decide to do?");
                System.out.println("1. Attack" + "\n2.Search room for health pot" + "\n3. Check Sword Stats");
                if (player.getHealthPotStatus()) {
                    System.out.println("4. Use Health Pot");
                }

                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                while (!(choice == 1) && !(choice == 2) && !(choice == 3) && !(choice == 4)) {
                    System.out.println("Invalid choice. Try again.");
                }
                if (choice == 1) {
                    player.attack(dragon);
                    dragon.dragonAttack(player);
                } else if (choice == 2) {
                    if (!searchedRoom) {
                        searchRoom(player);
                    } else {
                        System.out.println("This room has already been searched.");
                    }
                } else if (choice == 4 && player.getHealthPotStatus()){
                    player.useHealthPot();
                    System.out.println("You've used your health pot and gained 50 health.");
                } else if (choice == 3) {
                    System.out.println("Sword Attack Power: " + player.getSword().getAttackPower());
                    System.out.println("Sword Dodge Rating: " + player.getSword().getDodgeRating());
                }
            }
            dragonsLeft--;
            if (player.getHealth() > 0) {
                System.out.println("The dragon has been slain!");
                dragon.dead(player);
                System.out.println();
                if (dragonsLeft == 0) {
                    isCleared = true;
                }
            } else {
                System.out.println("Game over! The dragon defeated you.");
            }
        } else if (isCleared) {
            System.out.println("This room has already been cleared.");
        } else {
            System.out.println();
        }
    }

    public void fightDragon(Player player, Dragon dragon) {
        System.out.println("A level " + dragon.getDragonLVL() + " has appeared.");
        while (player.getHealth() > 0 && dragon.getHealth() > 0) {
            player.attack(dragon);
            dragon.dragonAttack(player);
        }
    }
}
