package oOAD.chapterTwo;

public class DogDoor {

    private boolean open;


    public DogDoor(){
        this.open = false;
    }

    // Opens the door
    public void open(){
        System.out.println("The dog door opens");
        open = true;
    }

    // Closes the door
    public void close(){
        System.out.println("The dog door closes");
        open = false;
    }

    // sets the state of the door open or close
    public boolean isOpen(){
        return open;
    }
}
