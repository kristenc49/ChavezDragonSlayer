import java.util.Scanner;
public class Room {
    private String roomName;
    private int dragonsLeft;
    private boolean searchedRoom;
    public boolean isCleared;


    public Room(String roomName, int dragonsLeft) {
        this.roomName = roomName;
        this.dragonsLeft = dragonsLeft;
        searchedRoom = false;

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
        } else {
            System.out.println("No health pot here.");
            player.setHealthPotStatus(false);
        }
        searchedRoom = true; // room was searched
    }

    public void enterRoom(Player player) {
        if (!isCleared) {
            System.out.println("You enter " + roomName + ".");
            while (dragonsLeft > 0 && player.getHealth() > 0) {
                System.out.println("Dragons remaining in " + roomName + ":" + dragonsLeft);
                System.out.println("What do you decide to do?");
                System.out.println("1. Attack" + "\n2.Search room for health pot");

                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                while (!(choice == 1) && !(choice == 2)) {
                    System.out.println("Invalid choice. Try again.");
                }
                if (choice == 1) {
                    player.attack(new Dragon());
                } else {
                    if (!searchedRoom) {
                        searchRoom(player);
                    } else {
                        System.out.println("This room has already been searched.");
                    }
                }
            }
            if (player.getHealth() > 0) {
                System.out.println("Good job! You have cleared the room.");
                isCleared = true;
            } else {
                System.out.println("Game over! The dragon defeated you.");
            }
        } else {
            System.out.println("This room has already been cleared.");
        }
    }

    public void fightDragon(Player player, Dragon dragon) {
        System.out.println("A level " + dragon.getDragonLVL() + " has appeared.");
    }
}
