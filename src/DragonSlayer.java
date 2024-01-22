
import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Room[] rooms;
    private int currentRoomIdx;
    private int topScore;
    private int choice;
    Scanner scan = new Scanner(System.in);

    public DragonSlayer() {
        this.player = new Player("Player1");
        this.rooms = new Room[5];
        this.topScore = 0;
        initializeRooms();
    }


    public void initializeRooms() {
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
        System.out.println("3. Quit;");
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
//        DragonSlayer game = new DragonSlayer();
        player = new Player("Player1");
        currentRoomIdx = 0;
        player.setGold(0);
        initializeRooms();
        playGame();
    }

    private void playGame() {
        while (currentRoomIdx < rooms.length) {
            Room currentRoom = rooms[currentRoomIdx];
            if (!currentRoom.getIsCleared()) {
                for (int i = currentRoom.getDragonsLeft(); i > 0; i--) {
                    currentRoom.enterRoom(player, new Dragon());
                }
            }

            if (player.getHealth() <= 0) {
                System.out.println("You've been slayed by the dragon.");
                currentRoomIdx = 5;
            }

            if (currentRoom.getDragonsLeft() == 0 && !(player.getHealth() <= 0)) {
                currentRoom.setIsCleared(true);
                System.out.println("You've cleared the room! Moving to the next room.");
                currentRoomIdx++;
            }
            if (currentRoomIdx == rooms.length && player.getHealth() >= 0) {
                System.out.println("You've successfully cleared all rooms.");
                System.out.println("Congratulations! Your score is " + calculateScore() + ".");
            } else {
                System.out.println("Your score is " + calculateScore());
            }
        }
        updateTopScore(calculateScore());
    }

    private int calculateScore() {
        return player.getGold() + player.getHealth();
    }
    private void updateTopScore(int currentScore) {
        if (currentScore > topScore) {
            topScore = currentScore;
            System.out.println("New top score: " + topScore);
        }
    }

    private void viewTopScore() {
        System.out.println("Top Score: " + topScore);
    }

    private void quitGame() {
        System.out.println("Thank you for playing Dragon Slayer. Goodbye.");
        System.exit(0); // exits the game
    }
    public void play() {
        Scanner scan = new Scanner(System.in);
        boolean decision = true;
        while (decision) {
            mainMenu();
            playGame();
            System.out.println("Would you like to play again? Enter yes/no if so.");
            String yes = scan.nextLine();
            while (!(yes.equals("yes")) && !(yes.equals("no"))) {
                System.out.println("Invalid choice. Please enter a valid one.");
                yes = scan.nextLine();
            }
            if (yes.equals("yes")) {
                decision = true;
            } else {
                decision = false;
            }
        }
    }
}
