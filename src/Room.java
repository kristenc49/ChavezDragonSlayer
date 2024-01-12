public class Room {
    private String roomName;
    private int dragonsSpawned;
    private boolean searchedRoom;

    public Room() {
        roomName = "";
        dragonsSpawned = (int)(Math.random() * 3) + 1; // should be 1, 2, or 3

    }
}
