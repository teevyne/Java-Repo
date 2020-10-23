package oOAD.chapter2Two;

public class DogDoorSimulator {

    public static void main(String[] args) {
        DogDoor dogDoor = new DogDoor();
        Remote remote = new Remote(dogDoor);

        System.out.println("Dog barks to go outside");
        remote.pressButton();

        System.out.println("Dog has gone outside");
//        remote.pressButton();

        System.out.println("Dog is all done");
//        remote.pressButton();
        try{
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e){

        }

        System.out.println("...but he is stuck outside");
        System.out.println("Fido starts barking...\n...so Gina picks up the remote");
        remote.pressButton();

        System.out.println("Dog is back inside");
//        remote.pressButton();
    }
}
