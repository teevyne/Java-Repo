package oOAD.chapter3Three;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door){
        this.door = door;
    }

    public void recognise(String bark){
        System.out.println(" Bark recognizer: Heard a '" + bark + "'");
        door.open();
    }
}
