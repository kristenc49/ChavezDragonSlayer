import java.sql.SQLOutput;
import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Room[] rooms;
    private int currentRoomIdx;
    private int topScore;
    Scanner scan = new Scanner(System.in);

    public DragonSlayer() {
        this.player = new Player("Player1");
        this.rooms = new Room[5];
        this.topScore = 0;
        rooms[0] = new Room("The Cave",1);
        rooms[1] = new Room("The Den", 1);
        rooms[2] = new Room("The Hatchery", 2);
        rooms[3] = new Room("The Lair", 2);
        rooms[4] = new Room("The Lab", 3);
        this.currentRoomIdx = 0;
    }

    public void mainMenu() {
        System.out.println("--------------------");
        System.out.println("1. Start a New Game");
        System.out.println("2. View Top Score");
        System.out.println("3. Quit);");
        System.out.println("---------------------");
        int choice = scan.nextInt();
        if (choice == 1) {
            startNewGame();
        } else if (choice == 2) {
            viewTopScore();
        } else if (choice == 3) {
            quitGame();
        } else {
            System.out.println("Invalid choice. Please enter a valid one.");
        }
    }

    private void startNewGame() {
        System.out.println("New game started.");
        player = new Player("Player1");
        currentRoomIdx = 0;
        playGame();
    }

    private void playGame() {
        while (currentRoomIdx < rooms.length) {
            Room currentRoom = rooms[currentRoomIdx];
            if (!currentRoom.getIsCleared()) {
                currentRoom.enterRoom(player);
            }

            if (player.getHealth() <= 0) {
                System.out.println("You've been slayed by the dragon.");
                break; // cancels the loop
            }

            if (currentRoom.getDragonsLeft() == 0) {
                currentRoom.setIsCleared(true);
                System.out.println("You've cleared the room! Moving to the next room.");
                currentRoomIdx++;
            }
        }

        if (currentRoomIdx == rooms.length) {
            System.out.println("You've successfully cleared all rooms.");
        }
    }

    private int calculateScore() {
        return player.getGold();
    }
    private void updateTopScore(int currentScore) {
        if (currentScore > topScore) {
            topScore = currentScore;
            System.out.println("New top score: " + topScore);
        }
    }

    public void play() {
        System.out.println("Welcome to Dragon Slayer!");
        mainMenu();
    }
}
