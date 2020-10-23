package oOAD.chapter3Three;

public class DogDoorSimulator {

    public static void main(String[] args) {
        DogDoor dogDoor = new DogDoor();
        BarkRecognizer barkRecognizer = new BarkRecognizer(dogDoor);
//        Remote remote = new Remote(dogDoor);

        // Simulate a barking
        System.out.println("Dog barks to go outside");
//        remote.pressButton();
        barkRecognizer.recognise("Woof");

        System.out.println("Dog has gone outside");
//        remote.pressButton();

        System.out.println("Dog is all done");
//        remote.pressButton();
        try{
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e){

        }

        System.out.println("...but he is stuck outside");
        // Simulate barking again but this time, no remote pressing
//        System.out.println("Fido starts barking...\n...so Gina picks up the remote");
        System.out.println("Fido starts barking");
//        remote.pressButton();
        barkRecognizer.recognise("WOof");

        System.out.println("Dog is back inside");
//        remote.pressButton();
//        dogDoor.close();
    }
}
