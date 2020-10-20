package oOAD.chapterTwo;

public class DogDoorSimulator {

    public static void main(String[] args) {
        DogDoor dogDoor = new DogDoor();
        Remote remote = new Remote(dogDoor);

        System.out.println("Dog barks to go outside");
        remote.pressButton();

        System.out.println("Dog has gone outside");
        remote.pressButton();

        System.out.println("Dog is all done");
        remote.pressButton();

        System.out.println("Dog is back inside");
        remote.pressButton();
    }
}
