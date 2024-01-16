public class Room {
    private String roomName;
    private int dragonsSpawned;
    private boolean searchedRoom;

    public Room() {
        roomName = "";
        dragonsSpawned = (int)(Math.random() * 3) + 1; // should be 1, 2, or 3
        searchedRoom = false;

    }

    public void enterRoom() {

    }
    public void searchRoom() { // determines if health pot was found
        double num = Math.random();
        if (num <= 0.5 && !Player.getHealthPotStatus()) {
            System.out.println("You've found a health pot!");
            Player.setHealthPotStatus(true);
        } else {
            System.out.println("No health pot here.");
            Player.setHealthPotStatus(false);
        }
        searchedRoom = true; // room was searched
    }
}
